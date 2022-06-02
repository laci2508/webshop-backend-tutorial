package de.laclare.webshop.repository

import de.laclare.webshop.model.OrderPositionResponse
import org.springframework.stereotype.Service
import javax.websocket.server.ServerEndpoint

@Service
class OrderPositionRepository {
    fun save(orderPositionResponse: OrderPositionResponse) {
        val orderPositions = mutableListOf<OrderPositionResponse>()
        orderPositions.add(orderPositionResponse)
    }

}

