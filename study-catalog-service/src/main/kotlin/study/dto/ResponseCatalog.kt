package study.dto

import java.util.*

data class ResponseCatalog(
    val productId: String,
    val productName: String,
    val unitPrice: Int,
    val stock: Int,
    val createdAt: Date
)
