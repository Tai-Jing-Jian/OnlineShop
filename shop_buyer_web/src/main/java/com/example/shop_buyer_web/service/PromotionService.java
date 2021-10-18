package com.example.shop_buyer_web.service;

import java.util.List;

/**
 * @author tai
 * @date: 2021-09-13 20:56
 * @description:
 */
public interface PromotionService {
    List<com.example.shop_dao.vo.PromotionGoods> selectAll();

    /**
     * @param buyerId 买家id
     * @param promotionId 促销活动id
     * @param goodsId 商品id
     * @return true：购买成功（下订单成功），false：购买失败（促销商品卖完了）
     * */
    boolean buy(Long buyerId, Integer promotionId, Long goodsId);
}
