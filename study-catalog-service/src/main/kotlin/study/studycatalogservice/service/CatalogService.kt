package study.studycatalogservice.service

import org.springframework.stereotype.Service
import study.studycatalogservice.jpa.CatalogEntity
import study.studycatalogservice.jpa.CatalogRepository


@Service
class CatalogService(val catalogRepository: CatalogRepository){

    fun getAllCatalogs(): List<CatalogEntity>{
        return catalogRepository.findAll()
    }
}