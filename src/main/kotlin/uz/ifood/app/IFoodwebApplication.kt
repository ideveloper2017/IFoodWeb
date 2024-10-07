package uz.ifood.app


import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@OpenAPIDefinition
class IFoodwebApplication

fun main(args: Array<String>) {
    runApplication<IFoodwebApplication>(*args)
}
