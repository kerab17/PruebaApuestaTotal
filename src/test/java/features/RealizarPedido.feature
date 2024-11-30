Feature: Realizar una compra en la tienda en línea
  Como usuario
  Quiero poder comprar un producto en la tienda
  Para recibir el producto en mi domicilio

  Scenario: Realizar una compra exitosa
    Given el usuario está en la página principal de la tienda "https://magento.softwaretestingboard.com/"
    When el usuario busca el producto
    And selecciona el producto de la lista
    And agrega el producto al carrito de compras
    Then completa los datos de envío y pago



  Scenario: Fallo al agregar un producto al carrito
    Given el usuario está en la página principal de la tienda "https://magento.softwaretestingboard.com/"
    When el usuario busca el producto
    And selecciona el producto de la lista
    And intenta agregar un producto al carrito
    Then debe aparecer el mensaje de error "No se pudo agregar el producto al carrito"