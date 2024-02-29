package study.studycatalogservice.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface CatalogRepository : JpaRepository<CatalogEntity, Long>{
}