/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionDB;
import Modelo.Idioma;
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

public class IdiomaDAO {

    public List<Idioma> listarPorPais(String nombrePais) {
        List<Idioma> lista = new ArrayList<>();
        String sql = "SELECT i.nombreIdioma, i.oficial FROM Idioma i " +
                     "INNER JOIN Pais p ON i.codigoPais = p.codigoPais " +
                     "WHERE p.nombrePais = ?";
                     
        try (Connection con = ConexionDB.getInstancia();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, nombrePais);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {

                    Idioma i = new Idioma(0, rs.getString("nombreIdioma"), rs.getBoolean("oficial"), "");
                    lista.add(i);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error listar idiomas: " + e.getMessage());
        }
        return lista;
    }
}