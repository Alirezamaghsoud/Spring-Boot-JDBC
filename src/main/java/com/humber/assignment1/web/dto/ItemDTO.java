package com.humber.assignment1.web.dto;


import com.humber.assignment1.domain.Brand;
import com.humber.assignment1.domain.Item;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ItemDTO {
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private Brand brand;
    @Min(value = 1001)
    @NotNull
    private Double price;

    @Min(value = 2022)
    @NotNull
    private Long yearOfCreation;

    public ItemDTO(Long id,String name, Brand brand, Double price, Long yearOfCreation) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.yearOfCreation = yearOfCreation;
    }

    public static Item build(ItemDTO itemDTO) {
        return new Item(itemDTO.getName(),
                itemDTO.getBrand(),
                itemDTO.getPrice(),
                itemDTO.getYearOfCreation());
    }
}
