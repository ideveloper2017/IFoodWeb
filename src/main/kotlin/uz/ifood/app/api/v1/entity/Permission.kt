package uz.ifood.app.api.v1.entity

import java.io.Serializable
import java.time.Instant
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Permission (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long =0,
    val name:String? = null,

    @ManyToMany(mappedBy = "permissions")
    var roles:Set<Role> = HashSet(),
    override var createdDate: Instant? = Instant.now(),

    override var lastModifiedDate: Instant? = Instant.now()
): BaseEntity<Long>(createdDate, lastModifiedDate), Serializable{
}
