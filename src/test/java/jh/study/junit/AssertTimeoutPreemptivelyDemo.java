package jh.study.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class AssertTimeoutPreemptivelyDemo {

    @Test
    @DisplayName("assertTimeoutPreemptively Demo")
    void testAssertTimeoutPreemptively() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            Thread.sleep(4000);
        }, "Timeout !!!!");
    }
}
