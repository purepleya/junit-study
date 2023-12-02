package jh.study.junit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMethodOrderTest {

    @Test
    @Order(3)
    @DisplayName("세번째 테스트")
    void test3() {
        System.out.println("세번째 테스트");
    }

    @Test
    @Order(1)
    @DisplayName("첫번째 테스트")
    void test1() {
        System.out.println("첫번째 테스트");
    }

    @Test
    @Order(2)
    @DisplayName("두번째 테스트")
    void test2() {
        System.out.println("두번째 테스트");
    }

}
