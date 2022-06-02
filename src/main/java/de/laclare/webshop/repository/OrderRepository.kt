package de.laclare.webshop.repository

import de.laclare.webshop.model.OrderCreateRequest
import de.laclare.webshop.model.OrderResponse
import de.laclare.webshop.model.OrderStatus
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID


@Service
class OrderRepository {

    val orders = (mutableListOf <OrderResponse>())

    fun save(request: OrderCreateRequest?) : OrderResponse{
        val orderResponse = OrderResponse (
            UUID.randomUUID().toString(),
            request?.customerid.toString(),
            LocalDateTime.now(),
            OrderStatus.NEW,
            emptyList()
        )
        orders.add(orderResponse)
        return orderResponse
    }

    fun findById(orderID: String): OrderResponse? {
        return orders.find { it.id == orderID }
    }

}
