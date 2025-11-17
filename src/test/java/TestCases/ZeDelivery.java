package TestCases;

import Page.AddressPage;
import Utils.DriverManagement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v140.autofill.model.Address;

public class ZeDelivery {
    private WebDriver driver;
    DriverManagement driverManagement;
    AddressPage addressPage;

    @Before // anotação para indicar que este metodo deve ser executado antes de cada teste
    public void setup () {
        driverManagement = new DriverManagement();
        driver = DriverManagement.getDriver("chrome");

        addressPage = new AddressPage(driver); // inicializar a página de endereço
    }

    @Test // anotação para indicar que este é um metodo de teste
    public void zeDeliveryTest() {
        driver.get("https://www.ze.delivery/"); // navegar até a página do ZeDelivery
        addressPage.address();
    }

    @After // anotação para indicar que este metodo deve ser executado após cada teste
    public void end () {
        // driver.quit();
    }
}
