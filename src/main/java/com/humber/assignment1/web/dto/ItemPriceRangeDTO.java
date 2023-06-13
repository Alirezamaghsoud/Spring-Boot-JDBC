package com.humber.assignment1.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class ItemPriceRangeDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String brand;

    @Min(value = 1001)
    private Double price;
    @Min(value = 1001)
    private Double highestPrice;
    @Min(value = 1001)
    private Double lowestPrice;

    public ItemPriceRangeDTO(String name, String brand, Double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }


}
