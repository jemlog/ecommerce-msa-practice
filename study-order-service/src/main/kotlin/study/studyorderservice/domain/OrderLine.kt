package study.studyorderservice.domain

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class OrderLine(

    val productId: Long, // 어떤 제품과 연관된 OrderLine인지 파악

    @Embedded
    val price: Money,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
}