package uz.ifood.app.api.v1.entity

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = 0,
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
