package com.example.shop_dao.dao;

import com.example.shop_dao.entity.Seller;

public interface SellerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}