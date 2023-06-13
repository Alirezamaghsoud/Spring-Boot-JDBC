package com.humber.assignment1.web.repostiory.item;

import com.humber.assignment1.domain.Brand;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.util.StringUtils;

import static com.humber.assignment1.domain.QItem.item;

public class ItemConditionHelper {

    public static BooleanExpression brandEq(String brand) {
        return StringUtils.hasText(brand) ? item.brand.eq(Brand.valueOf(brand)) : null;
    }

    public static BooleanExpression priceEq(Double price) {
        return price != null ? item.price.eq(price) : null;
    }

    public static BooleanExpression priceGoe(Double price) {
        return price != null ? item.price.goe(price) : null;
    }
    public static BooleanExpression priceLoe(Double price) {
        return price != null ? item.price.loe(price) : null;
    }

    public static BooleanExpression itemEq(String itemName) {
        return StringUtils.hasText(itemName) ? item.name.eq(itemName) : null;
    }
}
