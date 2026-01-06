package com.my.project.api.domain.user.exception;

import io.inugami.commons.test.UnitTestHelper;
import org.junit.jupiter.api.Test;

class UserWarningTest {

    @Test
    void assertUserWarning() {
        UnitTestHelper.assertWaringCodeUnique(UserWarning.values());
        UnitTestHelper.assertWarningCode("api/domain/user/exception/assertUserWarning.json",
                                         UserWarning.values());
    }
}