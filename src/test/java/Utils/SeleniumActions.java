package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions {
    public static void click(WebDriver driver, By by, int waitTimeInSeconds) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));

        // scroll até o elemento
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        // agora espera ficar clicável
        new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
                .until(ExpectedConditions.elementToBeClickable(element));

        element.click();
    }

    public WebElement sendData (WebDriver driver, By by, String data, int waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds)); // criar uma espera explícita

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); // esperar até que o elemento esteja presente na página
        WebElement webElement = driver.findElement(by); // encontrar o elemento

        webElement.sendKeys(data); // enviar os dados para o elemento

        return webElement;
    }

    public void scrollToElement(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", element);
    }

    public String getAttributeValue (WebDriver driver, By by, String attribute, int waitTimeInSeconds) {
        String attributeValue = "";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); // esperar até que o elemento esteja presente na página

        WebElement webElement = driver.findElement(by); // encontrar o elemento

        attributeValue = webElement.getAttribute(attribute); // obter o valor do atributo

        return attributeValue;
    }
}
