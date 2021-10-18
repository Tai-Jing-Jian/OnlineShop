package com.example.shop_dao.entity;

import java.util.Date;

public class PromotionOrder {
    private Long code;

    private Long buyerId;

    private Integer promotionId;

    private Long goodsId;

    private Byte status;

    private Date createTime;

    public PromotionOrder(Long code, Long buyerId, Integer promotionId, Long goodsId, Byte status, Date createTime) {
        this.code = code;
        this.buyerId = buyerId;
        this.promotionId = promotionId;
        this.goodsId = goodsId;
        this.status = status;
        this.createTime = createTime;
    }

    public PromotionOrder() {
        super();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}