package com.example.shop_dao.dao;

import com.example.shop_dao.entity.BuyerShoppingCartKey;

public interface BuyerShoppingCartMapper {
    int deleteByPrimaryKey(BuyerShoppingCartKey key);

    int insert(BuyerShoppingCartKey record);

    int insertSelective(BuyerShoppingCartKey record);
}