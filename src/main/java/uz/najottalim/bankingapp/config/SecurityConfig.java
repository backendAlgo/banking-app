package uz.najottalim.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import uz.najottalim.bankingapp.utility.JsonUtility;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                        (requests) ->
                                requests
                                        .requestMatchers(HttpMethod.POST, "/accounts/register")
                                        .permitAll()
                                        .requestMatchers(HttpMethod.GET,
                                                "/accounts/**",
                                                "/balances/**",
                                                "/loans/**",
                                                "/cards/**"
                                        )
                                        .hasRole("ADMIN")
                                        .requestMatchers(
                                                "/account/{id}",
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
        http.addFilterBefore(new RequestTimeFilter(), DisableEncodeUrlFilter.class);
        http.addFilterBefore(new WordSplitterFilter(), BasicAuthenticationFilter.class);
        http.addFilterBefore(new CustomLoggingFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(new JwtSecurityGeneratorFilter(new JsonUtility()), BasicAuthenticationFilter.class);


        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
//    @Bean
//    public UserDetailsService springJdbcVersionForUserDetailsManager(DataSource source) {
//        return new JdbcUserDetailsManager(source);
//    }


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
