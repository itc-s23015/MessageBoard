package jp.ac.itcollege.s23015.messageboard.presentation.config

import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

class SecurityConfig {

    @Bean
    @Order(1)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/users/register").permitAll()
                    .anyRequest().authenticated()

            }
            .formLogin { form ->
                form
                    .loginPage("/login")
                    .permitAll()
            }

            .csrf { csrf ->
                csrf.disable()
            }

        return http.build()
    }
    @Bean
    fun passwordEncoder(): PasswordEncoder {

        val saltLength = 16
        val hashLength = 32
        val parallelism = 1
        val memory = 65536
        val iterations = 3
        return Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations)
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }
}