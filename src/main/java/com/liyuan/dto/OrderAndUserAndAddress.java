package com.liyuan.dto;

import com.liyuan.model.MallAddress;
import com.liyuan.model.MallOrder;
import com.liyuan.model.MallUser;

public class OrderAndUserAndAddress {
    private MallUser user;
    private MallOrder order;
    private MallAddress address;

    public MallUser getUser() {
        return user;
    }

    public void setUser(MallUser user) {
        this.user = user;
    }

    public MallOrder getOrder() {
        return order;
    }

    public void setOrder(MallOrder order) {
        this.order = order;
    }

    public MallAddress getAddress() {
        return address;
    }

    public void setAddress(MallAddress address) {
        this.address = address;
    }
}
