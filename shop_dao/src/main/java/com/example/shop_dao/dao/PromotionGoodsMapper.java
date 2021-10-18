package com.example.shop_dao.dao;

import com.example.shop_dao.entity.PromotionGoods;

import java.util.List;

public interface PromotionGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromotionGoods record);

    int insertSelective(PromotionGoods record);

    PromotionGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PromotionGoods record);

    int updateByPrimaryKey(PromotionGoods record);

    List<com.example.shop_dao.vo.PromotionGoods> selectAll();

    int totalSub(Integer id);
}