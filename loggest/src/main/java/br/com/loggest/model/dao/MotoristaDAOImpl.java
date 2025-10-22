package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Motorista;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAOImpl implements MotoristaDAO {
    @Override
    public void create(Motorista obj) {
        try(Connection con = ConfigConnectionDB.connect()
        ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO TAB_MOTORISTAS (CNH, VENCIMENTO_CNH, FK_CAD_PESSOA) " +
                    "VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, obj.getCnh());
            ps.setDate(2, (Date) obj.getVencimentoCnh().getTime());
            ps.setObject(3, obj.getPessoa());
//            ps.setObject(4, obj.get);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    Long id = rs.getLong(1);
                    obj.setId(id);
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
        if (obj == null || obj.getId() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE motorista SET CNH=?, VENCIMENTO_CNH=?, FK_CAD_PESSOA=? WHERE id_motorista=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, obj.getCnh());
            ps.setDate(2, (Date) obj.getVencimentoCnh().getTime());
            ps.setObject(3, obj.getPessoa());
//            ps.setObject(4, obj.getDocumentosAnexos());
            ps.setLong(5, obj.getId());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM motorista WHERE id_motorista=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
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
                        rs.getInt("id"),
                        rs.getInt("cnh"),
                        rs.getDate("vencimentoCnh"),
                        rs.getObject("pessoa"),
                        rs.getObject("documentosAnexos")
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
