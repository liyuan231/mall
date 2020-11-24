package com.liyuan.component.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

@Configuration
@ConditionalOnProperty(prefix = "qcloud.cos", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(COSProperties.class)
public class COSConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public COSClient cosClient(@Autowired COSProperties properties) {
        Assert.notNull(properties.getSecretId(), "the secretId of the qcloud-OSS should not be null!");
        Assert.notNull(properties.getSecretKey(), "the secretKey of the qcloud-OSS should not be null!");
        Assert.notNull(properties.getRegionName(), "the regionName of the qcloud-OSS should not be null!");
        COSCredentials cosCredentials = new BasicCOSCredentials(properties.getSecretId(), properties.getSecretKey());
        Region region = new Region(properties.getRegionName());
        ClientConfig clientConfig = new ClientConfig(region);
        return new COSClient(cosCredentials, clientConfig);
    }
}
