package Conexion;

import Datos.Eventos;
import Datos.Persona;
import Datos.Usuarios;
import Interfaces.ErrorIngreso;
import Interfaces.EventosFechas;
import Interfaces.registro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Controlador {
    private static Connection conexion = ConexionDB.getConnection();
    
    public static ArrayList<Persona> buscarPersonas(){
    ArrayList<Persona> personas = new ArrayList<>();
    String sql = "Select * FROM tbpersona1";
    
    try (
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {

                Persona persona = new Persona();

                persona.setNombre(rs.getString("Nombre"));
                persona.setApellido(rs.getString("Apellido"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setCelular(rs.getString("Celular"));
                persona.setDireccion(rs.getString("Direccion"));
                persona.setLocalidad(rs.getString("Localidad"));
                persona.setCumpleaños(rs.getString("Cumpleaños"));

                personas.add(persona);


    } 

    } catch (SQLException e) {
        System.out.println(e.getSQLState());
    } 

    return personas;	

    }
    public static void guardarPersonas(String nombre, String apellido, String telefono, String celular, String direccion, String localidad, String cumpleaños){
        String sql = "INSERT INTO tbpersona1 (Nombre, Apellido, Telefono, Celular, Direccion, Localidad, Cumpleaños) VALUES ('"+nombre+"', '"+apellido+"', '"+telefono+"', '"+celular+"', '"+direccion+"', '"+localidad+"', '"+cumpleaños+"')";
   
    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
    }
    
    
    //----------------
    public static ArrayList<Persona> buscarPersonas(String buscarPor, String busqueda){
    ArrayList<Persona> personas = new ArrayList<>();
    String sql = "Select * FROM tbpersona1 WHERE "+buscarPor+" = '"+busqueda+"'";
    
    try (
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {

                Persona persona = new Persona();

                persona.setNombre(rs.getString("Nombre"));
                persona.setId(rs.getInt("id"));
                persona.setApellido(rs.getString("Apellido"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setCelular(rs.getString("Celular"));
                persona.setDireccion(rs.getString("Direccion"));
                persona.setLocalidad(rs.getString("Localidad"));
                persona.setCumpleaños(rs.getString("Cumpleaños"));

                personas.add(persona);


    } 

    } catch (SQLException e) {
        System.out.println(e.getSQLState());
    } 

    return personas;	

    }
    
   public static void eliminarRegistros(String nombre, String apellido, String telefono, String celular, String direccion, String localidad, String cumpleaños){
    String sql = "DELETE FROM tbpersona1 WHERE Nombre = '"+nombre+"' AND Apellido = '"+apellido+"' AND Telefono = '"+telefono+"' AND Celular = '"+celular+"' AND Direccion = '"+direccion+"' AND Localidad = '"+localidad+"' AND Cumpleaños = '"+cumpleaños+"'";
    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
       }
   
    public static void actualizarRegistros(Persona personaSeleccionada, String queCambiar, String cambio){
        String sql = "UPDATE tbpersona1 SET "+queCambiar+" = '"+cambio+"' WHERE id = "+personaSeleccionada.getId()+"";

    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
    }
    
    
    //----------------------------
    
    public static void registrosNuevos (String usuario, String contraseña){
        String sql = "INSERT INTO tbregistro (Usuario, Contraseña) VALUES ('"+usuario+"', '"+contraseña+"')";
   
    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
    }
    
    
    //-.-.-.-.-.-.-
    
    
    public static boolean buscarRegistros(String usuario, String contraseña){
    Usuarios usu = new Usuarios();
    
    
    try {
        String sql = "Select * FROM tbregistro WHERE Usuario = '"+usuario+"'";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            usu.setUsuario(rs.getString("Usuario"));
            usu.setContraseña(rs.getString("Contraseña"));
        }
    } catch (SQLException e) {
        System.out.println(e.getSQLState());
        System.out.println(e.getErrorCode());
    }
    if (usuario.equals(usu.getUsuario()) && contraseña.equals(usu.getContraseña())){return true;}
    else { 
        ErrorIngreso error= new ErrorIngreso();
        error.setVisible(true);
        
        return false;}
    }
    
    //---------------------------------------------------
    
    public static ArrayList<Eventos> mostrarEventos(){
    ArrayList<Eventos> evento = new ArrayList<>();
    String sql = "Select * FROM tbevento";
    
    try (
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                
                Eventos event = new Eventos();
                
                event.setEvento(rs.getString("Evento"));
                event.setFecha(rs.getString("Fecha"));

                evento.add(event);
    } 

    } catch (SQLException e) {
        System.out.println(e.getSQLState());
    } 

    return evento;	

    }
    
    public static ArrayList<Eventos> mostrarEventos(String buscarPor, String busqueda){
    ArrayList<Eventos> evento = new ArrayList<>();
    String sql = "Select * FROM tbevento WHERE "+buscarPor+" = '"+busqueda+"'";
    
    try (
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                
                Eventos event = new Eventos();
                
                event.setEvento(rs.getString("Evento"));
                event.setFecha(rs.getString("Fecha"));

                evento.add(event);
    } 

    } catch (SQLException e) {
        System.out.println(e.getSQLState());
    } 

    return evento;	

    }
    
     
    public static void eliminarEventos(String evento, String fecha){
    String sql = "DELETE FROM tbpersona1 WHERE Evento = '"+evento+"' AND Fecha = '"+fecha+"'";
    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
       }
    
    public static void actualizarEventos(Eventos eventoSeleccionado, String queCambiar, String cambio){
        String sql = "UPDATE tbevento SET "+queCambiar+" = '"+cambio+"' WHERE id = "+eventoSeleccionado.getId()+"";

    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
    }
}

