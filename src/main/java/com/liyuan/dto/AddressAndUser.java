package com.liyuan.dto;

import com.liyuan.model.MallAddress;
import com.liyuan.model.MallUser;

public class AddressAndUser {
    private MallAddress address;
    private MallUser user;

    public MallAddress getAddress() {
        return address;
    }

    public void setAddress(MallAddress address) {
        this.address = address;
    }

    public MallUser getUser() {
        return user;
    }

    public void setUser(MallUser user) {
        this.user = user;
    }
}
