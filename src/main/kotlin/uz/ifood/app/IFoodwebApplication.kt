package uz.ifood.app


import com.fasterxml.jackson.databind.ObjectMapper
import com.mycompany.myapp.config.ApplicationProperties
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import uz.ifood.app.api.v1.entity.Permission
import uz.ifood.app.api.v1.entity.Role
import uz.ifood.app.api.v1.entity.User
import uz.ifood.app.api.v1.repository.PermissionRepository
import uz.ifood.app.api.v1.repository.RoleRepository
import uz.ifood.app.api.v1.repository.UserRepository

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(LiquibaseProperties::class, ApplicationProperties::class)
class IFoodwebApplication{

    @Bean
    fun init( userRepository: UserRepository,
              roleRepository: RoleRepository,
              permissionRepository: PermissionRepository,
              passwordEncoder: PasswordEncoder) = CommandLineRunner {
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
    }
}

fun main(args: Array<String>) {
    runApplication<IFoodwebApplication>(*args)
}
