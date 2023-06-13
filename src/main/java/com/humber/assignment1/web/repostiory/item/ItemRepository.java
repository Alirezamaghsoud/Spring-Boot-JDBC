package com.humber.assignment1.web.repostiory.item;

import com.humber.assignment1.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {
}
