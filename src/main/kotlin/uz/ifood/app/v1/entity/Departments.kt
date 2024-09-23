package uz.ifood.app.v1.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "departments")
data class Departments(@Id
                       @GeneratedValue(strategy = GenerationType.AUTO)
                       @Column(name = COLUMN_ID_NAME, nullable = false)
                       private var id: Long? = null) {

    companion object {
        const val COLUMN_ID_NAME: String = "id"
    }
}
