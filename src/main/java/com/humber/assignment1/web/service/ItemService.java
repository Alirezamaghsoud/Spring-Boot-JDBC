package com.humber.assignment1.web.service;

import com.humber.assignment1.domain.Item;
import com.humber.assignment1.web.dto.ItemCondition;
import com.humber.assignment1.web.dto.ItemDTO;
import com.humber.assignment1.web.repostiory.item.ItemRepository;
import com.humber.assignment1.web.repostiory.item.ItemRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepositoryImpl repositoryImpl;
    private final ItemRepository itemRepository;
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<ItemDTO> searchItemByCondition(ItemCondition itemCondition) {
        // TODO : ItemCondtion build
        return repositoryImpl.searchItem(itemCondition);
    }


//    public List<ItemDTO> searchItemByConditionInPriceRange(ItemCondition itemCondition) {
//        // TODO : ItemCondtion build
//        return repositoryImpl.searchItemIncludingPriceRange(itemCondition);
//    }

}
