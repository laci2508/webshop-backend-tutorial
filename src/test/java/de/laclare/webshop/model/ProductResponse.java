package de.laclare.webshop.model;

import java.util.List;

public class ProductResponse {
    public ProductResponse(String id, String name, String description, int priceInCent, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceInCent = priceInCent;
        this.tags = tags;
    }

    private String id;
    private String name;
    private String description;
    private int priceInCent;

    public String getId() {
        return id;
    }

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
