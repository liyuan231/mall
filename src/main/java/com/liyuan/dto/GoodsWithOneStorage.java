package com.liyuan.dto;

import com.liyuan.model.MallGoods;
import com.liyuan.model.MallStorage;

public class GoodsWithOneStorage {
    private MallGoods goods;
    private MallStorage storage;

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
