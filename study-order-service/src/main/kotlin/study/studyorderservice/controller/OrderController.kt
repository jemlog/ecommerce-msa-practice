package study.studyorderservice.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import study.studyorderservice.service.OrderService

@RestController
class OrderController(val orderService: OrderService) {

    @PostMapping("/{userId}/orders")
    fun createOrder(@PathVariable("userId") userId: String): Unit {
        orderService.createOrder()
    }
}