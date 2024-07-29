/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaRegistro;

import Conexion.Conexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registrito {
    Conexion cx = new Conexion("JuegoFinal");

    public Registrito() {
    }
    public boolean create(Usuario user){
        try {
            String sqlInsert= "INSERT INTO usuarios (id, nombre, nombre_jugador, contraseña, edad) VALUES (null,?,?,?,?)";
            PreparedStatement ps =cx.conectar().prepareStatement(sqlInsert);
            ps.setString(1,user.getNombre());
            ps.setString(2, user.getUser());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEdad());
            ps.execute();
            ps.close();
            ps=null;
            cx.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Registrito.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<Usuario> logro1(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            PreparedStatement ps=cx.conectar().prepareStatement("SELECT nombre, nombre_jugador FROM usuarios WHERE nivel = '1'");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Usuario u= new Usuario();
                u.setNombre(rs.getString("nombre"));
                u.setUser(rs.getString("nombre_jugador"));
                lista.add(u);
            }
            ps.close();
            ps=null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Registrito.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public ArrayList<Usuario> logro2(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            PreparedStatement ps=cx.conectar().prepareStatement("SELECT nombre, nombre_jugador FROM usuarios WHERE nivel = '2'");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Usuario u= new Usuario();
                u.setNombre(rs.getString("nombre"));
                u.setUser(rs.getString("nombre_jugador"));
                lista.add(u);
            }
            ps.close();
            ps=null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Registrito.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public ArrayList<Usuario> logro3(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try {
            PreparedStatement ps=cx.conectar().prepareStatement("SELECT nombre, nombre_jugador FROM usuarios WHERE nivel = '3'");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Usuario u= new Usuario();
                u.setNombre(rs.getString("nombre"));
                u.setUser(rs.getString("nombre_jugador"));
                lista.add(u);
            }
            ps.close();
            ps=null;
            cx.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Registrito.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
}
