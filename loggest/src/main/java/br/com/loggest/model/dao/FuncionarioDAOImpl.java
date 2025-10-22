package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Pessoa;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.*;

public class FuncionarioDAOImpl implements FuncionarioDAO {
    @Override
    public void create(Pessoa obj) {
        try(Connection con = ConfigConnectionDB.connect()
        ) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO administrador (email, senha) " +
                    "VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getEmails().get(0).getDescricao());
//            ps.setString(2, obj.getSenha().getSenhaNova());
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
    public void update(Pessoa obj) {
        if (obj == null || obj.getId() == null) {
            System.out.println("Não foi possivel atualizar o registro");
            return;
        }
        String sql = "UPDATE administrador SET email=?, senha=? WHERE id_adm=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getEmails().get(0).getDescricao());
//            ps.setString(2, obj.getSenha().getSenhaNova());
            ps.setLong(3, obj.getId());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean getLogin (String matricula, String senha){
        String sql = "SELECT f.MATRICULA, p.SENHA_ATUAL FROM TAB_FUNCIONARIOS f " +
                " INNER JOIN TAB_PESSOAS p on f.FK_PESSOAS = p.ID "+
                " WHERE f.MATRICULA = ? AND p.SENHA_ATUAL = ?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, matricula);
            ps.setString(2, senha);
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
