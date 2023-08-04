package jh.study.junit;

import org.junit.jupiter.api.*;


@TestClassOrder(ClassOrderer.ClassName.class)
public class MethodOrderDemo {

    @Nested
    @TestMethodOrder(MethodOrderer.DisplayName.class)
    class DisplayNameDemo {
        @Test
        @DisplayName("testA")
        void testA() {}

        @Test
        @DisplayName("testB")
        void testB() {}

        @Test
        @DisplayName("testE")
        void testC() {}

        @Test
        void testD() {}
    }

    @Nested
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class MethodNameDemo {

        @Test
        @DisplayName("testA")
        void testA() {}

        @Test
        @DisplayName("testB")
        void testB() {}

        @Test
        @DisplayName("testE")
        void testC() {}

        @Test
        void testD() {}
    }


    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class OrderAnnotationDemo {
        @Test
        void testA() {}

        @Test
        @Order(0)
        void testB() {}

        @Test
        @Order(5)
        void testC() {}

        @Test
        @Order(1)
        void testD() {}
    }


    @Nested
    @TestMethodOrder(MethodOrderer.Random.class)
    class RandomDemo {
        @Test
        void testA() {}

        @Test
        void testB() {}

        @Test
        void testC() {}

        @Test
        void testD() {}
    }

}
