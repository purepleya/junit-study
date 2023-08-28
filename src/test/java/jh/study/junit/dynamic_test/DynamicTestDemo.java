
package jh.study.junit.dynamic_test;
import jh.study.junit.Calculator;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Named.named;

public class DynamicTestDemo {

    private final Calculator calculator = new Calculator();

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    @TestFactory
    List<String> dynamicTestWithInvalidReturnType() {
        return Arrays.asList("Hello");
    }


    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> assertTrue(isPalindrome("madam"))),
                dynamicTest("2nd dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        );
    }


    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {
        return Arrays.asList(
                dynamicTest("3rd dynamic test", () -> assertTrue(isPalindrome("madam"))),
                dynamicTest("4th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        );
    }


    @TestFactory
    Iterator<DynamicTest> dynamicTestsFromIterator() {
        return Arrays.asList(
                dynamicTest("5rd dynamic test", () -> assertTrue(isPalindrome("madam"))),
                dynamicTest("6th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        ).iterator();
    }


    @TestFactory
    DynamicTest[] dynamicTestsFromArray() {
        return new DynamicTest[]{
                dynamicTest("7th dynamic test", () -> assertTrue(isPalindrome("madam"))),
                dynamicTest("8th dynamic test", () -> assertEquals(4, calculator.multiply(2, 2)))
        };
    }


    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("racecar", "radar", "mom", "dad")
                .map(text -> dynamicTest(text, () -> assertTrue(isPalindrome(text))));
    }


    @TestFactory
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        return IntStream.iterate(0, n -> n + 2).limit(10)
                .mapToObj(n -> dynamicTest("test" + n, () -> assertTrue(n % 2 == 0)));
    }


    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTestsFromIterator() {
        Iterator<Integer> inputGenerator = new Iterator<Integer>() {
            Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(100);
                return current % 7 != 0;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;
        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);

        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }


    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamFactoryMethod() {
        Stream<String> inputStream = Stream.of("racecar", "radar", "mom", "dad");
        Function<String, String> displayNameGenerator = text -> text + " is a palindrome";
        ThrowingConsumer<String> testExecutor = text -> assertTrue(isPalindrome(text));

        return DynamicTest.stream(inputStream, displayNameGenerator, testExecutor);
    }


    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamFactoryMethodWithNames() {
        Stream<Named<String>> inputStream = Stream.of(
                named("racecar is a palindrome", "racecar"),
                named("radar is alson a palindrome", "radar"),
                named("mom alson seems to be a palidrome", "mom"),
                named("dad is yet another palindrome", "dad")
        );

        return DynamicTest.stream(inputStream, text -> assertTrue(isPalindrome(text)));
    }


    @TestFactory
    Stream<DynamicNode> dynamicTestsWithContainers() {
        return Stream.of("A", "B", "C")
                .map(input -> dynamicContainer(
                        "Container " + input,
                        Stream.of(
                                dynamicTest("not null", () -> assertNotNull(input)),
                                dynamicContainer("properties", Stream.of(
                                        dynamicTest("length > 0", () -> assertTrue(input.length() > 0)),
                                        dynamicTest("not empty", () -> assertFalse(input.isEmpty()))
                                ))
                        )
                ));
    }


    @TestFactory
    DynamicNode dynamicNodeSingleTest() {
        return dynamicTest("'pop' is a palindrome", () -> assertTrue(isPalindrome("pop")));
    }


    @TestFactory
    DynamicNode dynamicNodeSingleContainer() {
        return dynamicContainer("palidromes",
                Stream.of("racecar", "radar", "mom", "dad")
                .map(text -> dynamicTest(text, () -> assertTrue(isPalindrome(text)))
            ));
    }
}
