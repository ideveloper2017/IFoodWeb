package uz.ifood.app.api.v1.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uz.ifood.app.api.v1.model.Greeting
import java.util.concurrent.atomic.AtomicLong

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
class OrderControler {

    val counter = AtomicLong()

    @RequestMapping("/order", method = [RequestMethod.GET])
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String) = Greeting(counter.incrementAndGet(), "Hello, $name")
}
