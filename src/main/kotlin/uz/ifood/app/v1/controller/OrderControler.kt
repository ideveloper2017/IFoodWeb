package uz.ifood.app.v1.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import uz.ifood.app.v1.entity.Order
import uz.ifood.app.v1.web.response.ResponseMessage

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api")
class OrderControler {

    @RequestMapping("/order", method = [RequestMethod.GET])
    fun index(): ResponseEntity<*> {

        return ResponseEntity(ResponseMessage("User registered successfully!"), HttpStatus.OK)
    }
}
