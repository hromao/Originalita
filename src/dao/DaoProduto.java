package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produtos;

/**
 *
 * @author Henrique
 */
public class DaoProduto extends Produtos {

    private Connection conn = null;
    private PreparedStatement comando = null;
    Date data = null;

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO produto (pro_id, pro_cod, pro_nome, pro_preco,"
                + "pro_pesoLiq, pro_pesoBruto, pro_ativo, pro_sdAtual, pro_dataCadastro, pro_infoComple)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);

        comando.setInt(1, this.getPro_id());
        comando.setString(2, this.getPro_cod());
        comando.setString(3, this.getPro_nome());
        comando.setDouble(4, this.getPro_preco());
        comando.setDouble(5, this.getPro_pesoLiq());
        comando.setDouble(6, this.getPro_pesoBruto());
        comando.setString(7, this.getPro_ativo());
        comando.setDouble(8, this.getPro_sdAtual());
        data = new Date(getPro_dataCadastro().getTime());
        comando.setDate(9, data);
        comando.setString(10, this.getPro_infoComple());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE produto SET "
                + "pro_cod=?,"
                + "pro_nome=?,"
                + "pro_preco=?,"
                + "pro_pesoLiq=?,"
                + "pro_pesoBruto=?,"
                + "pro_ativo=?,"
                + "pro_sdAtual=?,"
                + "pro_infoComple=? "
                + "WHERE pro_id=?";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);

        comando.setString(1, this.getPro_cod());
        comando.setString(2, this.getPro_nome());
        comando.setDouble(3, this.getPro_preco());
        comando.setDouble(4, this.getPro_pesoLiq());
        comando.setDouble(5, this.getPro_pesoBruto());
        comando.setString(6, this.getPro_ativo());
        comando.setDouble(7, this.getPro_sdAtual());
        comando.setString(8, this.getPro_infoComple());
        comando.setInt(9, this.getPro_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM produto WHERE pro_id=?";
        try {
            this.conn = Conexao.getConnection();
            comando = conn.prepareStatement(sql);

            comando.setInt(1, this.getPro_id());
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
        String sql = "SELECT MAX(pro_id) AS ultimoID FROM produto";
        try {
            this.conn = Conexao.getConnection();
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

    public ArrayList<DaoProduto> pesquisar(DaoProduto produto) throws SQLException, ClassNotFoundException {
        DaoProduto produtoRetorno = null;
        String sql = "SELECT * FROM produto WHERE pro_nome LIKE ?";

        ArrayList<DaoProduto> listaProdutos = new ArrayList<DaoProduto>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + produto.getPro_nome() + "%");
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            produtoRetorno = new DaoProduto();
            produtoRetorno.setPro_id(rs.getInt("pro_id"));
            produtoRetorno.setPro_cod(rs.getString("pro_cod"));
            produtoRetorno.setPro_nome(rs.getString("pro_nome"));
            produtoRetorno.setPro_preco(rs.getDouble("pro_preco"));
            produtoRetorno.setPro_sdAtual(rs.getDouble("pro_sdAtual"));
            produtoRetorno.setPro_ativo(rs.getString("pro_ativo"));

            listaProdutos.add(produtoRetorno);
        }

        rs.close();
        comando.close();
        this.conn.close();

        return listaProdutos;
    }

    public ArrayList<DaoProduto> pesquisarCod(DaoProduto produto) throws SQLException, ClassNotFoundException {
        DaoProduto produtoRetorno = null;
        String sql = "SELECT * FROM produto WHERE pro_cod LIKE ?";

        ArrayList<DaoProduto> listaProdutos = new ArrayList<DaoProduto>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + produto.getPro_cod() + "%");
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            produtoRetorno = new DaoProduto();
            produtoRetorno.setPro_id(rs.getInt("pro_id"));
            produtoRetorno.setPro_cod(rs.getString("pro_cod"));
            produtoRetorno.setPro_nome(rs.getString("pro_nome"));
            produtoRetorno.setPro_preco(rs.getDouble("pro_preco"));
            produtoRetorno.setPro_sdAtual(rs.getDouble("pro_sdAtual"));
            produtoRetorno.setPro_ativo(rs.getString("pro_ativo"));

            listaProdutos.add(produtoRetorno);
        }

        rs.close();
        comando.close();
        this.conn.close();

        return listaProdutos;
    }

    public void retornaDados() throws SQLException, ClassNotFoundException {
        DaoProduto produtoRetorno = null;
        String sql = "SELECT * FROM produto WHERE pro_id = ?";
        ArrayList<DaoProduto> listaProdutos = new ArrayList<DaoProduto>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, getPro_id());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            produtoRetorno = new DaoProduto();
            setPro_id(rs.getInt("pro_id"));
            setPro_cod(rs.getString("pro_cod"));
            setPro_nome(rs.getString("pro_nome"));
            setPro_preco(rs.getDouble("pro_preco"));
            setPro_pesoLiq(rs.getDouble("pro_pesoLiq"));
            setPro_pesoBruto(rs.getDouble("pro_pesoBruto"));
            setPro_ativo(rs.getString("pro_ativo"));
            setPro_sdAtual(rs.getDouble("pro_sdAtual"));
            setPro_dataCadastro(rs.getDate("pro_dataCadastro"));
            setPro_infoComple(rs.getString("pro_infoComple"));

        }

        comando.executeQuery();
        comando.close();
        this.conn.close();
    }

}
