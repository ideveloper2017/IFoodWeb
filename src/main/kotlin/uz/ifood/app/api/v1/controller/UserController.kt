package uz.ifood.app.api.v1.controller

import org.springframework.security.core.Authentication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import uz.ifood.app.api.v1.entity.User
import uz.ifood.app.api.v1.repository.UserRepository
import uz.ifood.app.api.v1.web.response.ResponseMessage

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = ["*"], maxAge = 3600)
class UserController() {

    @Autowired(required = true)
    lateinit var userRepository: UserRepository

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @RequestMapping("/profile", method = [RequestMethod.GET])

    fun getUserContent(authentication: Authentication): ResponseEntity<*> {
        val user: User = userRepository.findByUsername(authentication.name).get()

        return ResponseEntity<Any>(user, HttpStatus.OK);
//        return ResponseEntity<Any>(ResponseMessage(HttpStatus.OK,"Hello "+user+"!", user),HttpStatus.OK)
    }
}

