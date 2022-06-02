package de.laclare.webshop.service

import de.laclare.webshop.exceptions.APIExceptionClass
import de.laclare.webshop.exceptions.WebshopException
import de.laclare.webshop.model.OrderCreateRequest
import de.laclare.webshop.model.OrderPositionCreateRequest
import de.laclare.webshop.model.OrderPositionResponse
import de.laclare.webshop.model.OrderResponse
import de.laclare.webshop.repository.CustomerRepository
import de.laclare.webshop.repository.OrderPositionRepository
import de.laclare.webshop.repository.OrderRepository
import de.laclare.webshop.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OrderService (
        val productRepository : ProductRepository,
        val orderRepository : OrderRepository,
        val customerRepository : CustomerRepository,
        val orderPositionRepository : OrderPositionRepository
) {

    fun createOrder(request: OrderCreateRequest) : OrderResponse {

        val customer = request.customerid?.let { customerRepository.findById(it) }
            ?: throw WebshopException("Customer not found", statusCode = HttpStatus.BAD_REQUEST)
        return orderRepository.save(request)
    }

    fun createNewPositionForOrder(
            orderId: String,
            request: OrderPositionCreateRequest)
    :OrderPositionResponse {

        orderRepository.findById(orderId)
            ?: throw WebshopException("Order not found", statusCode = HttpStatus.BAD_REQUEST)

        request.productId?.let { productRepository.findById(it) }
            ?: throw WebshopException("Product not found", statusCode = HttpStatus.BAD_REQUEST)

        val orderPositionResponse = OrderPositionResponse (
                id =UUID.randomUUID().toString(),
                productId = request.productId.toString(),
                quantity = request.quantity
        )
        orderPositionRepository.save(orderPositionResponse)
        return orderPositionResponse

    }
}