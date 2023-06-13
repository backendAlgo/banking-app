package uz.najottalim.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
<<<<<<< HEAD
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
=======
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
<<<<<<< HEAD
=======

import java.util.function.Supplier;

>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        DefaultLoginPageGeneratingFilter
<<<<<<< HEAD
//        AuthenticationManagerBuilder
//        DaoAuthenticationProvider

        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
=======
        AuthenticationManagerBuilder
                DaoAuthenticationProvider;

        http
                .csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
                        (requests) ->
                                requests
                                        .requestMatchers(HttpMethod.POST, "/accounts/register")
                                        .permitAll()
//                                        .requestMatchers("/accounts",
//                                                "/balances",
//                                                "/loans",
//                                                "/cards"
//                                        )
//                                        .authenticated()
                                        .requestMatchers(HttpMethod.DELETE,
                                                "/accounts/**",
                                                "/balances/**",
                                                "/loans/**",
                                                "/cards/**"
                                        )
                                        .hasRole("ADMIN")
                                        .requestMatchers(
                                                "/accounts/**",
                                                "/balances/**",
                                                "/loans/**",
                                                "/cards/**")
                                        .hasRole("USER")
                                        .requestMatchers(
                                                "/notices",
                                                "/contacts")
                                        .permitAll()
                                        .anyRequest()
                                        .denyAll()
                );
<<<<<<< HEAD
//        http.authorizeHttpRequests(
//                (requests) ->
//                        requests.requestMatchers(
//                                        "/accounts",
//                                        "/balances",
//                                        "/loans",
//                                        "/cards")
//                                .authenticated()
//                                .requestMatchers(
//                                        "/notices",
//                                        "/contacts")
//                                .permitAll()
//                                .anyRequest()
//                                .denyAll()
//        );
//        UserDetailsManager
//        UserDetailsService
=======
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
<<<<<<< HEAD
//
//    @Bean
=======

    //@Bean
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
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
<<<<<<< HEAD
//    // tekshir vaqtida: 12345->lajsldjalsdjalsd, bazada kelgan: 12345
=======
    // 12345 -> hash12345
    // mirshod, bazadahash12345


    // kiritdi, mirshod, 12345
    // bazada kegan username: mirshod, password: 12345
    // tekshir vaqtida: 12345->lajsldjalsdjalsd, bazada kelgan: 12345
>>>>>>> 898856bb5b024bfdc0280f323c6babf2b445cf88
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
