package uz.ifood.app.v1.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import uz.ifood.app.v1.services.UserDetailsServiceImpl
import uz.ifood.app.v1.utils.JwtAuthEntryPoint
import uz.ifood.app.v1.utils.JwtAuthTokenFilter


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Autowired
    internal var userDetailsService: UserDetailsServiceImpl? = null

    @Autowired
    private val unauthorizedHandler: JwtAuthEntryPoint? = null


    @Bean
    fun authenticationJwtTokenFilter(): JwtAuthTokenFilter {
        return JwtAuthTokenFilter()
    }

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }




    @Bean
    @Throws(Exception::class)
    fun configure(auth: AuthenticationManagerBuilder) {

    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() } // Disable CSRF since you're likely using JWT
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/**").permitAll() // Permit all routes
                    .anyRequest().authenticated() // Any other request must be authenticated
            }
//            .exceptionHandling { exceptions ->
//                exceptions
//                        .authenticationEntryPoint(unauthorizedHandler) // Custom unauthorized handler
//            }
//            .sessionManagement { session ->
//                session
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management for JWT
//            }

        // Add JWT filter before the default UsernamePasswordAuthenticationFilter
        //http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}