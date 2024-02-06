package br.mil.fab.pagl.dao.impl;

import br.mil.fab.pagl.dao.MotoristaDAO;
import br.mil.fab.pagl.model.Motorista;
import br.mil.fab.pagl.util.ConfigConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAOImpl implements MotoristaDAO {
    @Override
    public void create(Motorista obj) {
        try(Connection con = ConfigConnectionDB.connect();
            ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO motorista (nome_motorista, cnh, om, sessao) " +
                    "VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getNome_motorista());
            ps.setInt(2, obj.getCnh());
            ps.setString(3, obj.getOm());
            ps.setString(4, obj.getSessao());
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId_motorista(id);
                }
                rs.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Motorista obj) {
        if (obj == null || obj.getId_motorista() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE motorista SET nome_motorista=?, cnh=?, om=?, sessao=? WHERE id_motorista=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getNome_motorista());
            ps.setInt(2, obj.getCnh());
            ps.setString(3, obj.getOm());
            ps.setString(4, obj.getSessao());
            ps.setInt(5, obj.getId_motorista());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM motorista WHERE id_motorista=?";
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
    public List<Motorista> findAll() {
        String sql = "SELECT * FROM motorista";
        List<Motorista> motoristaList = new ArrayList<>();
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                motoristaList.add(new Motorista(
                        rs.getInt("id_motorista"),
                        rs.getString("nome_motorista"),
                        rs.getInt("cnh"),
                        rs.getString("om"),
                        rs.getString("sessao")
                ));
            }
            con.close();
            ps.close();
            rs.close();
            return motoristaList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
