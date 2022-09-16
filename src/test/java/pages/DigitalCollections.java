package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.IsPresentElement;

public class DigitalCollections {
    WebDriver driver;

    By collectionsHeader = By.className("collections-header");

    By searchBar = By.id("search");

    By btnSearch = By.className("icon-search");

    public DigitalCollections(WebDriver driver) {
    this.driver = driver;
}

    public void waitDigitalCollectionPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement collectionHead = driver.findElement(collectionsHeader);
        wait.until(ExpectedConditions.visibilityOf(collectionHead));
    }

    public void assertDigitalCollectionIsPresent() {
        Assert.assertTrue(IsPresentElement.isTheElementPresent(driver, collectionsHeader), "The Digital Collection title is not present");
    }

    public void searchKeyWord(String keyWord) {
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(keyWord);
    }

    public void clickOnSearch() {
        driver.findElement(btnSearch).click();
    }
}
