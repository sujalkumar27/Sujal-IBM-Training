
public class Demo06_PerformanceService {

    // Method completes within the expected time
    public void quickOperation() {
        try {
            Thread.sleep(100); // Simulates 100ms operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    // Method takes more time than allowed timeout
    public void slowOperation() {
        try {
            Thread.sleep(1000); // Simulates 1000ms operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
