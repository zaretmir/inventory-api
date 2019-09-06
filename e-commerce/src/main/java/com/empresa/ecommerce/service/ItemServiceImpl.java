package com.empresa.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.ecommerce.dao.OrderDAO;
import com.empresa.ecommerce.dao.ItemDAO;
import com.empresa.ecommerce.model.Item;
import com.empresa.exception.EntityNotFoundException;
import com.empresa.product.dao.ProductDAO;
import com.empresa.product.model.Product;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemDAO itemDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	
	@Override
	public Item saveItemOrder(Long orderId, Long productId, int qty) {
		
		if (!productDAO.existsById(productId))
			throw new EntityNotFoundException(Product.class); // Ver si se puede poner de otra manera para no repetir código aquí y en ProductService
		
		//Item itemOrder = itemDAO.getItemByProductId(productId);
		Item itemOrder = new Item();
		itemOrder.setOrderPk(orderId);
		itemOrder.setProductPk(productId);		
		itemOrder.setQtyOrdered(qty);
		
		return itemDAO.updateProductInBasket(itemOrder);
	}

}
