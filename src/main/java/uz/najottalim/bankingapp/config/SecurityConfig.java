package uz.najottalim.bankingapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import uz.najottalim.bankingapp.repository.RoleRepository;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final JWTSecurityGeneratorFilter jwtSecurityGeneratorFilter;
    private final RequestTimeFilter requestTimeFilter;
    private final WordSplitterFilter wordSplitterFilter;
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(

                        (requests) ->requests

                                .requestMatchers("/notices", "/contacts").permitAll()

                                .requestMatchers(HttpMethod.POST,"/accounts").permitAll()

                                .requestMatchers(
                                        HttpMethod.GET,
                                        "/accounts/{id}",
                                        "/balances/{id}",
                                        "/loans/{id}",
                                        "/cards/{id}").hasAuthority("user")
                                .requestMatchers(
                                        HttpMethod.PUT,
                                        "/accounts/{id}",
                                        "/balances/{id}",
                                        "/loans/{id}",
                                        "/cards/{id}").hasAuthority("user")

                                .requestMatchers(HttpMethod.GET,"accounts/**").hasAnyAuthority("super-admin","admin")
                                .requestMatchers(HttpMethod.POST,"accounts").hasAnyAuthority("super-admin","admin")
                                .requestMatchers(HttpMethod.DELETE,"accounts/**").hasAuthority("super-admin")

                                .anyRequest().permitAll()

                );
        http.addFilterBefore(wordSplitterFilter, BasicAuthenticationFilter.class);
        http.addFilterBefore(requestTimeFilter, DisableEncodeUrlFilter.class);
        http.addFilterAfter(jwtSecurityGeneratorFilter, BasicAuthenticationFilter.class);
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
