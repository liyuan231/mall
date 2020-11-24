package com.liyuan.dto;

import com.liyuan.model.MallCart;
import com.liyuan.model.MallGoods;
import com.liyuan.model.MallStorage;

public class CartAndGoodsAndAPrimaryImage {
    private MallCart cart;
    private MallGoods goods;
    private MallStorage storage;

    public MallCart getCart() {
        return cart;
    }

    public void setCart(MallCart cart) {
        this.cart = cart;
    }

    public MallGoods getGoods() {
        return goods;
    }

    public void setGoods(MallGoods goods) {
        this.goods = goods;
    }

    public MallStorage getStorage() {
        return storage;
    }

    public void setStorage(MallStorage storage) {
        this.storage = storage;
    }
}
