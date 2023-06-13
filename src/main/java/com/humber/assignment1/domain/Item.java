package com.humber.assignment1.domain;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Item extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String name;
    @Enumerated(value = EnumType.STRING)
    private Brand brand;

    private Double price;

    private Long yearOfCreation;

    protected Item() {}

    public Item(String name, Brand brand, Double price, Long yearOfCreation) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.yearOfCreation = yearOfCreation;
    }
}
