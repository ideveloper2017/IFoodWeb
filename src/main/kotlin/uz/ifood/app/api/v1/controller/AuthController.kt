package uz.ifood.app.api.v1.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import uz.ifood.app.api.v1.entity.User
import uz.ifood.app.api.v1.model.LoginUser
import uz.ifood.app.api.v1.model.NewUser
import uz.ifood.app.api.v1.repository.RoleRepository
import uz.ifood.app.api.v1.repository.UserRepository
import uz.ifood.app.api.v1.utils.JwtProvider
import uz.ifood.app.api.v1.web.response.JwtResponse
import uz.ifood.app.api.v1.web.response.ResponseMessage
import java.util.*
import java.util.stream.Collectors
import javax.validation.Valid


@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
class AuthController() {

    @Autowired
    private lateinit var jwtProvider: JwtProvider

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var encoder: PasswordEncoder

    @RequestMapping("/signin", method = [RequestMethod.POST])
    fun authenticateUser(@Valid @RequestBody loginRequest: LoginUser): ResponseEntity<*> {
        val userCredentials: Optional<User> =userRepository.findByUsername(loginRequest.username!!)

        if (userCredentials.isPresent) {
            val user:User = userCredentials.get()
            val authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password))
            SecurityContextHolder.getContext().authentication = authentication
            val jwt:String=jwtProvider.generateJwtToken(user.username!!)

            val authorities:List<GrantedAuthority> = user.roles!!.stream().map({ role -> SimpleGrantedAuthority(role.name) }).collect(
                Collectors.toList<GrantedAuthority>())
            return ResponseEntity.ok<Any>(JwtResponse(jwt,user.username,authorities))
        }

        return ResponseEntity(
            ResponseMessage(HttpStatus.BAD_REQUEST,"User not found!",null),
            HttpStatus.BAD_REQUEST)
    }

    @RequestMapping("/signup", method = [RequestMethod.POST])
    fun registerUser(@Valid @RequestBody newUser: NewUser): ResponseEntity<*> {
        val userCredentials: Optional<User> =userRepository.findByUsername(newUser.username!!)

        if (!userCredentials.isPresent) {
            if (usernameExists(newUser.username!!)) {
                return ResponseEntity(ResponseMessage( HttpStatus.BAD_REQUEST,"Username is already taken!",null), HttpStatus.BAD_REQUEST)
            } else if (emailExists(newUser.email!!)) {
                return ResponseEntity(ResponseMessage( HttpStatus.BAD_REQUEST,"Email is already in use!",null), HttpStatus.BAD_REQUEST)
            }

            val user = User(
                0,
                newUser.username!!,
                encoder.encode(newUser.password),
                newUser.firstName!!,
                newUser.lastName!!,
                newUser.email!!,
               true
            )
            user!!.roles=Arrays.asList(roleRepository.findByName("ROLE_USER"))
            userRepository.save(user)
            return ResponseEntity(ResponseMessage( HttpStatus.OK,"User registered successfully!",null), HttpStatus.OK)
        }
       return ResponseEntity(ResponseMessage( HttpStatus.BAD_REQUEST,"User already exists!",null),
            HttpStatus.BAD_REQUEST)
    }

    private fun emailExists(email:String): Boolean {
        return userRepository.findByEmail(email).isPresent
    }

    private fun usernameExists(username: String): Boolean {
        return userRepository.findByUsername(username).isPresent
    }
}
