package uz.najottalim.bankingapp.config;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.security.web.server.savedrequest.NoOpServerRequestCache;
import uz.najottalim.bankingapp.entity.Role;
import uz.najottalim.bankingapp.repository.RoleRepository;

import java.util.Optional;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final RoleRepository roleRepository;
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(

                (requests) ->requests

                        .requestMatchers("/notices", "/contacts").permitAll()

                        .requestMatchers(HttpMethod.POST,"/accounts").permitAll()

                        .requestMatchers(
                                        "/accounts/{id}",
                                        "/balances/{id}",
                                        "/loans/{id}",
                                        "/cards/{id}").hasAuthority("user")

                        .requestMatchers("accounts/**").hasAuthority("super-admin")

                        .anyRequest().denyAll()
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder myPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
