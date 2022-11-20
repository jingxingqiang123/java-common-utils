package com.core.common.provider;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * ProviderManager
 *
 * @author: admin
 * @create: 2022/06/09 23:32
 */
@Component
public class ProviderManager {
    private final ApplicationContext applicationContext;

    public ProviderManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public <E, T extends DataTaskProvider> T findDataTaskProvider(Class<T> cla, E identity, Exception exception)
            throws Exception {
        Collection<T> providers = findProviders(cla);
        for (T provider : providers) {
            if (provider.applicable(identity)) {
                return provider;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return null;
    }

    public <T extends DataTaskProvider> DataTaskProvider<String> findDefaultDataTaskProvider(Class<T> cla,
        String dataTaskType, DataTaskProvider<String> dataTaskProvider) throws Exception {
        DataTaskProvider<String> dataTaskProvider1 = findDataTaskProvider(cla, dataTaskType, null);
        if (dataTaskProvider1 == null) {
            return dataTaskProvider;
        }
        return dataTaskProvider1;
    }

    private <T extends DataTaskProvider> Collection<T> findProviders(Class<T> cla) {
        return applicationContext.getBeansOfType(cla).values();
    }

}
