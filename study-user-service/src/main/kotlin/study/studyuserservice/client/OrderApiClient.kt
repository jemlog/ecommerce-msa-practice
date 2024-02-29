package study.studyuserservice.client

import org.springframework.stereotype.Component

@Component
class OrderApiClient internal constructor(private val orderApi: OrderApi) {
    fun get(userId: String): String {
        return orderApi.get(userId)
    }
}