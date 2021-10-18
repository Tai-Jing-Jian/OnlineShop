package com.example.shop_buyer_web.service.impl;

import com.example.shop_buyer_web.service.BuyerService;
import com.example.shop_dao.dao.BuyerMapper;
import com.example.shop_dao.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tai
 * @date: 2021-09-13 19:36
 * @description: 事务：必须；回滚：错误
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Buyer> selectAll() {
        return buyerMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Buyer selectById(Long id) {
        return buyerMapper.selectByPrimaryKey(id);
    }
}
