package com.liyuan.dto;

import java.time.LocalDateTime;

public class StoreOrderDetail {
    private Integer orderId;
    private String addressDetail;
    private String name;
    private String mobile;
    private String goodsName;
    private Integer goodsNumber;
    private Integer orderCartStatus;
    private LocalDateTime updateTime;
    private Integer orderCartId;

    public Integer getOrderCartId() {
        return orderCartId;
    }

    public void setOrderCartId(Integer orderCartId) {
        this.orderCartId = orderCartId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getOrderCartStatus() {
        return orderCartStatus;
    }

    public void setOrderCartStatus(Integer orderCartStatus) {
        this.orderCartStatus = orderCartStatus;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
