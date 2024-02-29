package study.studyuserservice.service

import org.springframework.stereotype.Component
import study.studyuserservice.client.OrderApiClient

@Component
class OrderReader(val orderApiClient: OrderApiClient) {

    fun read(userId: String){
        orderApiClient.get(userId)
    }
}