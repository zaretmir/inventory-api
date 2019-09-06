package com.empresa.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.ecommerce.model.Item;
import com.empresa.ecommerce.repository.ItemRepository;

@Component
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Item updateProductInBasket(Item item) {
		return itemRepository.saveAndFlush(item);
	}
	
	@Override 
	public Item getItemByProductId(Long id) {
		return itemRepository.findByProductPk(id);
	}

}
