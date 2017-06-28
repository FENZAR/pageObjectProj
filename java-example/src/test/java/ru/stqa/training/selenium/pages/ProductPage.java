package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page {
    Integer prevQuantity;
    By quantity = By.cssSelector("div#cart > a.content > span.quantity");
    By select = By.cssSelector("select[name = 'options[Size]']");
    By sddToCsrt = By.cssSelector("button[name = 'add_cart_product']");
    By backHome = By.cssSelector("div#site-menu-wrapper a");

    public ProductPage(WebDriver driver) {
        super(driver);
        prevQuantity = 0;
    }

    private Integer getQuantity() {
        return Integer.parseInt(driver.findElement(quantity).getText().trim());
    }

    public ExpectedCondition<Boolean> IsQuantityChanged()
    {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return prevQuantity < getQuantity();
            }
        };
    }

    public void selectSize(Integer index) {
        WebElement e = driver.findElement(select);
        Select sel = new Select(e);
        sel.selectByIndex(index);
    }

    public boolean checkSelectExists() { return isElementPresent(select); }
    public void checkQuantityChanged() { wait.until(IsQuantityChanged()); }
    public void setQuantity() { prevQuantity = getQuantity(); }
    public void clickAddCart() { driver.findElement(sddToCsrt).click(); }
    public void clickBackHome() { driver.findElement(backHome).click(); }
}
