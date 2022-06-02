package de.laclare.webshop.repository

import de.laclare.webshop.model.ProductCreateRequest
import de.laclare.webshop.model.ProductResponse
import org.springframework.stereotype.Service
import java.util.Arrays
import java.util.Locale
import java.util.UUID
import java.util.stream.Collectors

@Service
class ProductRepository private constructor() {
    var products: MutableList<ProductResponse> = ArrayList()

    init {
        products.add(ProductResponse(
            "1",
            "AMD 2508",
            "eine Beschreibung",
            79900,
            Arrays.asList("AMD", "Intel")
        ))
        products.add(ProductResponse(
            UUID.randomUUID().toString(),
            "AMD 1608",
            "eine weitere Beschreibung",
            49900,
            Arrays.asList("Mac", "AVB")
        ))
        products.add(ProductResponse(
            UUID.randomUUID().toString(),
            "AMD 1501",
            "noch eine Beschreibung",
            69900,
            Arrays.asList("BDH", "BDM")
        ))
    }

    fun findAll(tag: String?): List<ProductResponse> {
        return if (tag == null) {
            products
        } else {
            val filtered: MutableList<ProductResponse> = ArrayList()
            for (p in products) {
                if (getlowerCaseTagList(p).contains(tag.lowercase(Locale.getDefault()))) {
                    filtered.add(p)
                }
            }
            filtered
        }
    }

    private fun getlowerCaseTagList(p: ProductResponse): List<String> {
        val lowercaseTags = p.tags
        return lowercaseTags.stream().map { obj: String ->
            obj.lowercase(Locale.getDefault())
        }.collect(Collectors.toList())
        //        for (String t : p.getTags()) {
//            lowercaseTags.add(t.toLowerCase());
//        }

//        return lowercaseTags;
    }

    fun findById(id: String): ProductResponse? {
        val productResponses = products.filter {p: ProductResponse -> p.id == id  }
        return if (!productResponses.isEmpty()) {
            productResponses.first()
        } else {
            null
        }
    }

    fun deleteById(id: String) {
        products = products
            .stream()
            .filter { p: ProductResponse -> p.id != id }
            .collect(Collectors.toList())
    }

    fun save(request: ProductCreateRequest): ProductResponse {
        val response = ProductResponse(UUID.randomUUID().toString(),
            request.name,
            request.description,
            request.priceInCent,
            request.tags
        )
        products.add(response)
        return response
    }

    companion object {
        private var theProductrepository: ProductRepository? = null
        val productrepository: ProductRepository?
            get() {
                if (theProductrepository == null) {
                    theProductrepository = ProductRepository()
                }
                return theProductrepository
            }
    }
}