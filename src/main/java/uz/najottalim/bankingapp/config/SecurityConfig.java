package uz.najottalim.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder
                DaoAuthenticationProvider;

        http
                .csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
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
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
