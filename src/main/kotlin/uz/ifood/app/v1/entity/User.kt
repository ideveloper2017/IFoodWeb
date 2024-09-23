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
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,
    @Column(nullable = false,name="username") var username: String? = null,
    @Column(nullable = false,name="password") var password: String? = null,
    @Column(nullable = false,name="first_name") var first_name: String? = null,
    @Column(nullable = false,name="last_name") var last_name: String? = null,
    @Column(nullable = false,name="email") var email: String? = null,
    @Column(nullable=false,name="active") var active: Boolean = false,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
    @JoinTable(
        name="users_roles",
        joinColumns=[JoinColumn(name = "user_id",referencedColumnName = "id")],
        inverseJoinColumns=[JoinColumn(name = "role_id",referencedColumnName = "id")]
    )
    var roles: Collection<Role>? =null
    )
