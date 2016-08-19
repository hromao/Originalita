package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Clientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class DaoCliente extends Clientes {

    private Connection conn = null;
    private PreparedStatement comando = null;
    Date data = null;
    Conexao conexao = new Conexao();

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cliente (cli_id, cli_cod, cli_nome, cli_endereco, cli_numero, "
                + "cli_comple, cli_bairro, cli_cidade, cli_uf, cli_cep, cli_cpf, cli_cnpj,"
                + " cli_email, cli_tel, cli_contato, cli_ativo, cli_dataCadastro)"
                + "VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getId_cli());
        comando.setString(2, this.getCod_cli());
        comando.setString(3, this.getNome_cli());
        comando.setString(4, this.getEndereco_cli());
        comando.setString(5, this.getNumero_cli());
        comando.setString(6, this.getComple_cli());
        comando.setString(7, this.getBairro_cli());
        comando.setString(8, this.getCidade_cli());
        comando.setString(9, this.getUf_cli());
        comando.setString(10, this.getCep_cli());
        comando.setString(11, this.getCpf_cli());
        comando.setString(12, this.getCnpj_cli());
        comando.setString(13, this.getEmail_cli());
        comando.setString(14, this.getTelefone_cli());
        comando.setString(15, this.getContato_cli());
        comando.setString(16, this.getAtivo_cli());
        data = new Date(getDataCadastro_cli().getTime());
        comando.setDate(17, data);
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE cliente SET "
                + "cli_nome=?,"
                + "cli_endereco=?,"
                + "cli_numero=?,"
                + "cli_comple=?,"
                + "cli_bairro=?,"
                + "cli_cidade=?,"
                + "cli_uf=?,"
                + "cli_cep=?,"
                + "cli_cpf=?,"
                + "cli_cnpj=?,"
                + "cli_email=?,"
                + "cli_tel=?,"
                + "cli_contato=?,"
                + "cli_ativo=? "
                + "WHERE cli_id=?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, this.getNome_cli());
        comando.setString(2, this.getEndereco_cli());
        comando.setString(3, this.getNumero_cli());
        comando.setString(4, this.getComple_cli());
        comando.setString(5, this.getBairro_cli());
        comando.setString(6, this.getCidade_cli());
        comando.setString(7, this.getUf_cli());
        comando.setString(8, this.getCep_cli());
        comando.setString(9, this.getCpf_cli());
        comando.setString(10, this.getCnpj_cli());
        comando.setString(11, this.getEmail_cli());
        comando.setString(12, this.getTelefone_cli());
        comando.setString(13, this.getContato_cli());
        comando.setString(14, this.getAtivo_cli());
        comando.setInt(15, this.getId_cli());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM cliente WHERE cli_id=?";

        try {
            this.conn = conexao.getConnection();
            comando = conn.prepareStatement(sql);
            comando.setInt(1, this.getId_cli());
            boolean apagou = comando.execute();
            comando.close();
            return apagou;
        } catch (SQLException ex) {
            throw ex;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            this.conn.close();
        }
    }

    @Override
    public int pegaUltimaID() throws SQLException, ClassNotFoundException {
        int ultimoId = 0;
        String sql = "SELECT MAX(cli_id) AS ultimoID FROM cliente";
        try {
            this.conn = conexao.getConnection();
            comando = conn.prepareStatement(sql);
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                ultimoId = rs.getInt("ultimoID");
            } else {
                ultimoId = 0;
            }
        } finally {
            comando.close();
            this.conn.close();
        }
        return ultimoId;
    }

    public ArrayList<DaoCliente> pesquisar(DaoCliente cliente) throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno = null;
        String sql = "SELECT * FROM cliente WHERE cli_nome LIKE ?";

        ArrayList<DaoCliente> listaClientes = new ArrayList<DaoCliente>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + cliente.getNome_cli() + "%");
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            clienteRetorno = new DaoCliente();
            clienteRetorno.setId_cli(rs.getInt("cli_id"));
            clienteRetorno.setCod_cli(rs.getString("cli_cod"));
            clienteRetorno.setNome_cli(rs.getString("cli_nome"));
            clienteRetorno.setEndereco_cli(rs.getString("cli_endereco"));
            clienteRetorno.setNumero_cli(rs.getString("cli_numero"));
            clienteRetorno.setComple_cli(rs.getString("cli_comple"));
            clienteRetorno.setBairro_cli(rs.getString("cli_bairro"));
            clienteRetorno.setCidade_cli(rs.getString("cli_cidade"));
            clienteRetorno.setUf_cli(rs.getString("cli_uf"));
            clienteRetorno.setCep_cli(rs.getString("cli_cep"));
            clienteRetorno.setContato_cli(rs.getString("cli_contato"));
            clienteRetorno.setTelefone_cli(rs.getString("cli_tel"));
            clienteRetorno.setAtivo_cli(rs.getString("cli_ativo"));

            listaClientes.add(clienteRetorno);
        }

        rs.close();
        comando.close();
        this.conn.close();

        return listaClientes;
    }

    public ArrayList<DaoCliente> pesquisarCod(DaoCliente cliente) throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno = null;
        String sql = "SELECT * FROM cliente WHERE cli_cod LIKE ?";

        ArrayList<DaoCliente> listaClientes = new ArrayList<DaoCliente>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + getCod_cli() + "%");
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            clienteRetorno = new DaoCliente();
            clienteRetorno.setId_cli(rs.getInt("cli_id"));
            clienteRetorno.setCod_cli(rs.getString("cli_cod"));
            clienteRetorno.setNome_cli(rs.getString("cli_nome"));
            clienteRetorno.setEndereco_cli(rs.getString("cli_endereco"));
            clienteRetorno.setNumero_cli(rs.getString("cli_numero"));
            clienteRetorno.setComple_cli(rs.getString("cli_comple"));
            clienteRetorno.setBairro_cli(rs.getString("cli_bairro"));
            clienteRetorno.setCidade_cli(rs.getString("cli_cidade"));
            clienteRetorno.setUf_cli(rs.getString("cli_uf"));
            clienteRetorno.setCep_cli(rs.getString("cli_cep"));
            clienteRetorno.setContato_cli(rs.getString("cli_contato"));
            clienteRetorno.setTelefone_cli(rs.getString("cli_tel"));
            clienteRetorno.setAtivo_cli(rs.getString("cli_ativo"));

            listaClientes.add(clienteRetorno);
        }

        rs.close();
        comando.close();
        this.conn.close();

        return listaClientes;
    }

    public void retornaDados() throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno = null;
        String sql = "SELECT * FROM cliente WHERE cli_id = ?";
        ArrayList<DaoCliente> listaClientes = new ArrayList<DaoCliente>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, getId_cli());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            clienteRetorno = new DaoCliente();
            setId_cli(rs.getInt("cli_id"));
            setCod_cli(rs.getString("cli_cod"));
            setNome_cli(rs.getString("cli_nome"));
            setEndereco_cli(rs.getString("cli_endereco"));
            setNumero_cli(rs.getString("cli_numero"));
            setComple_cli(rs.getString("cli_comple"));
            setBairro_cli(rs.getString("cli_bairro"));
            setCidade_cli(rs.getString("cli_cidade"));
            setUf_cli(rs.getString("cli_uf"));
            setCep_cli(rs.getString("cli_cep"));
            setCpf_cli(rs.getString("cli_cpf"));
            setCnpj_cli(rs.getString("cli_cnpj"));
            setEmail_cli(rs.getString("cli_email"));
            setContato_cli(rs.getString("cli_contato"));
            setTelefone_cli(rs.getString("cli_tel"));
            setAtivo_cli(rs.getString("cli_ativo"));
            setDataCadastro_cli(rs.getDate("cli_dataCadastro"));

        }

        comando.executeQuery();
        comando.close();
        this.conn.close();
    }

}
