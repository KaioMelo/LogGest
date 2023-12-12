package br.mil.fab.pagl.dao.impl;

import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.model.Veiculo;
import br.mil.fab.pagl.util.ConfigConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAOImpl implements VeiculoDAO {
    @Override
    public void create(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (rg_fab, placa, marca, modelo) VALUE (?,?,?,?)";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, veiculo.getRg_fab());
            ps.setString(2, veiculo.getPlaca());
            ps.setString(3, veiculo.getMarca());
            ps.setString(4, veiculo.getModelo());
            ps.executeUpdate();
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
        String sql = "UPDATE veiculo SET rg_fab=?, placao=?, marca=?, modelo=? WHERE id_veiculo=?";
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
    public void findById(Integer id) {
        String sql = "SELECT * FROM veiculo WHERE id_veiculo=?";
        Veiculo veiculo = null;
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                veiculo = new Veiculo(
                        rs.getInt("id_veiculo"),
                        rs.getString("rg_fab"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"));
            };
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
