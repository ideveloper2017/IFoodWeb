package uz.ifood.app.api.v1.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = Categories.Companion.TABLE_NAME)
data class Categories( @Id
                       @GeneratedValue(strategy = GenerationType.AUTO)
                       @Column(name = COLUMN_ID_NAME, nullable = false)
                       private var id: Long? = null,
                       var name: String? = null,
                       var description: String? = null) {


    companion object {
        const val TABLE_NAME: String = "categories"
        const val COLUMN_ID_NAME: String = "id"
    }
}
