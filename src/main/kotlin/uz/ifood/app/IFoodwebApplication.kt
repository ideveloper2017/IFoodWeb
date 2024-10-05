package uz.ifood.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@SpringBootApplication
@EnableWebMvc
class IFoodwebApplication

fun main(args: Array<String>) {
    runApplication<IFoodwebApplication>(*args)
}
