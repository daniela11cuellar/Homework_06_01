package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.IsPresentElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Survey {

    WebDriver driver;

    By questionField = By.className("question-fieldset");

    By questionLabel = By.className("radio-button-label");

    By btnSubmit = By.className("survey-page-button");

    By thanksMessage = By.className("thanks-message");



    public Survey(WebDriver driver) {
        this.driver = driver;
    }


    public int getNumberOfQuestions(){
        int size = driver.findElements(questionField).size();
        return size;
    }

    public void checkWhatYouWereLookingFor() {
        WebElement firstQuestion = driver.findElements(questionField).get(0);

        List<WebElement> labels = firstQuestion.findElements(questionLabel);
        int randomTopSearch = ThreadLocalRandom.current().nextInt(0, labels.size());
        labels.get(randomTopSearch).click();

        Assert.assertTrue(labels.get(randomTopSearch).getAttribute("className").contains("checked"),
                "The option in the question: 'What you were looking for?' is not selected");
    }

    public void checkWhichOptionBestDescribesYou() {
        WebElement secondQuestion = driver.findElements(questionField).get(1);

        List<WebElement> labels = secondQuestion.findElements(questionLabel);
        int randomTopSearch = ThreadLocalRandom.current().nextInt(0, labels.size());
        labels.get(randomTopSearch).click();

        Assert.assertTrue(labels.get(randomTopSearch).getAttribute("className").contains("checked"),
                "The option in the question 'Which option best describes you?' is not selected");
    }

    public void checkHowFamiliarAreYouWith() {
        WebElement thirdQuestion = driver.findElements(questionField).get(2);

        List<WebElement> labels = thirdQuestion.findElements(questionLabel);
        int randomTopSearch = ThreadLocalRandom.current().nextInt(0, labels.size());
        labels.get(randomTopSearch).click();

        Assert.assertTrue(labels.get(randomTopSearch).getAttribute("className").contains("checked"),
                "The option in the question 'how familiar are you with?' is not selected");
    }
    public void clickOnSubmit() {
        driver.findElement(btnSubmit).click();
    }

    public void validateThanksMessage(){
        Assert.assertTrue(IsPresentElement.isTheElementPresent(driver, thanksMessage), "The thanks message is not present");
    }
}
