package learn.sphere.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(   "/", "/h2/**", "/css/**", "/js/**", 
                                                "/images/**", "/error",
                                                "/rest-api/user/v1/**", "/rest-api/course/v1/**", "/register", "/courses", "/list/**").permitAll()
                .requestMatchers("/student/**").hasAnyRole("STUDENT","ADMIN")
                .requestMatchers("/trainer/**").hasAnyRole("TRAINER", "ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/redirect").authenticated()
                .anyRequest().authenticated()
            )
            .formLogin(login ->
                login.loginPage("/login")
                     .permitAll()
                     .usernameParameter("email")
                     .passwordParameter("password")
                     .defaultSuccessUrl("/redirect", true)
                     .failureUrl("/login")
            ).logout(logout -> 
                logout.logoutUrl("/logout") // Specify the logout URL
                    .logoutSuccessUrl("/") // Specify the logout success URL
                    .permitAll() // Allow everyone to access the logout URL
            )
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));
            // .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(myUserDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
