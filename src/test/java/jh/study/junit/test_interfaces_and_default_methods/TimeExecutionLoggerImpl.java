package jh.study.junit.test_interfaces_and_default_methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeExecutionLoggerImpl implements TestLifecycleLogger, TimeExecutionLogger, TestInterfaceDynamicTestsDemo  {

    @Test
    void isEqualValue() {
        assertEquals(1, "a".length(), "is always equal");
    }
}
