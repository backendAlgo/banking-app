package uz.najottalim.bankingapp.config;



import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import uz.najottalim.bankingapp.repository.RoleRepository;

import java.util.*;



import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final JWTValidatorFilter jwtValidatorFilter;
    private final JWTSecurityGeneratorFilter jwtSecurityGeneratorFilter;
    private final RequestTimeFilter requestTimeFilter;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors->{
                    cors.configurationSource(request -> {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.addAllowedOrigin("http://localhost:4200");
                        configuration.setAllowedMethods(List.of("*"));
                        configuration.setAllowedHeaders(List.of("*"));
                        configuration.setMaxAge(3600L);
                        configuration.setExposedHeaders(List.of("authorization"));
                        configuration.setAllowCredentials(true);
                        return configuration;
                    });
                })
                .authorizeHttpRequests(

                        (requests) ->requests

                                .requestMatchers("/notices/**", "/contacts").permitAll()

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
        http.addFilterBefore(jwtValidatorFilter,BasicAuthenticationFilter.class);
        http.addFilterAfter(jwtSecurityGeneratorFilter, BasicAuthenticationFilter.class);
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder myPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
