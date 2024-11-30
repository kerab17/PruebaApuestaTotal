package stepDefinition;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import pages.AccesoWebPage;
import utility.BrowserDriver;

public class AccesoWebStep {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private AccesoWebPage accesoWebPage;

    public AccesoWebStep(){

        this.playwright = Playwright.create();
        this.browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Cambiar a true para modo headless
    }


    @Given("el navegador está abierto")
    public void el_navegador_está_abierto() {
        // Abrimos un nuevo contexto y página
        page = browser.newPage();
        System.out.println("Navegador inicializado correctamente.");
    }
    @When("navego a la página principal {string}")
    public void navego_a_la_página_principal(String url) {
        page.navigate(url);
        System.out.println("Navegando a la página principal: " + url);
        if (!page.isVisible("body")) {
            throw new IllegalStateException("El cuerpo de la página no es visible. La página no cargó correctamente.");
        }
    }
    @Then("el título de la página debe ser {string}")
    public void el_título_de_la_página_debe_ser(String tituloEsperado) {
        String tituloActual = page.title();
        if (!tituloActual.equals(tituloEsperado)) {
            throw new AssertionError("El título de la página no coincide. Se esperaba: " + tituloEsperado + ", pero se obtuvo: " + tituloActual);
        }
        System.out.println("Título validado correctamente: " + tituloActual);

    }
    @Then("el título de la página no debe ser {string}")
    public void validarTituloIncorrecto(String tituloIncorrecto) {
        AccesoWebPage accesoWebPage = new AccesoWebPage((WebDriver) page);
        boolean tituloValido = accesoWebPage.validarTituloIncorrecto(tituloIncorrecto);
        if (!tituloValido) {
            throw new AssertionError("El título de la página coincide con el título incorrecto: " + tituloIncorrecto);
        }
        System.out.println("Validación de título incorrecto exitosa. Título actual no coincide con: " + tituloIncorrecto);
    }

}

