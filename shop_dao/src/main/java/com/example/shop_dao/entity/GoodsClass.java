package com.example.shop_dao.entity;

public class GoodsClass {
    private Integer id;

    private String name;

    private Byte isActive;

    public GoodsClass(Integer id, String name, Byte isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public GoodsClass() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}