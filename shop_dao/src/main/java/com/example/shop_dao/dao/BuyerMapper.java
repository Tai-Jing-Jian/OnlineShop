package com.example.shop_dao.dao;

import com.example.shop_dao.entity.Buyer;

import java.util.List;

public interface BuyerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Buyer record);

    int insertSelective(Buyer record);

    Buyer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Buyer record);

    int updateByPrimaryKey(Buyer record);

    List<Buyer> selectAll();
}