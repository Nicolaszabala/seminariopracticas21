/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;


import Modelo.Comprador;
import Modelo.Plataforma;
import Modelo.Stock;
import Modelo.Transaccionable;
import Modelo.Vendedor;

import java.util.Scanner;

public class Main {
    private static Plataforma plataforma = new Plataforma();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Registrar Comprador");
            System.out.println("2. Registrar Vendedor");
            System.out.println("3. Agregar Stock");
            System.out.println("4. Realizar Compra");
            System.out.println("5. Realizar Venta");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarUsuario("comprador");
                    break;
                case 2:
                    registrarUsuario("vendedor");
                    break;
                case 3:
                    agregarStock();
                    break;
                case 4:
                    realizarTransaccion("compra");
                    break;
                case 5:
                    realizarTransaccion("venta");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }

    private static void registrarUsuario(String tipo) {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        if (tipo.equals("comprador")) {
            Comprador comprador = new Comprador(nombre, contraseña, email);
            System.out.println("Comprador registrado: " + comprador.getNombre());
        } else if (tipo.equals("vendedor")) {
            Vendedor vendedor = new Vendedor(nombre, contraseña, email);
            System.out.println("Vendedor registrado: " + vendedor.getNombre());
        }
    }

    private static void agregarStock() {
        System.out.print("Ingrese nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        System.out.print("Ingrese descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese cantidad disponible: ");
        int cantidadDisponible = scanner.nextInt();
        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        Stock stock = new Stock(nombreProducto, descripcion, cantidadDisponible, precio);
        plataforma.agregarStock(stock);
        System.out.println("Stock agregado: " + stock.getNombreProducto());
    }

    private static void realizarTransaccion(String tipo) {
        System.out.print("Ingrese nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        Stock stock = plataforma.buscarStock(nombreProducto);

        if (stock == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();

        if (tipo.equals("compra")) {
            Comprador comprador = new Comprador(nombreUsuario, contraseña, "dummy@dummy.com");
            comprador.realizarTransaccion(stock);
        } else if (tipo.equals("venta")) {
            Vendedor vendedor = new Vendedor(nombreUsuario, contraseña, "dummy@dummy.com");
            vendedor.realizarTransaccion(stock);
        }
    }
}
