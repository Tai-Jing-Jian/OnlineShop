package com.example.shop_dao.entity;

import java.util.Date;

public class BuyerOrder {
    private Long code;

    private Long buyerId;

    private Long goodsId;

    private Integer number;

    private Date createTime;

    private Byte status;

    public BuyerOrder(Long code, Long buyerId, Long goodsId, Integer number, Date createTime, Byte status) {
        this.code = code;
        this.buyerId = buyerId;
        this.goodsId = goodsId;
        this.number = number;
        this.createTime = createTime;
        this.status = status;
    }

    public BuyerOrder() {
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}