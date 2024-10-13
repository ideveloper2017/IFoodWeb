package uz.ifood.app.api.v1.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import uz.ifood.app.api.v1.services.UserDetailsServiceImpl
import uz.ifood.app.api.v1.utils.JwtAuthEntryPoint
import uz.ifood.app.api.v1.utils.JwtAuthTokenFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig: WebSecurityConfigurerAdapter(),WebFluxConfigurer {

    @Autowired
    internal var userDetailsService: UserDetailsServiceImpl? = null

    @Autowired
    private val unauthorizedHandler: JwtAuthEntryPoint? = null


    @Bean
    fun authenticationJwtTokenFilter(): JwtAuthTokenFilter {
        return JwtAuthTokenFilter()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Throws(Exception::class)
    override fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

//    @Throws(Exception::class)
//     fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder) {
//        authenticationManagerBuilder
//            .userDetailsService(userDetailsService)
//            .passwordEncoder(passwordEncoder())
//    }

//    @Bean
//    @Throws(Exception::class)
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .csrf { it.disable() } // Disable CSRF since you're likely using JWT
//            .authorizeHttpRequests { auth ->
//                auth
//                    .requestMatchers("/api/**").permitAll() // Permit all routes
//                    .anyRequest().authenticated() // Any other request must be authenticated
//            }
//            .exceptionHandling { it.authenticationEntryPoint(unauthorizedHandler) }
//            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
//
//
//       .authenticationProvider(authenticationProvider())
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
//
//        return http.build()
//    }


@Throws(Exception::class)
override protected fun configure(http: HttpSecurity) {
    http.
    csrf().disable().authorizeRequests()
        .antMatchers("/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter::class.java)
}


}


