package com.example.shop_buyer_web.service.impl;

import com.example.shop_buyer_web.service.PromotionService;
import com.example.shop_buyer_web.util.RedisUtils;
import com.example.shop_buyer_web.util.SnowFlake;
import com.example.shop_dao.dao.GoodsMapper;
import com.example.shop_dao.dao.PromotionGoodsMapper;
import com.example.shop_dao.dao.PromotionOrderMapper;
import com.example.shop_dao.entity.PromotionOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author tai
 * @date: 2021-09-13 20:57
 * @description:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionGoodsMapper promotionGoodsMapper;

    @Autowired
    private PromotionOrderMapper promotionOrderMapper;

    @Autowired
    private GoodsMapper goodsMapper;



    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<com.example.shop_dao.vo.PromotionGoods> selectAll() {
        return promotionGoodsMapper.selectAll();
    }


    private final SnowFlake snowFlake = new SnowFlake(2,3);
    @Override
    public boolean buy(Long buyerId, Integer promotionId, Long goodsId) {
        if(promotionGoodsMapper.selectByPrimaryKey(promotionId).getTotal() > 0){
            promotionOrderMapper.insert(new PromotionOrder(snowFlake.nextId(), buyerId, promotionId, goodsId, (byte) 1, new Date()));
            promotionGoodsMapper.totalSub(promotionId);
            goodsMapper.stockSub(goodsId);
            return true;
        }else {
            return false;
        }
    }


}
