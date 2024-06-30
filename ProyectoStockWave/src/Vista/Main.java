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
import Modelo.DatabaseConnection;  // Importa la clase DatabaseConnection

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
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
            System.out.println("6. Ver Usuarios");
            System.out.println("7. Ver Stocks");
            System.out.println("8. Salir");
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
                    verUsuarios();
                    break;
                case 7:
                    verStock();
                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
            }
              if (opcion != 8) {
                System.out.println("\n--- Presione Enter para continuar ---");
                scanner.nextLine();
            }
        } while (opcion != 8);
    }

    private static void registrarUsuario(String userType) {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Ingrese tipo: ");
        String tipo = scanner.nextLine();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO usuario (Nombre, Correo_Electronico, Contrasena, tipo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setString(2, email);
                statement.setString(3, contraseña);
                statement.setString(4, tipo);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Usuario registrado con éxito.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el usuario en la base de datos");
        }
    }

    private static void verUsuarios() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM usuario";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                System.out.println("Lista de usuarios:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_Usuario");
                    String nombre = resultSet.getString("Nombre");
                    String email = resultSet.getString("Correo_Electronico");
                    String tipo = resultSet.getString("tipo");
                    System.out.println("usuario: " + id + ", Nombre: " + nombre + ", Correo_Electronico: " + email + ", Tipo: " + tipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar los usuarios de la base de datos");
        }
    }
  private static void verStock() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM stock";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                System.out.println("Lista de stock:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID_Stock");
                    String nombre = resultSet.getString("Nombre");
                    int cantidad = resultSet.getInt("Cantidad_Disponible");
                    double precio = resultSet.getDouble("Precio");
                    String categoria = resultSet.getString("Categoria");
                    System.out.println("ID_Stock: " + id + ", Nombre: " + nombre + ", Cantidad_Disponible: " + cantidad + ", Precio: " + precio + ", Categoria: " + categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar el stock de la base de datos");
        }
    }

    private static void agregarStock() {
        try {
            System.out.print("Ingrese nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Ingrese cantidad disponible: ");
            int cantidadDisponible = scanner.nextInt();
            System.out.print("Ingrese precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Ingrese categoría: ");
            String categoria = scanner.nextLine();

            Stock stock = new Stock(nombreProducto, cantidadDisponible, precio, categoria);
            if (stock.guardar()) {
                System.out.println("Stock agregado con éxito.");
            } else {
                System.out.println("Error al agregar el stock.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }    private static void realizarTransaccion(String tipo) {
       
        System.out.print("Ingrese nombre del producto: ");
        String nombreProducto = scanner.nextLine();
        Stock stock = plataforma.buscarStock(nombreProducto);

        if (stock == null) {
            System.out.println("Producto no encontrado");
            return;
    }
}
}