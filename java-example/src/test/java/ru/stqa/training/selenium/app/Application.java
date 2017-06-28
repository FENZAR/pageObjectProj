package ru.stqa.training.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.training.selenium.pages.CheckoutPage;
import ru.stqa.training.selenium.pages.MainPage;
import ru.stqa.training.selenium.pages.ProductPage;

public class Application {
    private WebDriver driver;
    private MainPage mainPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void addItemsToCart(Integer numOfItems) {
        mainPage.open();
        for(int i = 0; i < numOfItems; i++) {
            mainPage.clickFirstProduct();

            if(productPage.checkSelectExists())
                productPage.selectSize(1);

            productPage.setQuantity();
            productPage.clickAddCart();
            productPage.checkQuantityChanged();
            productPage.clickBackHome();
        }
        mainPage.clickCheckout();
    }

    public void removeItems() {
        while (checkoutPage.checkProductsInCart()) {
            checkoutPage.findProdInTable();
            checkoutPage.clickButtonRemove();
            checkoutPage.checkRemoved();
        }
    }

    public void quit() { driver.quit(); }
}
