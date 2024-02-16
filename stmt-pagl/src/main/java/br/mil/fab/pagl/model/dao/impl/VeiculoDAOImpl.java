package br.mil.fab.pagl.model.dao.impl;

import br.mil.fab.pagl.model.dao.VeiculoDAO;
import br.mil.fab.pagl.model.entities.Veiculo;
import br.mil.fab.pagl.model.util.ConfigConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAOImpl implements VeiculoDAO {
    @Override
    public void create(Veiculo veiculo) {
        try(Connection con = ConfigConnectionDB.connect();
            ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO veiculo (rg_fab, placa, marca, modelo) " +
                    "VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, veiculo.getRg_fab());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getModelo());
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    veiculo.setId_veiculo(id);
                }
                rs.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Veiculo veiculo) {
        if (veiculo == null || veiculo.getId_veiculo() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE veiculo SET rg_fab=?, placa=?, marca=?, modelo=? WHERE id_veiculo=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, veiculo.getRg_fab());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getModelo());
            ps.setInt(5, veiculo.getId_veiculo());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM veiculo WHERE id_veiculo=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Veiculo> findAll() {
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> veiculoList = new ArrayList<>();
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                veiculoList.add(new Veiculo(
                        rs.getInt("id_veiculo"),
                        rs.getString("rg_fab"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo")
                ));
            }
            con.close();
            ps.close();
            rs.close();
            return veiculoList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
