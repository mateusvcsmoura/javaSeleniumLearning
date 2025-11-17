package TestCases;

import Page.AddressPage;
import Page.ProductsPage;
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
    ProductsPage productsPage;

    @Before // anotação para indicar que este metodo deve ser executado antes de cada teste
    public void setup () {
        driverManagement = new DriverManagement();
        driver = DriverManagement.getDriver("chrome");

        addressPage = new AddressPage(driver); // inicializar a página de endereço
        productsPage = new ProductsPage(driver); // inicializar a página de produtos
    }

    @Test // anotação para indicar que este é um metodo de teste
    public void zeDeliveryTest() {
        driver.get("https://www.ze.delivery/"); // navegar até a página do ZeDelivery

        addressPage.address();

        try { // esperar 3 segundos para a página de produtos carregar (o certo era usar uma espera explícita pelo metodo click, mas nao esta funcionando)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productsPage.chooseProductFromCatalog("2");
    }

    @After // anotação para indicar que este metodo deve ser executado após cada teste
    public void end () {
        // driver.quit();
    }
}
