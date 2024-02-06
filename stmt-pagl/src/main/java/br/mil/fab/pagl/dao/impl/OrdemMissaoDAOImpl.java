package br.mil.fab.pagl.dao.impl;

import br.mil.fab.pagl.dao.OrdemMissaoDAO;
import br.mil.fab.pagl.model.OrdemMissao;
import br.mil.fab.pagl.util.ConfigConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemMissaoDAOImpl implements OrdemMissaoDAO {
    @Override
    public void create(OrdemMissao obj) {
        try(Connection con = ConfigConnectionDB.connect();
            ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO missao (solicitante, contato, destino, servico, data) " +
                    "VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getSoliciante());
            ps.setString(2, obj.getContato());
            ps.setString(3, obj.getDestino());
            ps.setString(4, obj.getServico());
            ps.setDate(5, Date.valueOf(obj.getData()));
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
    public void update(OrdemMissao obj) {
        if (obj == null || obj.getId_ordem() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE missao SET solicitante=?, contato=?, destino=?, servico=?, data=? WHERE id_ordem=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getSoliciante());
            ps.setString(2, obj.getContato());
            ps.setString(3, obj.getDestino());
            ps.setString(4, obj.getServico());
            ps.setDate(5, Date.valueOf(obj.getData()));
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
    public List<OrdemMissao> findAll() {
        String sql = "SELECT * FROM missao";
        List<OrdemMissao> missaoList = new ArrayList<>();
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                missaoList.add(new OrdemMissao(
                        rs.getInt("id_ordem"),
                        rs.getString("soliciante"),
                        rs.getString("contato"),
                        rs.getString("destino"),
                        rs.getString("servico"),
                        rs.getDate("data").toLocalDate()
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
