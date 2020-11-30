package com.liyuan.utils;

public enum FileEnum {
    GOODS_PRIMARY_IMAGE(10),
    GOODS_IMAGE(11),
    AVATAR(1);

    FileEnum(int type) {
        this.value = type;
    }

    public int value() {
        return value;
    }

    public void setValue(int type) {
        this.value = type;
    }

    private int value;
}
