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
public class DataWriteTaskProvider implements DataTaskProvider<String> {
    /**
     * 数据写能力
     *
     * @param dataTaskType dataTaskType
     * @return 支持写能力
     */
    @Override
    public boolean applicable(String dataTaskType) {
        return DataTaskEnum.WRITE.name().equalsIgnoreCase(dataTaskType);
    }
}
