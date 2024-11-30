Feature: Validar acceso a la página web

  Como usuario
  Quiero asegurarme de que puedo acceder correctamente a la página principal de la web
  Para verificar su disponibilidad y correcto funcionamiento




  Scenario: Validar que la página principal carga correctamente
    Given el navegador está abierto
    When navego a la página principal "https://magento.softwaretestingboard.com/"
    Then el título de la página debe ser "Home Page"



  Scenario: Fallo al cargar la página principal
    Given el navegador está abierto
    When navego a la página principal "https://magento.softwaretestingboard.com/"
    Then el título de la página no debe ser "Página Incorrecta"