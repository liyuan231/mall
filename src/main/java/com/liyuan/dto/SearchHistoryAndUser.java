package com.liyuan.dto;

import com.liyuan.model.MallSearchHistory;
import com.liyuan.model.MallUser;

public class SearchHistoryAndUser {
    private MallUser user;
    private MallSearchHistory searchHistory;

    public MallUser getUser() {
        return user;
    }

    public void setUser(MallUser user) {
        this.user = user;
    }

    public MallSearchHistory getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(MallSearchHistory searchHistory) {
        this.searchHistory = searchHistory;
    }
}
