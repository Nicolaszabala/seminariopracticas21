/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stock {
    private int ID_Stock;
    private String Nombre;
    private int Cantidad_Disponible;
    private double Precio;

    // Constructor
    public Stock(String Nombre, int Cantidad_Disponible, double Precio, String Categoria) {
        this.Nombre = Nombre;
        this.Cantidad_Disponible = Cantidad_Disponible;
        this.Precio = Precio;
    }

    // Getters y Setters
    public int getId() {
        return ID_Stock;
    }

    public void setId(int id) {
        this.ID_Stock = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad_Disponible;
    }

    public void setCantidad(int cantidad) {
        this.Cantidad_Disponible = cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        this.Precio = precio;
    }

    // Método para guardar el stock en la base de datos
    public boolean guardar() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO stock (Nombre, Cantidad_Disponible, Precio) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, this.Nombre);
                statement.setInt(2, this.Cantidad_Disponible);
                statement.setDouble(3, this.Precio);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        this.ID_Stock = generatedKeys.getInt(1);
                    }
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para obtener todos los stocks
    public static ResultSet obtenerTodos() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM stock";
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
