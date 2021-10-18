package com.example.shop_dao.entity;

import java.util.Date;

public class Goods {
    private Long id;

    private String name;

    private Integer classId;

    private Long sellerId;

    private Integer price;

    private Integer stock;

    private Byte isActive;

    private Date purchaseTime;

    private Date createTime;

    public Goods(Long id, String name, Integer classId, Long sellerId, Integer price, Integer stock, Byte isActive, Date purchaseTime, Date createTime) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.sellerId = sellerId;
        this.price = price;
        this.stock = stock;
        this.isActive = isActive;
        this.purchaseTime = purchaseTime;
        this.createTime = createTime;
    }

    public Goods() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}