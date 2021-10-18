package com.example.shop_dao.dao;

import com.example.shop_dao.entity.BuyerOrder;

public interface BuyerOrderMapper {
    int deleteByPrimaryKey(Long code);

    int insert(BuyerOrder record);

    int insertSelective(BuyerOrder record);

    BuyerOrder selectByPrimaryKey(Long code);

    int updateByPrimaryKeySelective(BuyerOrder record);

    int updateByPrimaryKey(BuyerOrder record);
}