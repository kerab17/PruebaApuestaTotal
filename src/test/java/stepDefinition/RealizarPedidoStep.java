package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RealizarPedidoPage;
import utility.BrowserDriver;
import com.microsoft.playwright.Page;

public class RealizarPedidoStep {

    private RealizarPedidoPage realizarPedidoPage;
    private Page page;

    public RealizarPedidoStep() {

        this.realizarPedidoPage = new RealizarPedidoPage(BrowserDriver.getDriver()); // Inicializa la página con el driver
    }

    @Given("el usuario está en la página principal de la tienda {string}")
    public void el_usuario_está_en_la_página_principal_de_la_tienda(String url) {

        realizarPedidoPage.navegarPaginaPrincipal(url);

    }
    @When("el usuario busca el producto")
    public void el_usuario_busca_el_producto() {
        realizarPedidoPage.buscarProducto();

    }
    @And("selecciona el producto de la lista")
    public void selecciona_el_producto_de_la_lista() {
        realizarPedidoPage.setSelectCuadro();



    }
    @And("agrega el producto al carrito de compras")
    public void agrega_el_producto_al_carrito_de_compras() {
        realizarPedidoPage.setScrollAllElement();
        realizarPedidoPage.setSize();
        realizarPedidoPage.setValidarTexto();
        realizarPedidoPage.agregarCartProduct();
        realizarPedidoPage.setProcedCheckout();
    }

    @Then("completa los datos de envío y pago")
    public void completa_los_datos_de_envío_y_pago() {
        realizarPedidoPage.llenarCampoCorreo();
        realizarPedidoPage.setScrollOnly();
        realizarPedidoPage.setFirstName("Kevin");
        realizarPedidoPage.setLastName("Ricalde");
        realizarPedidoPage.setScrollOnly();
        realizarPedidoPage.setStreetAddress("Av. San martin");
        realizarPedidoPage.setCiudad("Lima");
        realizarPedidoPage.setCodigoPostal("12345");
        realizarPedidoPage.setPhoneNumber("923432123");
        realizarPedidoPage.setBtnNext();



    }

    @Then("debe aparecer el mensaje de error {string}")
    public void verificarErrorAgregarCarrito(String mensajeErrorEsperado) {
        RealizarPedidoPage realizarPedidoPage = new RealizarPedidoPage(page);
        boolean errorVisible = realizarPedidoPage.verificarErrorAgregarCarrito(mensajeErrorEsperado);
        Assert.assertTrue("El mensaje de error no coincide.", errorVisible);
    }
}
