package study.studycatalogservice.controller


import org.springframework.cloud.client.ServiceInstance
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.dto.ResponseCatalog
import study.studycatalogservice.service.CatalogService
import java.util.function.Consumer


@RestController
@RequestMapping("/catalog-service")
class CatalogController(val catalogService: CatalogService) {

  @GetMapping("/catalogs")
  fun getCatalogs(): ResponseEntity<List<ResponseCatalog>>{
      val catalogList = catalogService.getAllCatalogs()

      val result = catalogList.stream().map { catalog ->
          ResponseCatalog(
              catalog.productId,
              catalog.productName,
              catalog.unitPrice,
              catalog.stock,
              catalog.createdAt
          )
      }.toList()

      return ResponseEntity.ok(result)
  }
}