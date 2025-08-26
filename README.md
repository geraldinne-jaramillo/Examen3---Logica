**📝 Resumen del Código**
Este programa de Java simula un sistema de pedidos para un restaurante 🍔💻. Los usuarios pueden seleccionar platos de un menú predefinido, 
y el programa se encarga de calcular el total, aplicar descuentos y mostrar un resumen detallado del pedido.

**✨ Características Principales.**

**°** Manejo de Errores 🚫: Captura de errores si el plato no existe (PlatoNoEncontradoException) o si la entrada es inválida (InputMismatchException).

**°** Validación de Pedidos 🛒: Si el pedido está vacío, el programa lanza una IllegalStateException y te pide que añadas al menos un plato.

**°** Uso de Métodos: Cálculo Total 💰: Suma el costo de todos los platos del pedido y Descuentos Especiales 🎉: Aplica un descuento del 10% o 15% si el total supera un valor.

**°** Estadísticas del Pedido 📊: Muestra el precio promedio por plato y cuál fue el plato más pedido.

**🚀 Cómo Funciona**
**1.** El programa te saluda 👋 y muestra el menú del día.

**2.** Empiezas a ingresar los nombres de los platos que quieres.

**3.** Escribe "S" para terminar tu pedido.

**4.** Si te equivocas, el programa te avisa con un ❌ y te permite intentarlo de nuevo.

**5.** Al final, te muestra un resumen con el total, el descuento aplicado y el plato más popular.

**🧩 Componentes Clave.**
**°** HashMap<String, Double> menu: El cerebro 🧠 que guarda los precios de los platos.

**°** ArrayList<String> pedido: La lista 📜 donde se anotan tus platos.

**°** Manejo de excepciones y una excepción personalizada.

Gracias por ver. 😋



