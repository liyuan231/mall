package com.liyuan.dto;

import com.liyuan.model.MallStorage;
import com.liyuan.model.MallUser;

public class StorageAndUser {
    private MallStorage storage;
    private MallUser user;


    public MallStorage getStorage() {
        return storage;
    }

    public void setStorage(MallStorage storage) {
        this.storage = storage;
    }

    public MallUser getUser() {
        return user;
    }

    public void setUser(MallUser user) {
        this.user = user;
    }
}
