package jh.study.junit.parameterized_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterResolverDemo {

    @RegisterExtension
    static final IntegerResolver integerResolver = new IntegerResolver();

    @Test
    void parameterResolverTest(int argument1) {
        assertEquals(2, argument1);
    }
}
