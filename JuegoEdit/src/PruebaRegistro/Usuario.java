/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaRegistro;

/**
 *
 * @author Usuario
 */
public class Usuario {
    int idUsuario;
    String user;
    String nombre;
    String password;
    String edad;

    public Usuario() {
    }

    public Usuario(int idUsuario, String user, String nombre, String password, String edad) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.nombre = nombre;
        this.password = password;
        this.edad = edad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
}
