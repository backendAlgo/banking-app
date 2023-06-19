package uz.najottalim.bankingapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.najottalim.bankingapp.utility.JsonUtility;

import java.io.IOException;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class  JwtSecurityCheckFilter extends OncePerRequestFilter {
    private  final JsonUtility jsonUtility;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Custom-Authorization");
        if(token!=null){
            try {
                    if (jsonUtility.validate(token)){
                        String username =jsonUtility.getUsername(token);
                        Collection<? extends GrantedAuthority> authorities =jsonUtility.getAuthority(token);
                        Authentication authentication = new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                authorities
                        );
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                    else throw new  IllegalArgumentException("not cannot be validate ");
                } catch (Exception ex) {
                    log.info("Exception occurred: ", ex);
                    throw new BadCredentialsException("not correct JWT token", ex);
                } finally {
                    filterChain.doFilter(request, response);
                }
            }
        filterChain.doFilter(request,response);
        }
    }

