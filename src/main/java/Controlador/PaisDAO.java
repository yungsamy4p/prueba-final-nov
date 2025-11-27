/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionDB;
import Modelo.Pais;
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

public class PaisDAO {


    public boolean insertar(Pais pais) {
        String sql = "INSERT INTO Pais (codigoPais, nombrePais, continentePais, poblacionPais, tipoGobierno) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getInstancia();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, pais.getCodigoPais());
            pst.setString(2, pais.getNombrePais());
            pst.setString(3, pais.getContinentePais());
            pst.setInt(4, pais.getPoblacionPais());
            pst.setBoolean(5, pais.isTipoGobierno());
            
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    public List<Pais> listar() {
        List<Pais> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pais";
        
        try (Connection con = ConexionDB.getInstancia();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
             
            while (rs.next()) {
                Pais p = new Pais();
                p.setCodigoPais(rs.getString("codigoPais"));
                p.setNombrePais(rs.getString("nombrePais"));
                p.setContinentePais(rs.getString("continentePais"));
                p.setPoblacionPais(rs.getInt("poblacionPais"));
                p.setTipoGobierno(rs.getBoolean("tipoGobierno"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public boolean modificar(Pais pais) {
        String sql = "UPDATE Pais SET nombrePais=?, continentePais=?, poblacionPais=?, tipoGobierno=? WHERE codigoPais=?";
        try (Connection con = ConexionDB.getInstancia();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, pais.getNombrePais());
            pst.setString(2, pais.getContinentePais());
            pst.setInt(3, pais.getPoblacionPais());
            pst.setBoolean(4, pais.isTipoGobierno());
            pst.setString(5, pais.getCodigoPais());
            
            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.err.println("Error al modificar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "DELETE FROM Pais WHERE codigoPais=?";
        try (Connection con = ConexionDB.getInstancia();
             PreparedStatement pst = con.prepareStatement(sql)) {
             
            pst.setString(1, codigo);
            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}