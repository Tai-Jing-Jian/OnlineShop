package com.example.shop_dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tai
 * @date: 2021-09-13 20:05
 * @description:
 */
public class PromotionGoods implements Serializable {

    private Integer promotionId;

    private Long goodsId;

    private String goodsName;

    private Integer promotionTotal;

    private Integer promotionPrice;

    private Date promotionStartTime;

    private Date promotionEndTime;

    public PromotionGoods() {
    }

    public PromotionGoods(Integer promotionId, Long goodsId, String goodsName, Integer promotionTotal, Integer promotionPrice, Date promotionStartTime, Date promotionEndTime) {
        this.promotionId = promotionId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.promotionTotal = promotionTotal;
        this.promotionPrice = promotionPrice;
        this.promotionStartTime = promotionStartTime;
        this.promotionEndTime = promotionEndTime;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPromotionTotal() {
        return promotionTotal;
    }

    public void setPromotionTotal(Integer promotionTotal) {
        this.promotionTotal = promotionTotal;
    }

    public Integer getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Integer promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }
}
