package uz.ifood.app.api.v1.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column

abstract class BaseEntity<T>(

                             @CreatedDate
                             @Column(name = "created_date", updatable = false)
                             open var createdDate: Instant? = Instant.now(),

                             @LastModifiedDate
                             @Column(name = "last_modified_date")
                             open var lastModifiedDate: Instant? = Instant.now()
    ) : Serializable {


}
