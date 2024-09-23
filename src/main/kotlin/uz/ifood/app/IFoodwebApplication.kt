package uz.ifood.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IFoodwebApplication

fun main(args: Array<String>) {
    runApplication<IFoodwebApplication>(*args)
}
