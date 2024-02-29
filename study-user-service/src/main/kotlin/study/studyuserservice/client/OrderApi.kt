package study.studyuserservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "order-service", configuration = [FeignErrorDecoder::class])
internal interface OrderApi {

    @GetMapping(
        value = ["/{userId}/orders"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun get(@PathVariable userId: String): String
}