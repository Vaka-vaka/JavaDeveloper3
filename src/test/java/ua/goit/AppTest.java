package ua.goit;

import static org.junit.Assert.assertTrue;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        App app = new App();
        app.test();
        assertTrue(true);
    }
}
