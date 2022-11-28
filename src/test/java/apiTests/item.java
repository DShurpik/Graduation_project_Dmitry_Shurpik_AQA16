package apiTests;

import lombok.Data;

@Data

public class item {
    private Integer id;
    private String name;
    private String form;
    private String producer;
    private Boolean recipe;
    private Double price;
    private Integer rest;
    private Integer feed_id;
    private String expiration_date;
    private String in_date;
    private Object external_id;

    public item(Integer id, String name, String form, String producer, Boolean recipe, Double price, Integer rest, Integer feed_id, String expiration_date, String in_date, Object external_id) {
        this.id = id;
        this.name = name;
        this.form = form;
        this.producer = producer;
        this.recipe = recipe;
        this.price = price;
        this.rest = rest;
        this.feed_id = feed_id;
        this.expiration_date = expiration_date;
        this.in_date = in_date;
        this.external_id = external_id;
    }


}

