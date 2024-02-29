package study.studyorderservice.domain

import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(

    var shippingInfo: ShippingInfo,

    @Enumerated(EnumType.STRING)
    var state: OrderState,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
}