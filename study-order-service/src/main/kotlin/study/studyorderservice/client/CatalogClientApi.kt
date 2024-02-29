package study.studyorderservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping


@FeignClient(name = "catalog-service") // 어플리케이션 이름을 작성하면 알아서 그쪽으로 쏴준다
internal interface CatalogClientApi {
    @GetMapping(
        value = ["/example/example-api"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun example(message: String): String
}