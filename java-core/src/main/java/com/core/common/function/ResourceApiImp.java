package com.core.common.function;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ResourceApiImp
 *
 * @author: admin
 * @create: 2022/03/24 22:40
 */
@Service
@Slf4j
public class ResourceApiImp implements ResourceApi {
    @Override
    public void verify0(String userId, List<String> resourceList) {
        log.info("verify0 succes, userId: {},resourceList:{}", userId, resourceList);
    }

    @Override
    public void verify1(String userId, List<String> resourceList) {
        log.info("verify1 succes, userId: {},resourceList:{}", userId, resourceList);
    }

    @Override
    public void verify2(String userId, List<String> resourceList) {
        log.info("verify2 succes, userId: {},resourceList:{}", userId, resourceList);
    }
}
