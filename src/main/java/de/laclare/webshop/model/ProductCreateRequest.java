package de.laclare.webshop.model;

import java.util.List;

public class ProductCreateRequest {
    public ProductCreateRequest(String name, String description, int priceInCent, List<String> tags) {
        this.name = name;
        this.description = description;
        this.priceInCent = priceInCent;
        this.tags = tags;
    }

    private String name;
    private String description;
    private int priceInCent;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriceInCent() {
        return priceInCent;
    }

    public List<String> getTags() {
        return tags;
    }

    private List<String> tags;

}
