package com.core.common.provider;

import com.core.common.provider.enums.DataTaskEnum;
import org.springframework.stereotype.Component;

/**
 * DataReadTaskProvider
 *
 * @author: admin
 * @create: 2022/06/09 23:35
 */
@Component
public class DataReadTaskProvider implements DataTaskProvider<String> {
    /**
     * 数据读取能力
     *
     * @param dataTaskType dataTaskType
     * @return 支持读能力
     */
    @Override
    public boolean applicable(String dataTaskType) {
        return DataTaskEnum.READ.name().equalsIgnoreCase(dataTaskType);
    }
}
