package uz.ifood.app.v1.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import uz.ifood.app.v1.entity.Order

@RestController("/v1")
class OrderControler {

    @RequestMapping("/order", method = [RequestMethod.GET])
    fun index(): ResponseEntity<String?> {

        return ResponseEntity.ok("Ok");
    }
}
