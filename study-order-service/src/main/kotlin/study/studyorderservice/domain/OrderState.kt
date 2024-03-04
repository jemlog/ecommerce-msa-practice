package study.studyorderservice.domain

enum class OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED,
}