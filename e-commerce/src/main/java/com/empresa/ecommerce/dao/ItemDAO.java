package com.empresa.ecommerce.dao;

import com.empresa.ecommerce.model.Item;

public interface ItemDAO {

	Item updateProductInBasket(Item productOrd);

	Item getItemByProductId(Long id);

}
