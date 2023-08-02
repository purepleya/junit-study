package jh.study.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionsDemo {
    private final Calculator calculator = new Calculator();

    private String env = "CI";

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(env));
        // remainder of test
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        assumeTrue("DEV".equals(env),
                () -> "Aborting test: not on developer workstation");
        // remainder of test
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(env),
                () -> {
                    // perform these assertions only on the CI server
                    assertEquals(2, calculator.divide(4, 2));
                });

        // perform these assertions in all environments
        assertEquals(42, calculator.multiply(6, 7));
    }
}
