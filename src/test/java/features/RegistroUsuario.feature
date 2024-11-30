Feature: Registro de usuario en Magento
  Como nuevo usuario
  Quiero registrarme en el sitio
  Para poder acceder a mi cuenta

  Scenario: Registro exitoso
    Given el usuario navega a "https://magento.softwaretestingboard.com/customer/account/create/"
    When completa el formulario con un correo y contraseña aleatorios
    Then debería redirigir a la página "My Account"

  Scenario: Fallo en el registro por correo inválido
    Given el usuario navega a "https://magento.softwaretestingboard.com/customer/account/create/"
    When completa el formulario con un correo inválido "usuario-invalido" y contraseña válida "Password123"
    Then debería mostrar el mensaje de error "Por favor, introduce una dirección de correo válida"