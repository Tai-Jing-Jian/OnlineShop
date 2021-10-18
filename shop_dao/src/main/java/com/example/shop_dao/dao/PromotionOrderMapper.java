package com.example.shop_dao.dao;

import com.example.shop_dao.entity.PromotionOrder;

public interface PromotionOrderMapper {
    int deleteByPrimaryKey(Long code);

    int insert(PromotionOrder record);

    int insertSelective(PromotionOrder record);

    PromotionOrder selectByPrimaryKey(Long code);

    int updateByPrimaryKeySelective(PromotionOrder record);

    int updateByPrimaryKey(PromotionOrder record);


}