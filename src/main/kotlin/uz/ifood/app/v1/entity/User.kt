package uz.ifood.app.v1.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(@Id @GeneratedValue(strategy=GenerationType.AUTO) val id: Long? = 0,
    @Column(name="user_name", nullable = false) var userName: String? = null,
    @Column(name="first_name", nullable = false) var firstName: String? = null,
    @Column(name="last_name", nullable = false) var lastName: String? = null,
    @Column(name="email", nullable = false) var email: String? = null,
    @Column(name="is_active", nullable = false) var isActive: Boolean? = false,
    @Column(name="password") var password: String? = null,

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="users_roles",
        joinColumns=[JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")],
    )
    var roles: Collection<Role>?=null
    )
