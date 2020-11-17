package com.liyuan.component.jwt;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class JwtPayloadBuilder {
    private Map<String, String> payload = new HashMap<>();
    private Map<String, String> additional;
    private String issuer;
    private String subscriber;
    private String audience;
    private LocalDateTime expiration ;//= this.issueAt.plusDays(3);
    private LocalDateTime issueAt; //= LocalDateTime.now();
    private Set<String> roles;
    private String jti;

    public JwtPayloadBuilder issuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    public JwtPayloadBuilder subscriber(String subscriber) {
        this.subscriber = subscriber;
        return this;
    }

    public JwtPayloadBuilder audience(String audience) {
        this.audience = audience;
        return this;
    }

    public JwtPayloadBuilder roles(Set<String> roles) {
        this.roles = roles;
        return this;
    }

    public JwtPayloadBuilder additional(Map<String, String> additional) {
        this.additional = additional;
        return this;
    }

    public JwtPayloadBuilder expirationDays(int days) {
        Assert.isTrue(days > 0, "expiration days should be positive!");
        this.issueAt = LocalDateTime.now();
        this.expiration = this.issueAt.plusDays(days);
        return this;
    }

    public String build() {
        if(Objects.isNull(this.issueAt)||Objects.isNull(this.expiration)){
            this.issueAt = LocalDateTime.now();
            this.expiration = this.issueAt.plusDays(5);//默认token5天过期
        }
        payload.put("issuer", this.issuer);
        payload.put("subscriber", subscriber);
        payload.put("audience", audience);
        payload.put("issueAt", issueAt.toString());
        payload.put("expiration", expiration.toString());
        payload.put("roles", JSONObject.toJSONString(this.roles));
        payload.put("additional", JSONObject.toJSONString(additional));
        return JSONObject.toJSONString(payload);
    }
}
