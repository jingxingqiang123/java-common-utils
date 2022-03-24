package com.core.common.function.config;

import com.core.common.function.CommonVerifyResource;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * CopyCommonVerifyResource
 * 根据type进行接口的调用
 *
 * @author: admin
 * @create: 2022/03/24 22:10
 */
public class CommonVerifyResourceFunction implements CommonVerifyResource {
    private final String type;
    private final BiConsumer<String, List<String>> function;

    public CommonVerifyResourceFunction(String type, BiConsumer<String, List<String>> function) {
        this.type = type;
        this.function = function;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void verify(String userId, List<String> resourceIds) {
        function.accept(userId, resourceIds);
    }
}
