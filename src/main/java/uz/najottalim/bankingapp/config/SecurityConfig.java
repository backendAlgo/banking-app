package uz.najottalim.bankingapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.HandlerMapping;
import uz.najottalim.bankingapp.custompermission.UserIdEqualPermissionEvaluator;
import uz.najottalim.bankingapp.utility.JWTUtility;


import java.util.List;
import java.util.function.Supplier;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, JWTUtility jsonUtility, CustomAuthenticationEntryPoint authenticationEntryPoint) throws Exception {
        http
                .cors(cors -> {
                    cors.configurationSource(request -> {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
                        configuration.setAllowedMethods(List.of("*"));
                        configuration.setAllowCredentials(true);
                        configuration.setAllowedHeaders(List.of("*"));
                        configuration.setExposedHeaders(List.of("Custom-Authorization"));
                        return configuration;
                    });
                })
                .csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                        (requests) ->
                                requests
                                        .requestMatchers(HttpMethod.POST, "/accounts/register")
                                        .permitAll()
                                        .requestMatchers("/user")
                                        .authenticated()
                                        .requestMatchers(HttpMethod.DELETE,
                                                "/accounts/**",
                                                "/balances/**",
                                                "/loans/**",
                                                "/cards/**"
                                        )
                                        .hasRole("ADMIN")
                                        .requestMatchers(
                                                "/balances/**",
                                                "/loans/**",
                                                "/cards/**")
                                        .hasRole("USER")
                                        .requestMatchers(
                                                "/notices",
                                                "/contacts")
                                        .permitAll()
                                        .requestMatchers("/accounts/**")
                                        .access((authSupplier, requestAuthorizationContext) -> {
                                            //TODO: xohlagan logikalarizni qilsalariz bo'ladi
                                            Authentication auth = authSupplier.get();
                                            var a = requestAuthorizationContext.getRequest().getRequestURI().split("/")[2];
                                            log.info("id: {}", a);
                                            return new AuthorizationDecision(true);
                                        })
                );
//        http.exceptionHandling(exceptionHandling -> {
//            exceptionHandling.authenticationEntryPoint()
//        })
//        http.addFilterBefore(new CustomLoggingFilter(), DisableEncodeUrlFilter.class);
        http.addFilterBefore(new JwtSecurityCheckFilter(jsonUtility), BasicAuthenticationFilter.class);
        http.addFilterAfter(new JwtSecurityGeneratorFilter(jsonUtility), BasicAuthenticationFilter.class);
//        http.formLogin(withDefaults());
        http.exceptionHandling(exceptionHandler -> {
            exceptionHandler.authenticationEntryPoint(authenticationEntryPoint);
        });
        http.httpBasic(withDefaults());
        return http.build();
    }

    //@Bean
//    public UserDetailsService myCustomerUserDetailsManager() {
//        UserDetails userDetails1 = User.builder().username("mirshod")
//                .password("12345")
//                .build();
//        UserDetails userDetails2 = User.builder().username("sherzod")
//                .password("12345")
//                .build();
////        DaoAuthenticationProvider
//        InMemoryUserDetailsManager inMemoryUserDetailsManager =
//                new InMemoryUserDetailsManager(userDetails1, userDetails2);
////        DaoAuthenticationProvider
//        return inMemoryUserDetailsManager;
//    }
    // 12345 -> hash12345
    // mirshod, bazadahash12345


    // kiritdi, mirshod, 12345
    // bazada kegan username: mirshod, password: 12345
    // tekshir vaqtida: 12345->lajsldjalsdjalsd, bazada kelgan: 12345
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    static MethodSecurityExpressionHandler methodSecurityExpressionHandler(PermissionEvaluator permissionEvaluator) {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator);
        return expressionHandler;
    }
}