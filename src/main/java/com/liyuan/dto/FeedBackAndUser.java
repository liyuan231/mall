package com.liyuan.dto;

import com.liyuan.model.MallFeedback;
import com.liyuan.model.MallUser;

public class FeedBackAndUser {
    private MallFeedback feedback;
    private MallUser user;

    public MallFeedback getFeedback() {
        return feedback;
    }

    public void setFeedback(MallFeedback feedback) {
        this.feedback = feedback;
    }

    public MallUser getUser() {
        return user;
    }

    public void setUser(MallUser user) {
        this.user = user;
    }
}
