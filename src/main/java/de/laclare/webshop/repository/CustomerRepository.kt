package de.laclare.webshop.repository

import de.laclare.webshop.model.CustomerResponse
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerRepository {

    val customers = listOf (
        CustomerResponse (
//            UUID.randomUUID().toString(),
            "1",
            "Total",
            "Surprise",
            "total.surprise@gmail.com"
        )
    )

    fun findById(id: String): CustomerResponse? {
        return customers.find { it.id == id }
    }
}