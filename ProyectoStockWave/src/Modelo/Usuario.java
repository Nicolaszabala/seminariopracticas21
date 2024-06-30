/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public abstract class Usuario {
    private String nombre;
    private String contraseña;
    private String email;
    private String tipo;
    
    public Usuario(String nombre, String contraseña, String email, String tipo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        setEmail(email);
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }
    
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public void setEmail(String email) throws IllegalArgumentException {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
        this.email = email;
    }
    
    public abstract void autenticar();
}
