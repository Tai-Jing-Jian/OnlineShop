package com.example.shop_dao.dao;

import com.example.shop_dao.entity.GoodsClass;

public interface GoodsClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsClass record);

    int insertSelective(GoodsClass record);

    GoodsClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsClass record);

    int updateByPrimaryKey(GoodsClass record);
}