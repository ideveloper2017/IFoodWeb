package uz.ifood.app


import com.fasterxml.jackson.databind.ObjectMapper
import com.mycompany.myapp.config.ApplicationProperties
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import uz.ifood.app.api.v1.config.CRLFLogConverter
import uz.ifood.app.api.v1.entity.Permission
import uz.ifood.app.api.v1.entity.Role
import uz.ifood.app.api.v1.entity.User
import uz.ifood.app.api.v1.repository.PermissionRepository
import uz.ifood.app.api.v1.repository.RoleRepository
import uz.ifood.app.api.v1.repository.UserRepository
import javax.annotation.PostConstruct

import java.net.InetAddress
import java.net.UnknownHostException

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(LiquibaseProperties::class, ApplicationProperties::class)
class IFoodwebApplication(private val env: Environment) {

    private val log = LoggerFactory.getLogger(javaClass)

//    @Bean
//    public fun init(
//        userRepository: UserRepository,
//        roleRepository: RoleRepository,
//        permissionRepository: PermissionRepository,
//        passwordEncoder: PasswordEncoder
//    ) = CommandLineRunner {
//        val adminPermission = permissionRepository.save(Permission(name = "ADMIN_PERMISSION"))
//        val userPermission = permissionRepository.save(Permission(name = "USER_PERMISSION"))
//
//        val adminRole = roleRepository.save(Role(1,name = "ROLE_ADMIN", permissions = setOf(adminPermission)))
//        val userRole = roleRepository.save(Role(2,name = "ROLE_USER", permissions = setOf(userPermission)))
//
//        val adminUser = userRepository.save(
//            User(email = "admin@gmail.com", first_name = "Baxrom", last_name = "Parpiyev", username = "admin", password = passwordEncoder.encode("admin123"), roles = setOf(adminRole),active = true)
//        )
//        val normalUser = userRepository.save(
//            User(email = "user@gmail.com", first_name = "Baxrom1", last_name = "Parpiyev2",username = "user", password = passwordEncoder.encode("user123"), roles = setOf(userRole),active = true)
//        )
//    }


//    @PostConstruct
//    fun initApplication() {
//        val activeProfiles = env.activeProfiles
//        if (
//            activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) &&
//            activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)
//        ) {
//            log.error(
//                "You have misconfigured your application! It should not run with both the 'dev' and 'prod' profiles at the same time."
//            )
//        }
//        if (
//            activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) &&
//            activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_CLOUD)
//        ) {
//            log.error(
//                "You have misconfigured your application! It should not run with both the 'dev' and 'cloud' profiles at the same time."
//            )
//        }
//    }

//    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            val env = runApplication<IFoodwebApplication>(*args) { DefaultProfileUtil.addDefaultProfile(this) }.environment
//            logApplicationStartup(env)
//        }
//        @JvmStatic
//         fun logApplicationStartup(env: Environment) {
//            val log = LoggerFactory.getLogger(IFoodwebApplication::class.java)
//            val protocol = if (env.getProperty("server.ssl.key-store") != null) {
//                "https"
//            } else "http"
//            val serverPort = env.getProperty("server.port")
//            val contextPath = env.getProperty("server.servlet.context-path") ?: "/"
//            var hostAddress = "localhost"
//            try {
//                hostAddress = InetAddress.getLocalHost().hostAddress
//            } catch (e: UnknownHostException) {
//                log.warn("The host name could not be determined, using `localhost` as fallback")
//            }
//            log.info(
//                CRLFLogConverter.CRLF_SAFE_MARKER,
//                """
//                ----------------------------------------------------------
//                Application '${env.getProperty("spring.application.name")}' is running! Access URLs:
//                Local:      $protocol://localhost:$serverPort$contextPath
//                External:   $protocol://$hostAddress:$serverPort$contextPath
//                Profile(s): ${env.activeProfiles.joinToString(",")}
//                ----------------------------------------------------------
//                """.trimIndent()
//            )
//        }
//
//    }
}


fun main(args: Array<String>) {
    val env=runApplication<IFoodwebApplication>(*args)
//    IFoodwebApplication.logApplicationStartup(env);
}


