package com.example.shop_dao.entity;

import java.util.Date;

public class PromotionGoods {
    private Integer id;

    private Long goodsId;

    private Integer total;

    private Integer price;

    private Date startTime;

    private Date endTime;

    private Byte isActive;

    private Date createTime;

    public PromotionGoods(Integer id, Long goodsId, Integer total, Integer price, Date startTime, Date endTime, Byte isActive, Date createTime) {
        this.id = id;
        this.goodsId = goodsId;
        this.total = total;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.createTime = createTime;
    }

    public PromotionGoods() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}