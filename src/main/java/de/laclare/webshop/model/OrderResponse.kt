package de.laclare.webshop.model

import java.time.LocalDateTime

class OrderResponse (
    val id: String,
    val customerId: String,
    val orderTime: LocalDateTime,
    val orderstatus: OrderStatus,
    val orderPositions: List<OrderPosition>
)

enum class OrderStatus {
    NEW, ConFIRMED, SENT, DELIVERED, CANCELLED

}

data class OrderPosition (
    val id: String,
    val productId: String,
    val quantity: String,
)
