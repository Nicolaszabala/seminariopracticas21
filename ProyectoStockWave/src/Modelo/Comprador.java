/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Usuario implements Transaccionable {
    private List<Stock> listaCompras;

    public Comprador(String nombre, String contraseña, String email) {
        super(nombre, contraseña, email);
        this.listaCompras = new ArrayList<>();
    }

    public void agregarCompra(Stock stock) {
        listaCompras.add(stock);
    }

    @Override
    public void autenticar() {
        System.out.println("Autenticación del Comprador: " + getNombre());
    }

    @Override
    public void realizarTransaccion(Stock stock) {
        agregarCompra(stock);
        System.out.println("Compra realizada por: " + getNombre());
    }
}

