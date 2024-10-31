package uz.ifood.app.api.v1.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import net.minidev.json.annotate.JsonIgnore
import java.io.Serializable
import java.time.Instant
import javax.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence")
    val id: Long? = 0,
    @Column(nullable = false, name = "username") var username: String? = null,
    @Column(nullable = false, name = "password") var password: String? = null,
    @Column(nullable = false, name = "first_name") var first_name: String? = null,
    @Column(nullable = false, name = "last_name") var last_name: String? = null,
    @Column(nullable = false, name = "email") var email: String? = null,
    @Column(nullable = false, name = "active") var active: Boolean = false,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    ) var roles: Collection<Role>? = null,
    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {

}



