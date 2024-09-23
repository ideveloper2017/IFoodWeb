package uz.ifood.app.v1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@Configuration
@EnableWebSecurity
class WebSecurityConfig {


    @Throws(Exception::class)
    override protected fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
            .anyRequest()
             .authenticated()
             .and()
            .exceptionHandling().authenticationEntryPoint(u)

    }

}