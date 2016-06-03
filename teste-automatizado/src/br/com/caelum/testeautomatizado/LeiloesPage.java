package br.com.caelum.testeautomatizado;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

	private WebDriver driver;

    public LeiloesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visita() {
        driver.get("http://localhost:8080/leiloes");
    }

    public NovoLeilaoPage novo() {
        driver.findElement(By.linkText("Novo Leilão")).click();
        return new NovoLeilaoPage(driver);
    }

    public boolean existe(String produto, double valor, String usuario,
            boolean usado) {

        return driver.getPageSource().contains(produto) && 
                driver.getPageSource().contains(String.valueOf(valor)) &&
                driver.getPageSource().contains(usado ? "Sim" : "Não");

    }
    
    public DetalhesDoLeilaoPage detalhes(int posicao) {
        List<WebElement> elementos = driver.findElements(By.linkText("exibir"));
        elementos.get(posicao - 1).click();

        return new DetalhesDoLeilaoPage(driver);
    }
}
