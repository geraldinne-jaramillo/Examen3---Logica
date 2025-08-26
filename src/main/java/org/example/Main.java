package org.example;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static class PlatoNoEncontradoException extends Exception {
        public PlatoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {

        HashMap<String, Double> menu = new HashMap<>();
        menu.put("Hamburguesa", 100000.0);
        menu.put("Pizza", 25000.0);
        menu.put("Casuela de Mariscos", 40000.0);
        menu.put("Pasta Carbonara", 32000.0);
        menu.put("Sushi (8 pzas)", 22000.0);
        menu.put("Punta de Anca", 45000.0);
        menu.put("Gaseosa", 5000.0);

        System.out.println("\uD83D\uDC4B¡Bienvenido a nuestro Restaurante Digital!\uD83D\uDC4B");
        System.out.println("\n➖➖➖ Menú del Día ➖➖➖");
        for (String plato : menu.keySet()) {
            System.out.println(plato + ": $" + menu.get(plato));
        }

        System.out.println("\nIngresa los platos que deseas ordenar. Escribe 'S' para terminar.");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> pedido = new ArrayList<>();
        String nombrePlato;

        while (true) {

            try {
                System.out.print("Plato: ");
                nombrePlato = scanner.nextLine();

                if (nombrePlato.matches("\\d+")) {
                    throw new InputMismatchException("Se esperaba un nombre de plato, no un número.");
                }

                if (nombrePlato.equalsIgnoreCase("S")) {
                    break;
                }

                if (!menu.containsKey(nombrePlato)) {
                    throw new PlatoNoEncontradoException("El plato " + nombrePlato + "no existe en el menú.");
                }

                pedido.add(nombrePlato);
                System.out.println("✅" + nombrePlato + "' añadido al pedido.");

            } catch (PlatoNoEncontradoException e) {
                System.out.println("❌ ERROR: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("❌ ERROR: " + e.getMessage());
            }
        }

        try {
            // Mostrar el pedido final
            System.out.println("\n--- Resumen del Pedido ---");
            if (pedido.isEmpty()) {
                throw new IllegalStateException("Tu pedido está vacío. Por favor, ingresa al menos un producto.");
            } else {
                // El resto del código para procesar el pedido si no está vacío
                System.out.println("Platos ordenados:");
                pedido.forEach(plato -> System.out.println("- " + plato));
                double total = calcularTotal(pedido, menu);
                System.out.println("\nResumen de precios:");
                System.out.println("Total de la orden: $" + total);

                double promedio = pedido.stream()
                        .mapToDouble(menu::get)
                        .average()
                        .orElse(0.0);
                System.out.printf("Precio promedio por plato: $%.2f\n", promedio);

                // Aplicar descuento
                aplicarDescuento(total);

                // Plato más pedido
                System.out.println("\n--- Plato más pedido ---");
                Map<String, Long> conteoPlatos = pedido.stream()
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

                conteoPlatos.entrySet().stream()
                        .max(Comparator.comparing(Map.Entry::getValue))
                        .ifPresent(entry ->
                                System.out.println("Plato más pedido: " + entry.getKey() + " (" + entry.getValue() + " veces)")
                        );
            }
        } catch (IllegalStateException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }

    public static double calcularTotal(ArrayList<String> orden, HashMap<String, Double> menu) {
        return orden.stream()
                .mapToDouble(menu::get)
                .sum();
    }

    public static void aplicarDescuento(double total) {
        if (total > 100000.0) {
            double descuento = total * 0.15;
            System.out.println("\uD83E\uDD73¡Felicitaciones! Se aplicó un 15% de descuento.\uD83E\uDD73");
            System.out.printf("Total con descuento: $%.2f\n", total - descuento);
        } else if (total > 50000.0) {
            double descuento = total * 0.10;
            System.out.println("\uD83E\uDD73¡Felicitaciones! Se aplicó un 10% de descuento.\uD83E\uDD73");
            System.out.printf("Total con descuento: $%.2f\n", total - descuento);
        } else {
            System.out.println("No se aplicó ningún descuento. El total es menor a $50.000.");
        }
    }

}
