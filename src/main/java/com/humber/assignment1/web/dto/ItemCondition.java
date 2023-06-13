package com.humber.assignment1.web.dto;

import com.humber.assignment1.domain.Brand;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemCondition {
    private String name;
    private String brand;
    private Double price;
    private Double highestPrice;
    private Double lowestPrice;
}
