package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends Page {
    WebElement element;
    By nameProduct = By.cssSelector("form[name = 'cart_form'] > div a > strong");
    By buttonRemove = By.cssSelector("button[name = 'remove_cart_item']");

    public CheckoutPage(WebDriver driver) { super(driver); }
    private String getName() { return driver.findElement(nameProduct).getText(); }
    public boolean checkProductsInCart() { return isElementPresent(nameProduct); }
    public void clickButtonRemove() { driver.findElement(buttonRemove).click(); }
    public void checkRemoved() { wait.until(ExpectedConditions.stalenessOf(element)); }

    public void findProdInTable() {
        String xpathSelector;
        xpathSelector = String.format("//table[@class = 'dataTable rounded-corners']//td[contains(text(), \"%s\")]", getName());
        element = driver.findElement(By.xpath(xpathSelector));
    }
}
