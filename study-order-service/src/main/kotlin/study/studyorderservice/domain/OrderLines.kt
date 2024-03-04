package study.studyorderservice.domain

import jakarta.persistence.Embeddable
import jakarta.persistence.OneToMany

@Embeddable
class OrderLines(

    @OneToMany
    val orderLineList: List<OrderLine>,
) {


    init {
        verifyAtLeastOneOrMoreOrderLines(orderLineList)
    }

    private fun verifyAtLeastOneOrMoreOrderLines(orderLineList: List<OrderLine>?){
        if(orderLineList.isNullOrEmpty()){
            throw IllegalArgumentException("orderLine이 없습니다")
        }
    }


}