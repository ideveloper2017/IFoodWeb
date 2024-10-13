package uz.ifood.app.api.v1.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = Categories.Companion.TABLE_NAME)
data class Categories( @Id
                       @GeneratedValue(strategy = GenerationType.IDENTITY)
                       @Column(name = COLUMN_ID_NAME, nullable = false)
                       private var id: Long? = null,
                       var name: String? = null,
                       var description: String? = null) {


    companion object {
        const val TABLE_NAME: String = "categories"
        const val COLUMN_ID_NAME: String = "id"
    }
}
