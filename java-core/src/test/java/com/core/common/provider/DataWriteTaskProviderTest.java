package com.core.common.provider;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DataWriteTaskProvider test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DataWriteTaskProviderTest {
    @Autowired
    private ProviderManager providerManager;

    /**
     * 根据类型返回对应的provider
     *
     * @throws Exception
     */
    @Test
    public void providerManager() throws Exception {
        DataTaskProvider write = providerManager
                .findDataTaskProvider(DataTaskProvider.class, "Write", null);
        System.out.println(write);
        Assert.assertTrue(write instanceof DataWriteTaskProvider);
        DataTaskProvider Read = providerManager
                .findDataTaskProvider(DataTaskProvider.class, "Read", null);
        System.out.println(Read);
        Assert.assertTrue(Read instanceof DataReadTaskProvider);
    }

    /**
     * 根据类型能找到对应的provider，就返回找到的provider，不能找到就返回默认的provider
     *
     * @throws Exception
     */
    @Test
    public void findDefaultDataTaskProvider() throws Exception {
        DataWriteTaskProvider dataWriteTaskProvider = new DataWriteTaskProvider();
        DataTaskProvider dataTaskProvider = providerManager
                .findDefaultDataTaskProvider(DataTaskProvider.class, "Read1111", dataWriteTaskProvider);
        System.out.println(dataTaskProvider);
        Assert.assertTrue(dataTaskProvider instanceof DataWriteTaskProvider);

        DataTaskProvider dataReadTaskProvider = providerManager
                .findDefaultDataTaskProvider(DataTaskProvider.class, "Read", dataWriteTaskProvider);
        System.out.println(dataReadTaskProvider);
        Assert.assertTrue(dataReadTaskProvider instanceof DataReadTaskProvider);
    }
}
