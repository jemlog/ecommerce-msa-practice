package study.studyorderservice.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(

    // 일급 컬렉션 사용
    @Embedded
    val orderLines: OrderLines,

    /*
    값 타입은 불변으로 통째로 교체하기
    배송 정보는 차후 수정 가능
     */
    @Embedded
    var shippingInfo: ShippingInfo,

    @Column(name = "total_amounts", nullable = false)
    @Embedded
    val totalAmounts: Money,

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    var state: OrderState,

    @Column(name = "order_date", nullable = false)
    val orderDate: LocalDateTime,

    @Id
    val id: String,
) {

    fun cancel(){
        this.state = OrderState.CANCELED
    }
}