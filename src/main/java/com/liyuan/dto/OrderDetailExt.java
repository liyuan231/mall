package com.liyuan.dto;

import com.liyuan.model.MallAddress;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDetailExt {
    private Integer orderId;
    private LocalDateTime updateTime;
    private MallAddress address;
    private List<CartAndGoodsDetailExt> goodsExt;

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public MallAddress getAddress() {
        return address;
    }

    public void setAddress(MallAddress address) {
        this.address = address;
    }

    public List<CartAndGoodsDetailExt> getGoodsExt() {
        return goodsExt;
    }

    public void setGoodsExt(List<CartAndGoodsDetailExt> goodsExt) {
        this.goodsExt = goodsExt;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    //    private List<>;


    public static class CartAndGoodsDetailExt {
        private Integer cartId;
        private Integer goodsId;
        private Integer number;
        private Integer price;
        private String name;

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getCartId() {
            return cartId;
        }

        public void setCartId(Integer cartId) {
            this.cartId = cartId;
        }

        public Integer getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(Integer goodsId) {
            this.goodsId = goodsId;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}





