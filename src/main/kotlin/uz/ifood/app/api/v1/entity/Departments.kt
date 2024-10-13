package uz.ifood.app.api.v1.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "departments")
data class Departments(@Id
                       @GeneratedValue(strategy = GenerationType.IDENTITY)
                       @Column(name = COLUMN_ID_NAME, nullable = false)
                       private var id: Long? = null) {

    companion object {
        const val COLUMN_ID_NAME: String = "id"
    }
}
