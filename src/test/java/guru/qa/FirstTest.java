package guru.qa;

import org.junit.jupiter.api.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
        //Configuration.browser = "chrome";
    }

    @BeforeEach
    void beforeEach() {
        // open("https://google.com");
        System.out.println("  beforeEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @AfterEach
    void afterEach() {
        // open("https://google.com");
        System.out.println("  afterEach");
    }

    @Test
    void firstTest() {
        System.out.println("      firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("      secondTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("      thirdTest");
        Assertions.assertTrue(3 > 2);
    }
}
