package br.mil.fab.pagl.model.dao.impl;

import br.mil.fab.pagl.model.dao.AdministradorDAO;
import br.mil.fab.pagl.model.entities.Administrador;
import br.mil.fab.pagl.model.util.ConfigConnectionDB;

import java.sql.*;

public class AdministradorDAOImpl implements AdministradorDAO {
    @Override
    public void create(Administrador obj) {
        try(Connection con = ConfigConnectionDB.connect()
        ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO administrador (email, senha) " +
                    "VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getSenha());
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId_adm(id);
                }
                rs.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Administrador obj) {
        if (obj == null || obj.getId_adm() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE administrador SET email=?, senha=? WHERE id_adm=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getSenha());
            ps.setInt(3, obj.getId_adm());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean getAllAdmin (Administrador obj){
        String sql = "SELECT email, senha FROM administrador WHERE email = ? AND senha = ?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getSenha());
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
