package uz.ifood.app.api.v1.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import uz.ifood.app.api.v1.entity.Role
import uz.ifood.app.api.v1.repository.UserRepository
import java.util.stream.Collectors

@Service
class UserDetailsServiceImpl: UserDetailsService {

    @Autowired(required = false)
    lateinit var userRepository: UserRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = userRepository.findByUsername(username.toString()).get()
            ?: throw UsernameNotFoundException("User '$username' not found")

        val authorities: List<GrantedAuthority> = user.roles!!.stream().map({ role -> SimpleGrantedAuthority(role.name)}).collect(Collectors.toList<GrantedAuthority>())

        return User
            .withUsername(username)
            .password(user.password)
            .authorities(authorities)
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build()
    }

    private fun getAuthorities(roles: Set<Role>): Collection<GrantedAuthority> {
        return roles.flatMap { role ->
            role.permissions.map { permission ->
                SimpleGrantedAuthority(permission.name)
            } + SimpleGrantedAuthority(role.name)
        }
    }
}
