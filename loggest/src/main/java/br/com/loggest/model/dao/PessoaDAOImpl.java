package br.com.loggest.model.dao;

import br.com.loggest.model.entities.Pessoa;
import br.com.loggest.model.entities.PessoaFisica;
import br.com.loggest.model.util.ConfigConnectionDB;

import java.sql.*;

public class PessoaDAOImpl implements PessoaDAO {
    @Override
    public void criarPessoaFisica(PessoaFisica obj, Connection con) throws SQLException{
        PreparedStatement ps = con.prepareStatement("INSERT INTO TAB_PESSOAS (FK_SEXO, FK_TIPO_PESSOA, FK_TIPO_FUNCAO_PESSOA, SENHA_ATUAL, SENHA_ANTERIOR, OBSERVACAO) " +
                "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, obj.getTipoSexo().getId());
        ps.setLong(2, obj.getTipoPessoa().getId());
        ps.setLong(3, obj.getTipoFuncaoPessoa().getId());
        ps.setString(4, obj.getSenhaAtual());
        ps.setString(5, obj.getSenhaAnterior());
        ps.setString(6, obj.getObservacao());

        ps.executeUpdate();
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

    @Override
    public void update(Pessoa pessoa) {
        if (pessoa == null || pessoa.getId() == null) {
            System.out.println("Não foi possivel atualizar a Pessoa");
            return;
        }
        String sql = "UPDATE TAB_PESSOAS SET FK_SEXO=?, FK_TIPO_PESSOA=?,FK_TIPO_FUNCAO_PESSOA=?,SENHA_ATUAL=?, " +
                "SENHA_ANTERIOR=?, OBSERVACAO=? WHERE ID=?";
        try(Connection con = ConfigConnectionDB.connect();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setLong(1, pessoa.getTipoSexo().getId());
            ps.setLong(2, pessoa.getTipoPessoa().getId());
            ps.setLong(3, pessoa.getTipoFuncaoPessoa().getId());
            ps.setString(4, pessoa.getSenhaAtual());
            ps.setString(5, pessoa.getSenhaAnterior());
            ps.setString(6, pessoa.getObservacao());

            ps.setLong(7, pessoa.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
