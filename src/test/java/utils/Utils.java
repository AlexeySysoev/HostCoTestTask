package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utils {
    public void scrollToAccordion(WebElement element){
        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        element
                );
    }
}
