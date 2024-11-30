package pages;

import com.microsoft.playwright.Page;

public class RegistroUsuarioPage {
    private Page page;

    public RegistroUsuarioPage(Page page) {
        this.page = page;
    }

    public boolean verificarErrorCorreo(String mensajeErrorEsperado) {
        String mensajeError = page.locator(".message-error").innerText();
        return mensajeError.contains(mensajeErrorEsperado);
    }

    public void completarFormulario(String firstName, String lastName, String email, String password) {
        page.fill("#firstname", firstName);
        page.fill("#lastname", lastName);
        page.fill("#email_address", email);
        page.fill("#password", password);
        page.fill("#password-confirmation", password);
        page.click("button[title='Create an Account']");
    }
}
