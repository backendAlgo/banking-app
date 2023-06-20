package uz.najottalim.bankingapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.web.cors.CorsConfiguration;
import uz.najottalim.bankingapp.Repository.RoleRepository;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
//    private final RoleRepository roleRepository;
//    private final WordSplitterFilter wordSplitterFilter;
//    private final RequestTimeFilter requestTimeFilter;
    private final CustomLoggingFilter customLoggingFilter;
    private final JwtSecurityGeneratorFilter jwtSecurityGeneratorFilter;
    private final JwtSecurityCheckFilter jwtSecurityCheckFilter;
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        DefaultLoginPageGeneratingFilter
//

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
                }).csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
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
//        UserDetailsManager
//        UserDetailsService
//        http.addFilterBefore(customLoggingFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(jwtSecurityGeneratorFilter, BasicAuthenticationFilter.class);
        http.addFilterBefore(jwtSecurityCheckFilter,BasicAuthenticationFilter.class);
//        http.addFilterBefore(requestTimeFilter, DisableEncodeUrlFilter.class);
//        http.addFilterBefore(wordSplitterFilter, BasicAuthenticationFilter.class);
//        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

//    @Bean
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


}
