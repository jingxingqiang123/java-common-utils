package com.core.common.function;

import java.util.List;

public interface CommonVerifyResource {

    String getType();

    void verify(String userId, List<String> resourceIds);
}
