package com.liyuan.dto;

import java.time.LocalDateTime;

public class SimpleInfoCart {
    private Integer cartId;
    private String name;
    private Integer goodsId;
    private Float goodsPrice;
    private Integer number;
    private Boolean checked;
    private String picUrl;
    private Float sum;
    private LocalDateTime updateTime;

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public SimpleInfoCart() {
    }


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
