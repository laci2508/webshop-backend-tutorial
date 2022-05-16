package de.laclare.webshop.repository

import de.laclare.webshop.model.CustomerResponse
import java.util.UUID

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