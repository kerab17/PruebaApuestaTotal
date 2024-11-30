package utility;


import com.microsoft.playwright.*;

public class BrowserDriver {
        private static Playwright playwright;
        private static Browser browser;
        private static Page page;

        public static Page getDriver() {
            if (page == null) {
                // Inicializa Playwright y el navegador
                playwright = Playwright.create();
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                Browser.NewContextOptions options = new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080); // Configura el tamaño del viewport

                BrowserContext context = browser.newContext(options); // Crea un contexto con las opciones configuradas
                page = context.newPage();
            }
            return page;
        }








}


