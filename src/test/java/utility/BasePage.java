package utility;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.util.UUID;
import static org.junit.Assert.assertEquals;
public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void hacerClick(String selector, int timeoutInMillis) {
        page.locator(selector).waitFor(new Locator.WaitForOptions().setTimeout(timeoutInMillis));
        if (page.isVisible(selector)) {
            System.out.println("Haciendo clic en el elemento: " + selector);
            page.click(selector);
        } else {
            throw new IllegalStateException("El elemento con el selector '" + selector + "' no es visible.");
        }
    }

    public void scrollToElement(String selector, int timeoutInMillis) {
        // Espera explícita: valida que el elemento sea visible dentro del tiempo límite
        page.locator(selector).waitFor(new Locator.WaitForOptions().setTimeout(timeoutInMillis));

        // Realiza el scroll hasta el elemento
        page.locator(selector).scrollIntoViewIfNeeded();
        page.locator(selector).click();
        System.out.println("Haciendo scroll al elemento con selector: " + selector);
    }
    public void scrollOnly(int pixels) {
        // Realiza el scroll hacia abajo una cantidad específica de píxeles
        page.evaluate("window.scrollBy(0, " + pixels + ");");
        System.out.println("Realizando scroll hacia abajo: " + pixels + " píxeles.");
    }

    public void validarTexto(String selector, String textoEsperado) {
        // Detecta si es un XPath y agrega el prefijo necesario
        String finalSelector = selector.startsWith("/") ? "xpath=" + selector : selector;

        // Espera a que el elemento sea visible
        page.locator(finalSelector).waitFor(new Locator.WaitForOptions().setTimeout(5000));

        // Obtiene el texto actual del elemento
        String textoActual = page.locator(finalSelector).textContent().trim();

        // Valida que el texto sea el esperado
        assertEquals("El texto no coincide.", textoEsperado, textoActual);
        System.out.println("Texto validado con éxito: " + textoActual);
    }

    // Método para generar un correo aleatorio con el patrón @gmail.com
    public static String generarCorreoAleatorio() {
        String nombreUnico = UUID.randomUUID().toString().substring(0, 8); // Genera parte única
        return nombreUnico + "@gmail.com";
    }
    public static String generarContrasenaAleatoria() {
        return UUID.randomUUID().toString().substring(0, 12); // Contraseña de 12 caracteres aleatorios
    }



    public void escribirTextoConScroll(String selector, String texto, int timeoutInMillis) {
        // Verifica si es un XPath y agrega el prefijo necesario
        String finalSelector = selector.startsWith("/") ? "xpath=" + selector : selector;

        // Espera a que el elemento sea visible
        page.locator(finalSelector).waitFor(new Locator.WaitForOptions().setTimeout(timeoutInMillis));

        // Hace scroll al campo para asegurarse de que esté visible en el viewport
        page.locator(finalSelector).scrollIntoViewIfNeeded();

        // Ingresa el texto en el campo
        page.fill(finalSelector, texto);
        System.out.println("Texto ingresado en el campo con selector: " + finalSelector + " -> " + texto);
    }





}
