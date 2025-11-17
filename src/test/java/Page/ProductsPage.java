package Page;

import Utils.SeleniumActions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends SeleniumActions {
    public WebDriver driver;

    public static final By beerCategory = By.xpath("//*[@id=\"category-Cervejas\"]/div"); // seletor da categoria de cervejas
    public static final By productPriceField = By.xpath("//*[@id=\"product-total-price\"]"); // campo do preço do produto
    public static final By addToCartBtn = By.xpath("//*[@id=\"add-product\"]");
    public static final By cartItemFinalPrice = By.xpath("//*[@id=\"product-card-price\"]/div");
    public static final By closeCartIcon = By.xpath("//*[@id=\"sidebar-header-close-button\"]/svg"); // ta dando problema

    public static By accessNewBeersProduct(String position) {
        return By.xpath("//*[@id=\"__next\"]/div/div[5]/div/div[2]/div[3]/div/div/a" + "[" + position + "]"); // seletor dinâmico para acessar produtos pela posição na lista
    }

    public ProductsPage (WebDriver driver) {
        this.driver = driver; // inicializar o driver
    }

    public void chooseProductFromCatalog(String productPosition) {
        click(driver, beerCategory, 10); // clicar na categoria de cervejas

        By productBy = accessNewBeersProduct(productPosition); // obter o seletor do produto pela posição na lista

        click(driver, productBy, 10); // clicar no produto pela posição na lista

        String productPrice = getAttributeValue(driver, productPriceField, "innerText", 10); // obter o preço do produto
        System.out.println("Preço do produto selecionado: " + productPrice); // imprimir o preço do produto no console

        click(driver, addToCartBtn, 10); // clicar no botão de adicionar ao carrinho

        String cartItemPrice = getAttributeValue(driver, cartItemFinalPrice, "innerText", 10); // obter o preço final do item no carrinho

        validateCartProducts(productPrice, cartItemPrice); // validar os preços do produto e do carrinho

        click(driver, closeCartIcon, 10); // fechar o carrinho
    }

    public void validateCartProducts (String productPrice, String cartItemPrice) {
        if (productPrice.equals(cartItemPrice)) {
            System.out.println("O preço do produto no carrinho está correto: " + cartItemPrice);
        } else {
            System.out.println("O preço do produto no carrinho está incorreto. Esperado: " + productPrice + ", Encontrado: " + cartItemPrice);
            Assert.fail(); // falhar o teste se os preços não coincidirem
        }

    }
}



