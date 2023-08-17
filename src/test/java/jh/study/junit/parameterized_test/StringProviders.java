package jh.study.junit.parameterized_test;

import java.util.stream.Stream;

public class StringProviders {

    static Stream<String> tinyStrings() {
        return Stream.of(".", "oo", "OOO");
    }
}
