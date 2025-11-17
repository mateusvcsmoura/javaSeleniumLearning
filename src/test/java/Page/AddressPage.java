package Page;

import Utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage extends SeleniumActions {
    private WebDriver driver;

    public static  final By adultPopUp = By.xpath("//*[@id=\"age-gate-button-yes\"]"); // seletor do pop-up de maioridade
    public static final By acceptCookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"); // seletor do botão de aceitar cookies
    public static final By addressInput = By.xpath("//*[@id=\"fake-address-search-input\"]"); // seletor do campo fake de endereço
    public static final By addressInput2 = By.xpath("//*[@id=\"address-search-input-address\"]"); // seletor do campo de endereço
    public static final By firstOption = By.xpath("//*[@id=\"auto-complete-address Rua Vergueiro, 3185 Vila Mariana, São Paulo - SP, Brasil\"]/div[2]/div[1]"); // seletor da primeira opção de endereço
    public static final By addressComplement = By.xpath("//*[@id=\"address-details-input-complement\"]"); // seletor do campo de complemento de endereço
    public static final By seeProductsBtn = By.xpath("//*[@id=\"address-details-button-continue\"]"); // seletor do botão de ver produtos

    public AddressPage (WebDriver driver) {
        this.driver = driver; // inicializar o driver
    }

    public void address () {
        click(driver, adultPopUp, 10); // clicar no pop-up de maioridade
        click(driver, acceptCookies, 10); // clicar no botão de aceitar cookies

        click(driver, addressInput, 10); // clicar no campo fake de endereço
        sendData(driver, addressInput2, "Rua Vergueiro, 3185", 10); // enviar o endereço real

        click(driver, firstOption, 10); // clicar na primeira opção de endereço
        sendData(driver, addressComplement, "Apartamento 32", 10); // enviar o complemento de endereço
        click(driver, seeProductsBtn, 10); // clicar no botão de ver produtos
    }
}


