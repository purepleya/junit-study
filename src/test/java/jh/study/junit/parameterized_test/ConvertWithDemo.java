package jh.study.junit.parameterized_test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConvertWithDemo {

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithExplicitArgumentConversion(@ConvertWith(ToStringArgumentConverter.class) String argument) {

        assertNotNull(ChronoUnit.valueOf(argument));
    }

    @ParameterizedTest
    @ValueSource(strings = {"o", "tw", "thr"})
    void testWithExplicitArgumentConversion2(@ConvertWith(ToLengthArgumentConverter.class) Integer length) {
        assertTrue(() -> length > 0);
    }
}
