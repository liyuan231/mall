package com.liyuan.component.jwt;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({JwtProperties.class})
@ConditionalOnProperty(prefix = "jwt.config", name = "enabled", matchIfMissing = true,havingValue = "true")
public class JwtConfiguration {

}
