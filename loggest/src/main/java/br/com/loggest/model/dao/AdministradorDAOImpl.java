package br.com.loggest.model.dao;

import br.com.loggest.model.dao.AdministradorDAO;
import br.com.loggest.model.entities.Administrador;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.*;

public class AdministradorDAOImpl implements AdministradorDAO {
    @Override
    public void create(Administrador obj) {
        try(Connection con = ConfigConnectionDB.connect()
        ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO administrador (email, senha) " +
                    "VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getEmail().getDescricao());
            ps.setString(2, obj.getSenhas().getSenhaNova());
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
    public void update(Administrador obj) {
        if (obj == null || obj.getId() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE administrador SET email=?, senha=? WHERE id_adm=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getEmail().getDescricao());
            ps.setString(2, obj.getSenhas().getSenhaNova());
            ps.setLong(3, obj.getId());
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
            ps.setString(1, obj.getEmail().getDescricao());
            ps.setString(2, obj.getSenhas().getSenhaNova());
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
