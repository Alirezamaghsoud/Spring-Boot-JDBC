package com.humber.assignment1.web.repostiory.item;

import com.humber.assignment1.domain.Brand;
import com.humber.assignment1.web.dto.ItemCondition;
import com.humber.assignment1.web.dto.ItemDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import static com.humber.assignment1.domain.QItem.item;
import static com.humber.assignment1.web.repostiory.item.ItemConditionHelper.*;


@Repository
@Slf4j
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public List<ItemDTO> searchItem(ItemCondition itemCondition) {
        String itemName = itemCondition.getName();
        String brand = itemCondition.getBrand();
        Double itemPrice = itemCondition.getPrice();
        Double highestPrice= itemCondition.getHighestPrice();
        Double lowestPrice = itemCondition.getLowestPrice();
        return queryFactory
                .select(Projections.constructor(ItemDTO.class,
                        item.id,
                        item.name,
                        item.brand,
                        item.price,
                        item.yearOfCreation
                )).from(item)
                .where(itemEq(itemName),
                        brandEq(brand),
                        priceEq(itemPrice),
                        priceGoe(lowestPrice),
                        priceLoe(highestPrice))
                .fetch();
    }

//    public List<ItemDTO> searchItemIncludingPriceRange(ItemCondition itemCondition) {
//        String itemName = itemCondition.getName();
//        String brand = itemCondition.getBrand();
//        Double highestPrice= itemCondition.getHighestPrice();
//        Double lowestPrice = itemCondition.getLowestPrice();
//        return queryFactory
//                .select(Projections.bean(ItemDTO.class,
//                        item.name,
//                        item.brand,
//                        item.price
//                )).from(item)
//                .where(itemEq(itemName),
//                        brandEq(brand),
//                        priceGoe(lowestPrice),
//                        priceLoe(highestPrice))
//                .fetch();
//    }





}