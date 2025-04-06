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

}
