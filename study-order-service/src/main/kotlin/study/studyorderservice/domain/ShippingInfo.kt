package study.studyorderservice.domain

import jakarta.persistence.Embeddable

@Embeddable
data class ShippingInfo(var address: String, var message: String) {
}