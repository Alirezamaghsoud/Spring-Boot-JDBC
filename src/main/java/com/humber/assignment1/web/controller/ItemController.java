package com.humber.assignment1.web.controller;

import com.humber.assignment1.domain.Brand;
import com.humber.assignment1.web.dto.ItemCondition;
import com.humber.assignment1.web.dto.ItemDTO;
import com.humber.assignment1.web.dto.ItemPriceRangeDTO;
import com.humber.assignment1.web.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService service;


    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("item/form")
    public String itemForm(@ModelAttribute(value = "item") ItemDTO item, Model model) {
        model.addAttribute("brands", Arrays.asList(Brand.Balenciaga, Brand.DIOR, Brand.STONE_ISLAND));
        return "form";
    }

    @PostMapping("item/form")
    public String itemForm(@Valid @ModelAttribute("item") ItemDTO itemDTO, BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", Arrays.asList(Brand.Balenciaga, Brand.DIOR, Brand.STONE_ISLAND));
            return "form";
        }
        service.addItem(ItemDTO.build(itemDTO));

        return "redirect:/";

    }
    @GetMapping("item/category/{brand}")
    public String categorizedPage(Model model, @PathVariable String brand) {
        ItemCondition brandCondition = ItemCondition.builder()
                .brand(brand)
                .build();
        List<ItemDTO> itemDTOS = service.searchItemByCondition(brandCondition);
        model.addAttribute("items", itemDTOS);
        return "view";
    }

    @GetMapping("item/category/{brand}/range")
    public String itemViewByPriceRange(Model model,
                                       @PathVariable String brand,
                                       ItemPriceRangeDTO itemDTO) {
        ItemCondition priceRangeCondition = ItemCondition.builder()
                .brand(brand)
                .highestPrice(itemDTO.getHighestPrice())
                .lowestPrice(itemDTO.getLowestPrice())
                .build();
        List<ItemDTO> itemDTOS = service.searchItemByCondition(priceRangeCondition);
        model.addAttribute("items", itemDTOS);
        return "view";

    }

}
