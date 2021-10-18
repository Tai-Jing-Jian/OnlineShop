package com.example.shop_dao.entity;

import java.util.Date;

public class BuyerShoppingCartKey {
    private Long buyerId;

    private Long goodsId;

    private Integer number;

    private Date createTime;

    public BuyerShoppingCartKey(Long buyerId, Long goodsId, Integer number, Date createTime) {
        this.buyerId = buyerId;
        this.goodsId = goodsId;
        this.number = number;
        this.createTime = createTime;
    }

    public BuyerShoppingCartKey() {
        super();
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}