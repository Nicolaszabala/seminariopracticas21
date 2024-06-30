/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.LinkedList;

public class Plataforma {
    private LinkedList<Stock> listaStocks;

    public Plataforma() {
        listaStocks = new LinkedList<>();
    }

    public void agregarStock(Stock stock) {
        listaStocks.add(stock);
    }

    public Stock buscarStock(String nombreProducto) {
        for (Stock stock : listaStocks) {
            Object Nombre = null;
            if (stock.getNombre().equals(Nombre)) {
                return stock;
            }
        }
        return null;
    }
}