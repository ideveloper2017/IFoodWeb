package uz.ifood.app.v1.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.server.SecurityWebFilterChain
import uz.ifood.app.v1.services.UserDetailsServiceImpl
import uz.ifood.app.v1.utils.JwtAuthEntryPoint;
import uz.ifood.app.v1.utils.JwtAuthTokenFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Autowired
    internal var userDetailsService: UserDetailsServiceImpl? = null


    @Autowired
    private val unauthorizedHandler: JwtAuthEntryPoint? = null


    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationJwtTokenFilter(): JwtAuthTokenFilter {
        return JwtAuthTokenFilter()
    }

    @Throws(Exception::class)
     fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder())
    }

//    @Bean
//    @Throws(Exception::class)
//     fun authenticationManagerBean(): AuthenticationManager {
//        return s
//    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() } // Disable CSRF since you're likely using JWT
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/v1/**").permitAll() // Permit all routes
                    .anyRequest().authenticated() // Any other request must be authenticated
            }
            .exceptionHandling { exceptions ->
                exceptions
                        .authenticationEntryPoint(unauthorizedHandler) // Custom unauthorized handler
            }
            .sessionManagement { session ->
                session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management for JWT
            }

        // Add JWT filter before the default UsernamePasswordAuthenticationFilter
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }


}
