package com.liyuan.dto;

import java.util.List;

public class SimpleInfoCartAndSum {
    List<SimpleInfoCart> simpleInfoCarts;
    Float sum;

    public List<SimpleInfoCart> getSimpleInfoCarts() {
        return simpleInfoCarts;
    }

    public void setSimpleInfoCarts(List<SimpleInfoCart> simpleInfoCarts) {
        this.simpleInfoCarts = simpleInfoCarts;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }
}
