package com.liyuan.component.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt.config")
public class JwtProperties {
    private boolean enabled;
    private String keyLocation;
    private String keyAlias;
    private String keyPass;
    private String issuer;
    private String subscriber;
    private int tokenExpirationDays;
    private int refreshTokenExpirationDays;

    public JwtProperties(Builder builder) {
        keyLocation = builder.keyLocation;
        keyAlias = builder.keyAlias;
        keyPass = builder.keyPass;
        issuer = builder.issuer;
        subscriber = builder.subscriber;
        tokenExpirationDays = builder.tokenExpirationDays;
        refreshTokenExpirationDays = builder.refreshTokenExpirationDays;
        enabled = builder.enabled;
    }

    public static class Builder {
        private String keyLocation;
        private String keyAlias;
        private String keyPass;
        private String issuer;
        private boolean enabled = true;
        private String subscriber = "all";
        private int tokenExpirationDays = 5;
        private int refreshTokenExpirationDays = 10;

        public Builder(String keyAlias, String keyLocation, String keyPassword, String keyIssuer) {
            this.keyLocation = keyLocation;
            this.keyPass = keyPassword;
            this.issuer = keyIssuer;
            this.keyAlias = keyAlias;
        }

        public Builder subscriber(String subscriber) {
            this.subscriber = subscriber;
            return this;
        }

        public Builder tokenExpirationDay(int tokenExpirationDays) {
            this.tokenExpirationDays = tokenExpirationDays;
            return this;
        }

        public Builder refreshTokenExpirationDays(int refreshTokenExpirationDays) {
            this.refreshTokenExpirationDays = refreshTokenExpirationDays;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public JwtProperties build() {
            return new JwtProperties(this);
        }
    }

}
