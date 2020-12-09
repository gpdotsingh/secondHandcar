package com.cogizant.test.secondhandcar.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_id",
        "make",
        "model",
        "year_model",
        "price",
        "licensed",
        "date_added"
})
public class Vehicle {

    @JsonProperty("_id")
    private Integer id;
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("year_model")
    private Integer yearModel;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("licensed")
    private Boolean licensed;
    @JsonProperty("date_added")
    private String dateAdded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("_id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("make")
    public String getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(String make) {
        this.make = make;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("year_model")
    public Integer getYearModel() {
        return yearModel;
    }

    @JsonProperty("year_model")
    public void setYearModel(Integer yearModel) {
        this.yearModel = yearModel;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("licensed")
    public Boolean getLicensed() {
        return licensed;
    }

    @JsonProperty("licensed")
    public void setLicensed(Boolean licensed) {
        this.licensed = licensed;
    }

    @JsonProperty("date_added")
    public String getDateAdded() {
        return dateAdded;
    }

    @JsonProperty("date_added")
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
