package de.laclare.webshop.controller

import de.laclare.webshop.model.CustomerResponse
import de.laclare.webshop.repository.CustomerRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class CustomerController (
    val customerRepository : CustomerRepository
    ) {

    @GetMapping (/* ...value = */ "/customers/{id}")
    fun getCustomersById(
        @PathVariable id: String
    ) : ResponseEntity<CustomerResponse?>{
        val response = customerRepository.findById(id)
        return if (response != null)
            ResponseEntity.ok(response)
        else
            ResponseEntity.notFound().build()
    }
}


