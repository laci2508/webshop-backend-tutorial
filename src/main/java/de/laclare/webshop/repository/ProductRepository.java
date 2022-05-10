package de.laclare.webshop.repository;

import de.laclare.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ProductRepository {

    public List<ProductResponse> findAll (String tag) {

        if (tag == null) {
            return products;
        }
        else {

//          List<ProductResponse> filtered = products.stream();
//                    products
//                            .stream()
//                            .filter(p -> getlowerCaseTagList(p).contains(tag))
//                            .collect(Collectors.toList());

           List <ProductResponse> filtered = new ArrayList<>();
            for (ProductResponse p: products) {

                if (getlowerCaseTagList(p).contains(tag.toLowerCase())) {
                    filtered.add(p);
                }
            }

            return filtered;
        }
    }

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

    private List<String> getlowerCaseTagList (ProductResponse p) {
        List<String> lowercaseTags = p.getTags();
        return lowercaseTags.stream().map(String::toLowerCase).collect(Collectors.toList());
//        for (String t : p.getTags()) {
//            lowercaseTags.add(t.toLowerCase());
//        }

//        return lowercaseTags;
    }
}
