package de.laclare.webshop.repository;

import de.laclare.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    public List<ProductResponse> findAll (String tag) {

        List<ProductResponse> products = Arrays.asList(

                new ProductResponse(
                        "1",
                        "AMD 2508",
                        "eine Beschreibung",
                        79900,
                        Arrays.asList("AMD", "Intel")
                ),

                new ProductResponse(
                        "2",
                        "AMD 1608",
                        "eine weitere Beschreibung",
                        49900,
                        Arrays.asList("Mac", "AVB")
                ),

                new ProductResponse(
                        "3",
                        "AMD 1501",
                        "noch eine Beschreibung",
                        69900,
                        Arrays.asList("BDH", "BDM")
                ));
        if (tag == null) {
            return products;
        }
        else {
            List <ProductResponse> filtered = new ArrayList<ProductResponse>();
            for (ProductResponse p: products) {
                List<String> lowercaseTags = new ArrayList<>();
                for (String t : p.getTags()) {
                    lowercaseTags.add(t.toLowerCase());

                }
                if (lowercaseTags.contains(tag.toLowerCase())) {
                    filtered.add(p);
                }
            }

            return filtered;
        }
    }
}
