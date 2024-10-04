package uz.ifood.app.api.v1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import uz.ifood.app.api.v1.entity.Role


interface RoleRepository: JpaRepository<Role,Long>{
    fun findByName(@Param("name") name: String): Role
}
