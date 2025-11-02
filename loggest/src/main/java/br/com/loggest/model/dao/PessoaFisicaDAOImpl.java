package br.com.loggest.model.dao;

import br.com.loggest.model.entities.PessoaFisica;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.*;

public class PessoaFisicaDAOImpl implements PessoaFisicaDAO{

    @Override
    public void create(PessoaFisica obj, Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO TAB_PESSOAS_FISICAS (ID, NOME, DATA_NASCIMENTO, CPF, RG) " +
                "VALUES (?, ?, ?, ?, ?)");

        ps.setLong(1, obj.getId());
        ps.setString(2, obj.getNome());
        ps.setDate(3, (Date) obj.getDataNascimento().getTime());
        ps.setString(4, obj.getCpf());
        ps.setInt(5, obj.getRg());

        ps.executeUpdate();

    }

    @Override
    public void update(PessoaFisica obj) {
        if (obj == null || obj.getId() == null) {
            System.out.println("Não foi possivel atualizar a Pessoa");
            return;
        }
        String sql = "UPDATE TAB_PESSOAS SET NOME=?, DATA_NASCIMENTO=?,CPF=?,RG=? WHERE ID=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, obj.getNome());
            ps.setDate(2, (Date) obj.getDataNascimento().getTime());
            ps.setString(3, obj.getCpf());
            ps.setInt(4, obj.getRg());
            ps.setLong(5, obj.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
