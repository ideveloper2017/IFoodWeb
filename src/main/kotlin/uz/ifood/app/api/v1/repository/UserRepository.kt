package uz.ifood.app.api.v1.repository


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import uz.ifood.app.api.v1.entity.User

import java.util.Optional
import javax.transaction.Transactional

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun existsByUsername(@Param("username") username: String): Boolean

    fun findByUsername(@Param("username") username: String): Optional<User>

    fun findByEmail(@Param("email") email: String): Optional<User>

    @Transactional
    fun deleteByUsername(@Param("username") username: String)
}
