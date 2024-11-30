package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utility.BasePage;

import static org.junit.Assert.assertEquals;

public class RealizarPedidoPage extends BasePage {


    //Localizadores
    private String listaMen = "//a[@id='ui-id-5']";
    private String listaTop = "//a[@id='ui-id-17']";
    private String listaJacket = "(//a[@id='ui-id-19'])[1]";
    private String selectCuadro = "//a[@class='product photo product-item-photo']//img[@alt='Montana Wind Jacket']";
    private String scrollAllElement = "//span[@class='base']";
    private String selectTalla = "//*[@id=\"option-label-size-143-item-167\"]";
    private String selectColor = "//*[@id=\"option-label-color-93-item-58\"]";
    private String addCard2 = "//*[@id=\"product-addtocart-button\"]";
    private String hover = "body > div:nth-child(5) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(4) > ol:nth-child(1) > li:nth-child(2) > div:nth-child(1)";
    private String selectAddCard = "//li[2]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]";
    private String selectCarrito = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a";
    private String size = "#option-label-size-143-item-168";
    private String color = "#option-label-color-93-item-49";
    private String agregarCart = "#product-addtocart-button";
    private String ValidarTexto = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/text()[1]";
    private String ProcedCheckout = "//button[@data-role='proceed-to-checkout']";
    private String EmailAdress = "//div[@class='control _with-tooltip']//input[@id='customer-email']";
    private String FirstName = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input";
    private String LastName = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input";
    private String StreetAddress = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input";
    private String Ciudad = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input";

    private String CodigoPostal = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input";
    private String PhoneNumber = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input";
    private String checkboxShipping = "//input[@name='ko_unique_1']";
    private String BtnNext = "//button[@class='button action continue primary']";
    private String BtnPlaceOrder = "button[title='Place Order']";

    private String compareVentaText= "/html/body/div[2]/main/div[1]/h1/span";




    public RealizarPedidoPage(com.microsoft.playwright.Page page) {
        super(page); // Llama al constructor de BasePage
    }

    public boolean verificarErrorAgregarCarrito(String mensajeErrorEsperado) {
        String mensajeError = page.locator(".message-error").innerText();
        return mensajeError.contains(mensajeErrorEsperado);
    }
    public void navegarPaginaPrincipal(String url) {
        page.navigate(url); // Método de Playwright para navegar
        System.out.println("Navegando a la página: " + url);
    }

    public void buscarProducto(){
        page.hover(listaMen);
        page.hover(listaTop);
        page.click(listaJacket);
    }

    public void setSelectCuadro(){
        scrollToElement(selectCuadro, 5000);
    }

    public void setScrollAllElement(){
        scrollToElement(scrollAllElement, 5000);
    }

    public void setSize(){
        scrollToElement(size,5000);
        hacerClick(color,5000);
        hacerClick(agregarCart,5000);
    }

    public void setValidarTexto(){
        String selector = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a"; // Cambia este selector al correcto
        String textoEsperado = "shopping cart"; // Texto esperado
        validarTexto(selector, textoEsperado); // Llama al método de BasePage
    }
    public void agregarCartProduct(){
        hacerClick(selectCarrito,5000);
    }
    public void setProcedCheckout(){
        scrollToElement(ProcedCheckout,5000);
        page.click(ProcedCheckout);
    }

    public void llenarCampoCorreo() {
        String correoAleatorio = generarCorreoAleatorio(); // Genera el correo aleatorio
        page.fill(EmailAdress, correoAleatorio);
        System.out.println("Correo generado y llenado: " + correoAleatorio);
    }

    public void setFirstName(String nombre) {
        escribirTextoConScroll(FirstName,nombre, 5000);
    }
    public void setLastName(String apellido) {
        escribirTextoConScroll(LastName,apellido, 5000);
    }
    public void setStreetAddress(String address){
        escribirTextoConScroll(StreetAddress,address, 5000);
    }
    public void setCiudad(String ciudad){
        escribirTextoConScroll(Ciudad,ciudad, 5000);
    }
    public void setCodigoPostal(String codigoPostal) {
        escribirTextoConScroll(CodigoPostal,codigoPostal,5000);
    }
    public void setPhoneNumber(String phoneNumber) {
        escribirTextoConScroll(PhoneNumber,phoneNumber,5000);
    }
    public void setCheckboxShipping(){
        scrollToElement(checkboxShipping, 10000);
        page.click(checkboxShipping);
    }
    public void setBtnNext() {
        scrollOnly(550);
        scrollToElement(BtnNext, 10000);
        page.click(BtnNext);
    }


    public void setScrollOnly(){
        scrollOnly(300);
    }


















}
