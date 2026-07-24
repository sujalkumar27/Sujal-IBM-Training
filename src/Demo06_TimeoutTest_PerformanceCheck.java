
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class Demo06_TimeoutTest_PerformanceCheck {


    // PASS TEST CASE
    @Test
    void testQuickExecutionPass() {

        Demo06_PerformanceService service = new Demo06_PerformanceService();

        assertTimeout(Duration.ofMillis(500), () -> {
            service.quickOperation();
        });
    }


    // FAIL TEST CASE - Operation exceeds timeout
    @Test
    void testSlowExecutionFail() {

        Demo06_PerformanceService service = new Demo06_PerformanceService();

        assertTimeout(Duration.ofMillis(500), () -> {
            service.slowOperation();
        });
    }


    // FAIL TEST CASE - Timeout value is too small
    @Test
    void testUnrealisticTimeoutFail() {

        Demo06_PerformanceService service = new Demo06_PerformanceService();

        assertTimeout(Duration.ofMillis(50), () -> {
            service.quickOperation();
        });
    }
}
