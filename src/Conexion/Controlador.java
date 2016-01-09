package Conexion;

import Datos.Persona;
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
                persona.setCumpleaños(rs.getDate("Cumpleaños"));

                personas.add(persona);


    } 

    } catch (SQLException e) {
        System.out.println(e.getSQLState());
    } 

    return personas;	

    }
    public static void guardarPersonas(String nombre, String apellido, String telefono, String celular, String direccion, String localidad, String cumpleaños){
        String sql = "INSERT INTO tbpersona1 (Nombre, Apellido, Telefono, Celular, Direccion, Localidad, Cumpleaños) VALUES ('"+nombre+"', '"+apellido+"', '"+telefono+"', '"+celular+"', '"+direccion+"', '"+localidad+"', '"+cumpleaños+"')";
        //String sql = "INSERT INTO tbpersona1 (Nombre, Apellido, Telefono, Celular, Direccion, Localidad, Cumpleaños)"+" "
        //        + "VALUES ('"+nombre+"','"+apellido+"','"+telefono+"','"+celular+"','"+direccion+"','"+localidad+"',"+cumpleaños+")";
        
    
    try {
        Statement stmt = (Statement) conexion.createStatement();
        stmt.execute(sql);
        } catch (SQLException e) {System.out.println(e.getErrorCode());
        System.out.println(e.getSQLState());
    } 
    }
    }
