
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Demo04_LifeCycleHooks_Setup_TearDown {

    private Junit.Demo04_DatabaseService db;

    // Setup - runs before every test
    @BeforeEach
    void init() {
        db = new Junit.Demo04_DatabaseService();
        db.connect();
    }

    // Teardown - runs after every test
    @AfterEach
    void cleanup() {
        db.disconnect();
    }

    // PASS TEST CASE
    @Test
    void testInsertAndFetchPass() {

        db.insert("user1", "Sujal");

        assertEquals("Sujal", db.fetch("user1"));
    }


    // FAIL TEST CASE - Wrong Expected Value
    @Test
    void testInsertAndFetchFailValue() {

        db.insert("user1", "Sujal");

        // Actual value = Prasunamba
        // Expected value = WrongName
        assertEquals(
                "WrongName",
                db.fetch("user1"),
                "Expected WrongName but got " + db.fetch("user1")
        );
    }


    // FAIL TEST CASE - Data does not exist
    @Test
    void testFetchNonExistentKeyFail() {

        // No data inserted, fetch returns null
        assertEquals(
                "SomeValue",
                db.fetch("missingKey"),
                "Expected SomeValue but got null"
        );
    }
}
