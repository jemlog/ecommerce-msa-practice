package study.studycatalogservice.jpa

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "catalog")
class CatalogEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, length = 120, unique = true)
    val productId: String,

    @Column(nullable = false)
    val productName: String,

    @Column(nullable = false)
    var stock: Int,

    @Column(nullable = false)
    var unitPrice: Int,

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    var createdAt: Date

){}