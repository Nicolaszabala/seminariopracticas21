/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario implements Transaccionable {
    private List<Stock> listaVentas;

    public Vendedor(String nombre, String contraseña, String email) {
        super(nombre, contraseña, email);
        this.listaVentas = new ArrayList<>();
    }

    public void agregarVenta(Stock stock) {
        listaVentas.add(stock);
    }

    @Override
    public void autenticar() {
        System.out.println("Autenticación del Vendedor: " + getNombre());
    }

    @Override
    public void realizarTransaccion(Stock stock) {
        agregarVenta(stock);
        System.out.println("Venta realizada por: " + getNombre());
    }
}
