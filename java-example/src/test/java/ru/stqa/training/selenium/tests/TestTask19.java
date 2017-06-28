package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import ru.stqa.training.selenium.app.Application;

public class TestTask19 {

    public  static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @Before
    public  void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null;}));
    }

    @Test
    public void TestTask19() {
        app.addItemsToCart(3);
        app.removeItems();
    }
}
