package com.liyuan.utils;

public enum  RoleEnum {
    ADMIN(1),
    USER(2),
    STORE(3);

    RoleEnum(int value) {
        this.value = value;
    }

    private int value;

    public int value() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
