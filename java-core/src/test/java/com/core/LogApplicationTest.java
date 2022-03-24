package com.core;

import com.core.common.function.CommonVerifyResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogApplicationTest {
    @Autowired
    private List<CommonVerifyResource> commonVerifyResourcelist;

    @Test
    public void generateEasyToken() {
        String type = "resource";
        String userId = "1123";
        List<String> resourceIds = Arrays.asList("1123", "2222");

        Optional<CommonVerifyResource> verifyResource =
                commonVerifyResourcelist.stream()
                        .filter(commonVerifyResource -> type.equals(commonVerifyResource.getType())).findFirst();
        verifyResource.ifPresent(verifyResource1 -> verifyResource1.verify(userId, resourceIds));
    }
}