package workshop02;

import java.util.Scanner;

@SuppressWarnings("PMD.UseUtilityClass")
public class DiningExperience {
/***
 * 
 * @param args Emily Cordero
 */
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double baseCost = 5.0;
        double totalCost = baseCost;
        boolean validOrder = true;

        System.out.println("¡Bienvenido al Sistema de Experiencias Gastronómicas!");

        // Definir el menú
        String[] menu = {"Hamburguesa", "Pizza", "Ensalada", "Sushi"};
        double[] prices = {10.0, 12.0, 8.0, 15.0};

        int[] quantities = new int[menu.length];

        // Mostrar el menú y permitir a los usuarios seleccionar comidas y cantidades
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + 1 + ". " + menu[i] + " - $" + prices[i]);

            int quantity;
            do {
                System.out.print("Cantidad de " + menu[i] + ": ");
                if (scanner.hasNextInt()) {
                    quantity = scanner.nextInt();
                    if (quantity >= 0 && quantity <= 100) {
                        quantities[i] = quantity;
                        break; // Salir del bucle si la entrada es válida
                    }
                }
                scanner.nextLine(); // Limpiar la entrada inválida
                System.out.println("Error: Debe ingresar un número entero positivo no mayor a 100.");
            } while (true);

            totalCost += prices[i] * quantities[i];
        }

        if (validOrder) {
            // Aplicar descuentos
            if (totalQuantity(quantities) > 5) {
                totalCost *= 0.9; // Aplicar un descuento del 10% si la cantidad total es mayor a 5.
            }
            if (totalQuantity(quantities) > 10) {
                totalCost *= 0.8; // Aplicar un descuento del 20% si la cantidad total es mayor a 10.
            }

            // Aplicar descuento especial
            if (totalCost > 100) {
                totalCost -= 25; // Descuento de $25 si el costo total supera los $100.
            } else if (totalCost > 50) {
                totalCost -= 10; // Descuento de $10 si el costo total supera los $50.
            }

            // Mostrar la orden para confirmación
            System.out.println("\nOrden Confirmada:");//NOPMD Manipulated later
            for (int i = 0; i < menu.length; i++) {
                if (quantities[i] > 0) {
                    System.out.println(menu[i] + " x" + quantities[i]);
                }
            }
            System.out.println("Costo Total: $" + totalCost);

            System.out.print("¿Desea confirmar la orden? (Sí/No): ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("Sí")) {
                System.out.println("Gracias por su pedido. El costo total es: $" + (int) totalCost);
            } else {
                System.out.println("Orden cancelada. No se realizará ningún cargo.");
                totalCost = -1;
            }
        } else {
            System.out.println("Error en la orden. Por favor, vuelva a intentarlo.");
        }

        scanner.close();
    }

    // Método para calcular la cantidad total de comidas pedidas
    private static int totalQuantity(int[] quantities) {
        int total = 0;
        for (int quantity : quantities) {
            total += quantity;
        }
        return total;
    }
}
