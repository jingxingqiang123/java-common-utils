package com.core.common.function.config;

import com.core.common.function.ResourceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CommonVerifyResourceConfig
 * 声明统一的接口实现
 *
 * @author: admin
 * @create: 2022/03/24 22:11
 */
@Configuration
public class CommonVerifyResourceConfig {
    @Autowired
    private ResourceApi resourceApi;

    @Bean("copyCommonVerifyResource")
    public CommonVerifyResourceFunction copyCommonVerifyResource() {
        return new CommonVerifyResourceFunction("resource", resourceApi::verify0);
    }

    @Bean("backCommonVerifyResource")
    public CommonVerifyResourceFunction cackCommonVerifyResource() {
        return new CommonVerifyResourceFunction("back", resourceApi::verify1);
    }
}
