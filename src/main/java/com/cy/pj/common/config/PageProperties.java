package com.cy.pj.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ConfigurationProperties(prefix="") 描述的配置文件的前缀名
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "db.page")
public class PageProperties {
    private  int pageSize;
}
