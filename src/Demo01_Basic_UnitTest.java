
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class Demo01_Basic_UnitTest {
    // Pass Test Case
    @Test
    void testAddition() {
        Demo01_Calculator calc = new Demo01_Calculator();

        assertEquals(15, calc.add(10, 5));
    }
    // Fail Test Case
    @Test
    void testAdditionFail() {
        Demo01_Calculator calc = new Demo01_Calculator();

        // This test is intentionally written to fail
        assertEquals(20, calc.add(10, 5), "Expected 20 but actual is 15");
    }
}
