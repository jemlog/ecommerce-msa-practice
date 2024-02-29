package study.studyorderservice.service

import org.springframework.stereotype.Component
import study.studyorderservice.domain.Order
import study.studyorderservice.repository.OrderRepository

@Component
class OrderWriter(
    private val orderRepository: OrderRepository
) {

    fun save(order: Order): Order{
        return orderRepository.save(order)
    }
}