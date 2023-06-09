package uz.najottalim.bankingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        DefaultLoginPageGeneratingFilter
//        AuthenticationManagerBuilder
//                DaoAuthenticationProvider
        http.authorizeHttpRequests(
                (requests) ->
                        requests.requestMatchers(
                                        "/accounts",
                                        "/balances",
                                        "/loans",
                                        "/cards")
                                .authenticated()
                                .requestMatchers(
                                        "/notices",
                                        "/contacts")
                                .permitAll()
                                .anyRequest()
                                .denyAll()
        );
//        UserDetailsManager
//        UserDetailsService
//        DaoAuthenticationProvider
//        ProviderManager
//        UsernamePasswordAuthenticationFilter
//        UserDetailsService
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
