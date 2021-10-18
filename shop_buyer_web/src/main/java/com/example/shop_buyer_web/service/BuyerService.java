package com.example.shop_buyer_web.service;

import com.example.shop_dao.entity.Buyer;

import java.util.List;

/**
 * @author tai
 * @date: 2021-09-13 19:36
 * @description:
 */
public interface BuyerService {
    List<Buyer> selectAll();
    Buyer selectById(Long id);
}
