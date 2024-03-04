package study.studyorderservice.domain

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class ShippingInfo(
    @Embedded
    val receiver: Receiver,
    @Embedded
    val address: Address
) {
}