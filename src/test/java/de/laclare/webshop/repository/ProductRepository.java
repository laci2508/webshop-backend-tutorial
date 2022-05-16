package de.laclare.webshop.repository;

import de.laclare.webshop.model.ProductCreateRequest;
import de.laclare.webshop.model.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class ProductRepository {
    List<ProductResponse> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new ProductResponse(
                UUID.randomUUID().toString(),
                "AMD 2508",
                "eine Beschreibung",
                79900,
                Arrays.asList("AMD", "Intel")
        ));

        products.add(new ProductResponse(
                UUID.randomUUID().toString(),
                "AMD 1608",
                "eine weitere Beschreibung",
                49900,
                Arrays.asList("Mac", "AVB")
        ));

        products.add(new ProductResponse(
                UUID.randomUUID().toString(),
                        "AMD 1501",
                        "noch eine Beschreibung",
                        69900,
                        Arrays.asList("BDH", "BDM")
        ));

    }

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



    private List<String> getlowerCaseTagList (ProductResponse p) {
        List<String> lowercaseTags = p.getTags();
        return lowercaseTags.stream().map(String::toLowerCase).collect(Collectors.toList());
//        for (String t : p.getTags()) {
//            lowercaseTags.add(t.toLowerCase());
//        }

//        return lowercaseTags;
    }

    public ProductResponse findById(String id) {
        List <ProductResponse> productResponses =
        products.stream()
                .filter(p -> p.getId().equals(id))
                .collect(Collectors.toList());
        if (!productResponses.isEmpty()){
            return productResponses.iterator().next();
        }
        else {
            return null;
        }
    }

    public void deleteById(String id) {
        this.products = products
                .stream()
                .filter(p -> !p.getId().equals(id))
                .collect(Collectors.toList());
    }

    public ProductResponse save(ProductCreateRequest request) {

        ProductResponse response =
                new ProductResponse(UUID.randomUUID().toString()
                        , request.getName()
                        , request.getDescription()
                        , request.getPriceInCent()
                        , request.getTags()
                );
        products.add(response);
        return response;
    }
}
