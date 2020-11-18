package com.liyuan.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {
//    @Value("${file.path:}")
//    private String filePath;
//
//    @Value("${web.path:""}")
//    private String webPath;
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(new String[]{this.springFilePath + "**"}).addResourceLocations(new String[]{"file:" + this.filePath}).setCachePeriod(31556926);
        registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/static/admin/").resourceChain(true)
        .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
    }

}
