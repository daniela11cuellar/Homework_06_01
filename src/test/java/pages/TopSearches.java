package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.IsPresentElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TopSearches {

    WebDriver driver;

    By itemTopSearch = By.className("item");

    By originalFormatTopSearch = By.className("original-format");

    By titleTopSearch = By.className("item-description-title");

    By contributorTopSearch = By.className("contributor");

    By dateTopSearch = By.className("date");

    By span = By.xpath("//span");

    By imgTopSearch = By.className("iconic");

    public TopSearches(WebDriver driver) {
        this.driver = driver;
    }

    public void validateResultTopSearch() {
        WebElement item = driver.findElement(itemTopSearch);
        String originalFormat = item.findElement(originalFormatTopSearch).getText();
        String title = item.findElement(titleTopSearch).getText();

        WebElement contributor = driver.findElement(contributorTopSearch);
        String contributorSpan = contributor.findElement(span).getText();

        WebElement date = driver.findElement(dateTopSearch);
        String dateSpan = date.findElement(span).getText();

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertFalse(originalFormat.equals(""), "The format is not present");
        softAssertion.assertFalse(title.equals(""), "The title is not present");
        softAssertion.assertFalse(contributorSpan.equals(""), "The contributor is not present");
        softAssertion.assertFalse(dateSpan.equals(""), "The date is not present");
        softAssertion.assertTrue(IsPresentElement.isTheElementPresent(driver, imgTopSearch), "The img is not present");
        
        softAssertion.assertAll();

    }
}
