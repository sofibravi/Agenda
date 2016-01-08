package Conexion;

import Datos.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                persona.setTelefono(rs.getInt("Telefono"));
                persona.setCelular(rs.getInt("Celular"));
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
    }
