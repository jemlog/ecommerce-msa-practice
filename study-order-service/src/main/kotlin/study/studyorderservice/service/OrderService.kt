package study.studyorderservice.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.studyorderservice.domain.Order
import study.studyorderservice.domain.OrderState
import study.studyorderservice.domain.ShippingInfo
import study.studyorderservice.producer.OrderProducer

@Service
class OrderService(
    private val orderProducer: OrderProducer,
    private val orderWriter: OrderWriter,
    ) {

    @Transactional
    fun createOrder(): Long{
        val savedOrder = orderWriter.save(Order(ShippingInfo("Seoul","hello"),OrderState.CANCEL))
        orderProducer.send(savedOrder.id!!.toLong())
        return savedOrder.id
    }
}