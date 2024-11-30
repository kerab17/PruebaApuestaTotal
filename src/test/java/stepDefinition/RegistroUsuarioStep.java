package stepDefinition;

import io.cucumber.java.en.*;


import com.microsoft.playwright.*;

import org.junit.Assert;
import pages.RegistroUsuarioPage;


import java.util.Random;

public class RegistroUsuarioStep {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private RegistroUsuarioPage registroUsuarioPage;

    @Given("el usuario navega a {string}")
    public void elUsuarioNavegaA(String url) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate(url);
        registroUsuarioPage = new RegistroUsuarioPage(page);
    }

    @When("completa el formulario con un correo y contraseña aleatorios")
    public void completaElFormulario() {
        String email = "user" + new Random().nextInt(10000) + "@gmail.com";
        String password = "Password" + new Random().nextInt(10000);
        registroUsuarioPage.completarFormulario("Nombre", "Apellido", email, password);
    }

    @Then("debería redirigir a la página {string}")
    public void deberiaRedirigirALaPagina(String urlEsperada) {
        String headerText = page.locator("h1.page-title").innerText();
        Assert.assertEquals("El encabezado no coincide con el esperado.", urlEsperada, headerText);
    }

    @Then("debería mostrar el mensaje de error {string}")
    public void verificarErrorCorreo(String mensajeErrorEsperado) {
        RegistroUsuarioPage registroUsuarioPage = new RegistroUsuarioPage(page);
        boolean errorVisible = registroUsuarioPage.verificarErrorCorreo(mensajeErrorEsperado);
        Assert.assertTrue("El mensaje de error no coincide.", errorVisible);
    }

}
