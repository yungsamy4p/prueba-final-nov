/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionDB;
import Modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santo Tomas
 */

public class CiudadDAO {
    
    public List<Ciudad> listarPorPais(String nombrePais) {
        List<Ciudad> lista = new ArrayList<>();
        String sql = "SELECT c.nombreCiudad, c.poblacionCiudad FROM Ciudad c " +
                     "INNER JOIN Pais p ON c.codigoPais = p.codigoPais " +
                     "WHERE p.nombrePais = ?";
                     
        try (Connection con = ConexionDB.getInstancia();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, nombrePais);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    
                    Ciudad c = new Ciudad(0, rs.getString("nombreCiudad"), rs.getInt("poblacionCiudad"), "");
                    lista.add(c);
                    
                }
            }
        } catch (SQLException e) {
            System.err.println("Error listar ciudades: " + e.getMessage());
        }
        return lista;
    }
}