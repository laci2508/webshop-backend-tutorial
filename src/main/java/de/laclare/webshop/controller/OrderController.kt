package de.laclare.webshop.controller

import de.laclare.webshop.exceptions.WebshopException
import de.laclare.webshop.model.OrderCreateRequest
import de.laclare.webshop.model.OrderPositionCreateRequest
import de.laclare.webshop.model.OrderPositionResponse
import de.laclare.webshop.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderController (
    val orderService :  OrderService
    ) {

    @PostMapping("/orders")
    fun createOrder (
        @RequestBody request: OrderCreateRequest
    ) : ResponseEntity<*> {
        try {
            return ResponseEntity.ok(orderService.createOrder(request))
        } catch (e: WebshopException) {
            return ResponseEntity.status(e.statusCode).body(e.message)
        }
    }

    @PostMapping("/orders/{id}/positions")
    fun createOrderPositions(
        @PathVariable(name = "id") orderId: String,
        @RequestBody request: OrderPositionCreateRequest
    ) : ResponseEntity<*> {
        try {
            return ResponseEntity.ok(orderService.createNewPositionForOrder(orderId, request))
        } catch (e: WebshopException) {
            return ResponseEntity.status(e.statusCode).body(e.message)
        }
    }

//    @PostMapping("/orders/{id}/positions")
//    fun createOrderPositions(
//        @PathVariable(name = "id") orderId: String,
//        @RequestBody request: OrderPositionCreateRequest
//    ) : OrderPositionResponse {
//        return orderService.createNewPositionForOrder(orderId, request)
//    }
}




