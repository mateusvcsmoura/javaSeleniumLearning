package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions {
    public static void click (WebDriver driver, By by, int waitTimeInSeconds) { // metodo para clicar em um elemento
        WebElement webElement = (new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds)))
                .until(ExpectedConditions.elementToBeClickable(by)); // esperar até que o elemento esteja clicável

        webElement.click();
    }

    public WebElement sendData (WebDriver webDriver, By by, String data, int waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitTimeInSeconds)); // criar uma espera explícita

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)); // esperar até que o elemento esteja presente na página
        WebElement webElement = webDriver.findElement(by); // encontrar o elemento

        webElement.sendKeys(data); // enviar os dados para o elemento

        return webElement;
    }
}
