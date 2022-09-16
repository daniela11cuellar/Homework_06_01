package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.IsPresentElement;
import utils.Scroll;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Home {

    WebDriver driver;

    By slickCurrent = By.className("slick-current");

    By pagingInfo = By.className("paging-info");

    By nextCarrousel = By.className("slick-next");

    By topSearches = By.xpath("//a[contains(@id, 'top_searches')]");

    By logo = By.className("header-logo");

    By digitalCollections = By.xpath("//a[contains(text(), 'Digital Collections')]");

    By takeOurSurvey = By.xpath("//a[contains(text(), 'Take our survey')]");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getPaging() {
        WebElement slickCurrentElement = driver.findElement(slickCurrent);
        return slickCurrentElement.findElement(pagingInfo).getText();
    }

    public void clickOnNextCarrousel() {
        driver.findElement(nextCarrousel).click();
    }

    public void waitNewCarrousel(int page, int maxPage) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement slickCurrentElement = driver.findElement(slickCurrent);

        wait.until(ExpectedConditions.visibilityOf(slickCurrentElement));
        WebElement paging = slickCurrentElement.findElement(pagingInfo);
        wait.until(ExpectedConditions.textToBePresentInElement(paging,page+"/"+maxPage));
    }

    public String clickRandomTopSearch(){
        List<WebElement> topSearchElements = driver.findElements(topSearches);
        int randomTopSearch = ThreadLocalRandom.current().nextInt(0, topSearchElements.size());
        String topSelected = topSearchElements.get(randomTopSearch).getText();
        topSearchElements.get(randomTopSearch).click();
        return topSelected;
    }

    public void clickOnDigitalCollections() {
        WebElement linkDigital = driver.findElement(digitalCollections);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", linkDigital);
    }

    public void clickOnLogoToBack() {
        driver.findElement(logo).click();
    }

    public void scrollToSurvey() throws InterruptedException {
        WebElement takeSurvey = driver.findElement(takeOurSurvey);
        Scroll.scrollToElement(driver, takeSurvey);
        Thread.sleep(500);
    }

    public void clickOnToSurvey() {
        driver.findElement(takeOurSurvey).click();
    }
}
