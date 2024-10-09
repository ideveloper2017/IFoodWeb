package uz.ifood.app.api.v1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uz.ifood.app.api.v1.entity.Permission
import uz.ifood.app.api.v1.entity.Role

@Repository
interface PermissionRepository:  JpaRepository<Permission,Long>{
    fun findByName(name: String): Permission?
}
