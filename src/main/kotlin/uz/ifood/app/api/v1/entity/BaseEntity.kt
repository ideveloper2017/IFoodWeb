package uz.ifood.app.api.v1.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column

abstract class BaseEntity<T>(@Column(name = "created_by", nullable = false, length = 50, updatable = false)
                             open var createdBy: String? = null,

                             @CreatedDate
                             @Column(name = "created_date", updatable = false)
                             open var createdDate: Instant? = Instant.now(),

                             @Column(name = "last_modified_by", length = 50)
                             open var lastModifiedBy: String? = null,

                             @LastModifiedDate
                             @Column(name = "last_modified_date")
                             open var lastModifiedDate: Instant? = Instant.now()
    ) : Serializable {


}
