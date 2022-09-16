package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IsPresentElement {

    public static boolean isTheElementPresent(WebDriver driver, By by) {
        boolean isPresent = false;
        try {
            driver.findElement(by);
            isPresent = true;
        } catch (Exception e) {
            System.out.println("The element is not present");
        }
        return isPresent;
    }
}
