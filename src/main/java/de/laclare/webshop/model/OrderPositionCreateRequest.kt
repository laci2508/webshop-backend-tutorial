package de.laclare.webshop.model

data class OrderPositionCreateRequest (
    val productId: String?,
    val quantity: Long
    )

