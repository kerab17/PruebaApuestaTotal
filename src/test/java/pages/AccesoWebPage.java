package pages;

import com.microsoft.playwright.Page;
import org.openqa.selenium.WebDriver;

public class AccesoWebPage {
    private Page page;
    WebDriver driver;

    public AccesoWebPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean validarTituloIncorrecto(String tituloIncorrecto) {
        String tituloActual = page.title();
        return !tituloActual.equals(tituloIncorrecto);
    }
}
