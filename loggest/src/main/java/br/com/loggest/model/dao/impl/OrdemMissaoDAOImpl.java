package br.com.loggest.model.dao.impl;

import br.com.loggest.model.dao.OrdemMissaoDAO;
import br.com.loggest.model.entities.Viagens;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemMissaoDAOImpl implements OrdemMissaoDAO {
    @Override
    public void create(Viagens obj) {
        try(Connection con = ConfigConnectionDB.connect()
        ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO missao (solicitante, contato, servico, destino, data_missao) " +
                    "VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getSolicitante());
            ps.setString(2, obj.getContato());
            ps.setString(3, obj.getServico());
            ps.setString(4, obj.getDestino());
            ps.setDate(5, new java.sql.Date(obj.getData().getTime()));
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId_ordem(id);
                }
                rs.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Viagens obj) {
        String sql = "UPDATE missao SET solicitante=?, contato=?, servico=?, destino=?, data_missao=? WHERE id_ordem=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getSolicitante());
            ps.setString(2, obj.getContato());
            ps.setString(3, obj.getServico());
            ps.setString(4, obj.getDestino());
            ps.setDate(5, new java.sql.Date(obj.getData().getTime()));
            ps.setInt(6, obj.getId_ordem());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM missao WHERE id_ordem=?";
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
    public List<Viagens> findAll() {
        String sql = "SELECT * FROM missao";
        List<Viagens> missaoList = new ArrayList<>();
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                missaoList.add(new Viagens(
                        rs.getInt("id_ordem"),
                        rs.getString("solicitante"),
                        rs.getString("contato"),
                        rs.getString("servico"),
                        rs.getString("destino"),
                        rs.getDate("data_missao")
                ));
            }
            con.close();
            ps.close();
            rs.close();
            return missaoList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
