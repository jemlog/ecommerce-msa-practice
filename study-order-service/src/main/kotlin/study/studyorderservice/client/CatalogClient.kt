package study.studyorderservice.client

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Component

@Component
class CatalogClient internal constructor(
    private val catalogClientApi: CatalogClientApi,
){
    fun get(message: String): Result<String>{
        return runCatching {
            catalogClientApi.example(message)
        }
    }
}