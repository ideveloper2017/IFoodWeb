package uz.ifood.app.api.v1.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import uz.ifood.app.api.v1.entity.Role

@RestController
@RequestMapping("/api/v1/role")
class RoleController {

    @RequestMapping("/newrole",method = [(RequestMethod.POST)])
    fun registerNewRole(@RequestBody role: Role): ResponseEntity<*> {

        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}