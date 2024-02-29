package study.studyorderservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.studyorderservice.domain.Order

interface OrderRepository : JpaRepository<Order, Long> {
}