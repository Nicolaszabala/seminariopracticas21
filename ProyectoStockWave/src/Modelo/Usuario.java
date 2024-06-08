/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public abstract class Usuario {
    private String nombre;
    private String contraseña;
    private String email;

    public Usuario(String nombre, String contraseña, String email) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        setEmail(email);
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

    public void setEmail(String email) throws IllegalArgumentException {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
        this.email = email;
    }

    public abstract void autenticar();
}
