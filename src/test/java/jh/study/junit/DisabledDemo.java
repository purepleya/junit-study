package jh.study.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DisabledDemo {
    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }


    @Disabled
    @Nested
    class DisabledTestClass {
        @Test
        void testWillBeSkipped() {
        }
    }

    @Nested
    class EnsabledTestClass {
        @Test
        void testWillBeExecuted() {
        }
    }

}
