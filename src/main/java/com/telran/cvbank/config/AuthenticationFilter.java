package com.telran.cvbank.config;

import com.telran.cvbank.model.mongoModel.UserSessionMongoModel;
import com.telran.cvbank.repository.mongoRepository.UserSessionMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserSessionMongoRepository userSessionMongoRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        if (header != null)
        {
            UserSessionMongoModel userSession = userSessionMongoRepository.findUserSessionMongoModelByToken(header);
            if (userSession != null&&userSession.getValid()) {
            if (!userSession.getRemoteAddr().equals(request.getRemoteAddr()))
              {
                throw new UsernameNotFoundException("Unauthorized");
              }
            UserDetails userDetails = new User(
                    userSession.getEmail(),
                    userSession.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    userSession.getRoles()
                            .stream()
                            .map(x -> new SimpleGrantedAuthority(x))
                            .collect(Collectors.toList()));

            UsernamePasswordAuthenticationToken securityUserToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            (Object) null,
                            userDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(securityUserToken);
        }
    }
        filterChain.doFilter(request, response);
    }
}
