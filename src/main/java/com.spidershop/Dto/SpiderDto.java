package com.spidershop.Dto;

import com.spidershop.Entity.SpiderSex;
import com.spidershop.Entity.SpiderSize;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SpiderDto {

    @NotBlank(message = "Genus is required")
    private String genus;

    @NotBlank(message = "Species is required")
    private String species;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private BigDecimal price;

    @Min(value = 0, message = "Quantity must be 0 or greater")
    private int quantity;

    @NotNull(message = "Size is required")
    private SpiderSize size;

    private SpiderSex sex;

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SpiderSize getSize() {
        return size;
    }

    public void setSize(SpiderSize size) {
        this.size = size;
    }

    public SpiderSex getSex() {
        return sex;
    }

    public void setSex(SpiderSex sex) {
        this.sex = sex;
    }
}
