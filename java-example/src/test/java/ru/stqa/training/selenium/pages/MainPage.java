package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
    By product = By.cssSelector("div#box-most-popular a:first-child");
    By checkout = By.xpath("//a[contains(text(), 'Checkout »')]");

    public  MainPage(WebDriver driver) { super(driver); }
    public void open() { driver.get("http://localhost/litecart/en/"); }
    public void clickFirstProduct() { driver.findElement(product).click(); }
    public void clickCheckout() { driver.findElement(checkout).click(); }
}
