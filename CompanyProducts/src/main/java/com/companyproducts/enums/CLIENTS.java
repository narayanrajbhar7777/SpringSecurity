package com.companyproducts.enums;

public enum CLIENTS {
    REST_TEMPLATE("REST", "REST_TEMPLATE"),
    WEB_CLIENT("WEB", "web"),
    FEIGN_CLIENT("FEIGN", "feign");

    private final String type;
    private final String description;

    CLIENTS(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
