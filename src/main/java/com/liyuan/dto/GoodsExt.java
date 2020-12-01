package com.liyuan.dto;

import com.liyuan.model.MallGoods;

public class GoodsExt extends MallGoods {
    private String primaryImage;

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }
}
