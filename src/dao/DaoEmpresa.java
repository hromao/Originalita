package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Configuracoes;

/**
 *
 * @author Henrique
 */
public class DaoEmpresa extends Configuracoes {

    private Connection conn = null;
    private PreparedStatement comando = null;
    Date dataVenda = null, dataEntrega = null;
    Conexao conexao = new Conexao();

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE empresa SET "
                + "emp_razaoSocial = ?,"
                + "emp_nome=?,"
                + "emp_endereco=?,"
                + "emp_numero=?,"
                + "emp_bairro=?,"
                + "emp_cidade=?,"
                + "emp_uf=?,"
                + "emp_cnpj=?,"
                + "emp_agencia=?,"
                + "emp_digAgencia=?,"
                + "emp_conta=?,"
                + "emp_digConta=?,"
                + "emp_mora=?,"
                + "emp_mensagem=?,"
                + "emp_cep=?  "
                + "WHERE emp_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, this.getEmp_razao());
        comando.setString(2, this.getEmp_nome());
        comando.setString(3, this.getEmp_endereco());
        comando.setString(4, this.getEmp_num());
        comando.setString(5, this.getEmp_bairro());
        comando.setString(6, this.getEmp_cidade());
        comando.setString(7, this.getEmp_uf());
        comando.setString(8, this.getEmp_cnpj());
        comando.setString(9, this.getEmp_agencia());
        comando.setString(10, this.getEmp_digAgencia());
        comando.setString(11, this.getEmp_conta());
        comando.setString(12, this.getEmp_digConta());
        comando.setDouble(13, this.getEmp_mora());
        comando.setString(14, this.getEmp_mensagem());
        comando.setString(15, this.getEmp_cep());
        comando.setInt(16, this.getEmp_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public int pegaUltimaID() throws SQLException, ClassNotFoundException {
        int ultimoId = 0;
        String sql = "INSERT INTO empresa (emp_id) VALUE (null)";
        String sqlSelect = "SELECT MAX(emp_id) AS ultimoId FROM empresa";
        try {
            this.conn = conexao.getConnection();
            comando = conn.prepareStatement(sql);
            comando.execute();
            comando = conn.prepareStatement(sqlSelect);
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                ultimoId = rs.getInt("ultimoId");
            } else {
                ultimoId = 0;
            }
        } finally {
            comando.close();
            this.conn.close();
        }
        return ultimoId;
    }

    @Override
    public void excluirUltimoId(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM empresa WHERE emp_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        comando.execute();
        comando.close();
        this.conn.close();
    }

    public void retornaDadosEmpresa() throws SQLException, ClassNotFoundException {
        String sql = "SELECT emp_razaoSocial, emp_cnpj, emp_conta, emp_digConta, emp_agencia, emp_digAgencia FROM empresa";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            setEmp_razao(rs.getString("emp_razaoSocial"));
            setEmp_cnpj(rs.getString("emp_cnpj"));
            setEmp_agencia(rs.getString("emp_agencia"));
            setEmp_digAgencia(rs.getString("emp_digAgencia"));
            setEmp_conta(rs.getString("emp_conta"));
            setEmp_digConta(rs.getString("emp_digConta"));
        }
        comando.executeQuery();
        comando.close();
        this.conn.close();
    }

}
