package com.spidershop.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Spider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genus;
    private String species;
    private BigDecimal price;
    private String description;

    @Enumerated(EnumType.STRING)
    private SpiderSize size;

    @Enumerated(EnumType.STRING)
    private SpiderSex sex;

    private int quantity;
    private boolean available;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
