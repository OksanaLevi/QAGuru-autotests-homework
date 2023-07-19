package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest {

    static void beforeAll () {
        Configuratio
    }

    @Test
    void firstTest () {
        System.out.println("   firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest () {
        System.out.println("   secondTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void thirdTest () {
        System.out.println("   thirdTest");
        Assertions.assertTrue(3 > 2);
    }
}
