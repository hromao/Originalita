/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.PedidosOrc;

/**
 *
 * @author Henrique
 */
public class DaoPedidoOrcamento extends PedidosOrc {

    private Connection conn = null;
    private PreparedStatement comando = null;
    Date dataVenda = null, dataEntrega = null;

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pedido (ped_num, ped_dtVenda, "
                + "ped_dtEntrega, cli_id, ped_total, ped_obs, stp_codigo, "
                + "cli_endereco, cli_numero, cli_comple, cli_bairro, cli_cidade, cli_uf, cli_cep, "
                + "ped_tipo, ped_orcNome, ped_orcFone, ped_orcEmail, ped_orcContato) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        //comando.setInt(1, this.getPed_id());
        comando.setInt(1, this.getPed_num());
        dataVenda = new Date(getDt_venda().getTime());
        dataEntrega = new Date(getDt_Entrega().getTime());
        comando.setDate(2, dataVenda);
        comando.setDate(3, dataEntrega);
        comando.setInt(4, this.getCli_id());
        comando.setDouble(5, this.getPed_total());
        comando.setString(6, this.getPed_obs());
        comando.setInt(7, this.getStp_codigo());
        comando.setString(8, this.getCli_endereco());
        comando.setString(9, this.getCli_numero());
        comando.setString(10, this.getCli_comple());
        comando.setString(11, this.getCli_bairro());
        comando.setString(12, this.getCli_cidade());
        comando.setString(13, this.getCli_uf());
        comando.setString(14, this.getCli_cep());
        comando.setString(15, this.getPed_tipo());
        comando.setString(16, this.getPed_orcNome());
        comando.setString(17, this.getPed_orcFone());
        comando.setString(18, this.getPed_orcEmail());
        comando.setString(19, this.getPed_orcContato());

        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pedido SET "
                + "ped_num=?,"
                + "ped_dtVenda=?,"
                + "ped_dtEntrega=?,"
                + "cli_id=?,"
                + "ped_total=?,"
                + "ped_obs=?,"
                + "stp_codigo=?,"
                + "cli_endereco =?,"
                + "cli_numero =?,"
                + "cli_comple =?,"
                + "cli_bairro =?,"
                + "cli_cidade =?,"
                + "cli_uf =?,"
                + "cli_cep=?, "
                + "ped_orcNome=?,"
                + "ped_orcFone=?, "
                + "ped_orcEmail=?, "
                + "ped_orcContato=? "
                + "WHERE ped_id=?";

        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_num());
        dataVenda = new Date(this.getDt_venda().getTime());
        dataEntrega = new Date(this.getDt_Entrega().getTime());
        comando.setDate(2, dataVenda);
        comando.setDate(3, dataEntrega);
        comando.setInt(4, this.getCli_id());
        comando.setDouble(5, this.getPed_total());
        comando.setString(6, this.getPed_obs());
        comando.setInt(7, this.getStp_codigo());
        comando.setString(8, this.getCli_endereco());
        comando.setString(9, this.getCli_numero());
        comando.setString(10, this.getCli_comple());
        comando.setString(11, this.getCli_bairro());
        comando.setString(12, this.getCli_cidade());
        comando.setString(13, this.getCli_uf());
        comando.setString(14, this.getCli_cep());
        comando.setString(15, this.getPed_orcNome());
        comando.setString(16, this.getPed_orcFone());
        comando.setString(17, this.getPed_orcEmail());
        comando.setString(18, this.getPed_orcContato());
        comando.setInt(19, this.getPed_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM pedido WHERE ped_id=?";
        try {
            this.conn = Conexao.getConnection();
            comando = conn.prepareStatement(sql);
            comando.setInt(1, getPed_id());
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
        String sql = "INSERT INTO pedido (ped_id) VALUE (null)";
        String sqlSelect = "SELECT MAX(ped_id) AS ultimoId FROM pedido";
        try {
            this.conn = Conexao.getConnection();
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
        String sql = "DELETE FROM pedido WHERE ped_id = ?";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        comando.execute();
        comando.close();
        this.conn.close();
    }

    public void retornaDadosPedido() throws SQLException, ClassNotFoundException {
        String sql = "SELECT pedido.ped_id, pedido.ped_num,pedido.ped_dtVenda, pedido.ped_dtEntrega, pedido.cli_id, "
                + "cliente.cli_nome, pedido.cli_endereco, pedido.cli_numero,"
                + " pedido.cli_bairro, pedido.cli_comple, pedido.cli_cidade, pedido.cli_uf, pedido.cli_cep, pedido.ped_total,"
                + "pedido.ped_orcNome, pedido.ped_orcFone, pedido.ped_orcEmail, pedido.ped_orcContato "
                + "FROM pedido INNER JOIN cliente ON pedido.cli_id = cliente.cli_id "
                + "WHERE ped_id = ?";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_id());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            setPed_id(rs.getInt("ped_id"));
            setPed_num(rs.getInt("ped_num"));
            setDt_venda(rs.getDate("ped_dtVenda"));
            setDt_Entrega(rs.getDate("ped_dtEntrega"));
            setCli_id(rs.getInt("cli_id"));
            setCli_nome(rs.getString("cli_nome"));
            setCli_endereco(rs.getString("cli_endereco"));
            setCli_comple(rs.getString("cli_comple"));
            setCli_numero(rs.getString("cli_numero"));
            setCli_bairro(rs.getString("cli_bairro"));
            setCli_cidade(rs.getString("cli_cidade"));
            setCli_uf(rs.getString("cli_uf"));
            setPed_total(rs.getDouble("ped_total"));
            setPed_orcNome(rs.getString("ped_orcNome"));
            setPed_orcFone(rs.getString("ped_orcFone"));
            setPed_orcEmail(rs.getString("ped_orcEmail"));
            setPed_orcContato(rs.getString("ped_orcContato"));
        }
        comando.executeQuery();
        comando.close();
        this.conn.close();

    }

    public String retornaStatusPedido() throws SQLException, ClassNotFoundException {
        String status = null;
        String sql = "SELECT pedido.stp_codigo, status_pedido.stp_nome "
                + "FROM pedido INNER JOIN status_pedido ON pedido.stp_codigo = status_pedido.stp_codigo "
                + "WHERE ped_id = ?";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, getPed_id());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            status = rs.getString("stp_nome");
        }
        return status;
    }

    public String retornaNomeCli() throws SQLException, ClassNotFoundException {
        String nome = null;
        String sql = "SELECT pedido.cli_id, cliente.cli_nome"
                + "FROM pedido INNER JOIN pedido ON pedido.cli_id = cliente.cli_id"
                + "WHERE ped_id = ?"
                + "";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, getPed_id());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            nome = rs.getString("cli_nome");
        }
        return nome;
    }

    public void retornaDadosCliente() throws SQLException, ClassNotFoundException {
        DaoCliente clienteRetorno = new DaoCliente();
        String sql = "SELECT cli_cod, cli_endereco, cli_numero, cli_comple, cli_bairro, cli_cidade, cli_uf "
                + "FROM cliente WHERE cli_cod = ?";
        ArrayList<DaoPedidoOrcamento> listaPedido = new ArrayList<DaoPedidoOrcamento>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, clienteRetorno.getCod_cli());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {

            //setCli_id(rs.getInt("cli_id"));
            //clienteRetorno.setCod_cli(rs.getString("cli_cod"));
            clienteRetorno.setEndereco_cli(rs.getString("cli_endereco"));
            clienteRetorno.setComple_cli(rs.getString("cli_comple"));
            clienteRetorno.setNumero_cli(rs.getString("cli_numero"));
            clienteRetorno.setBairro_cli(rs.getString("cli_bairro"));
            clienteRetorno.setCidade_cli(rs.getString("cli_cidade"));
            clienteRetorno.setUf_cli(rs.getString("cli_uf"));
        }
        comando.close();
        this.conn.close();

    }

    public ArrayList<DaoPedidoOrcamento> retornaTodosPedidos(String tipo) throws SQLException, ClassNotFoundException {
        DaoPedidoOrcamento pedidoRetorno = null;
        String sql = "SELECT pedido.ped_id,pedido.ped_num,pedido.ped_dtVenda,"
                + "pedido.ped_dtEntrega, ped_total, cliente.cli_nome, status_pedido.stp_nome "
                + "FROM pedido "
                + "INNER JOIN cliente on pedido.cli_id = cliente.cli_id "
                + "INNER JOIN status_pedido on pedido.stp_codigo = status_pedido.stp_codigo "
                + "WHERE ped_tipo = ?";

        ArrayList<DaoPedidoOrcamento> listaPedido = new ArrayList<>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, tipo);
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            pedidoRetorno = new DaoPedidoOrcamento();
            pedidoRetorno.setPed_id(rs.getInt("ped_id"));
            pedidoRetorno.setPed_num(rs.getInt("ped_num"));
            pedidoRetorno.setCli_nome(rs.getString("cli_nome"));
            pedidoRetorno.setStp_nome(rs.getString("stp_nome"));
            pedidoRetorno.setDt_venda(rs.getDate("ped_dtVenda"));
            pedidoRetorno.setDt_Entrega(rs.getDate("ped_dtEntrega"));
            pedidoRetorno.setPed_total(rs.getDouble("ped_total"));

            listaPedido.add(pedidoRetorno);
        }
        rs.close();
        comando.close();
        this.conn.close();
        return listaPedido;
    }

    public void atualizaStatus(int stpCod, int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pedido SET "
                + "stp_codigo=? "
                + "WHERE ped_id = ?";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, stpCod);
        comando.setInt(2, id);
        comando.execute();
        comando.close();
        this.conn.close();
    }

    public void updateTotal() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pedido SET "
                + "ped_total=? "
                + "WHERE ped_id=?";

        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setDouble(1, this.getPed_total());
        comando.setInt(2, this.getPed_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    //UTILIZAR DUPLICATA SOMENTE PARA PEDIDOS
    public boolean verificaDuplicata() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM duplicata WHERE ped_id = ?";
        boolean existeDup;
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_id());
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            existeDup = true;
        } else {
            existeDup = false;
        }
        rs.close();
        comando.close();
        this.conn.close();
        return existeDup;
    }

    public ArrayList<DaoPedidoOrcamento> pesquisarNumPed(DaoPedidoOrcamento pedido) throws SQLException, ClassNotFoundException {
        DaoPedidoOrcamento pedidoRetorno = null;
        String sql = "SELECT  pedido.ped_id,pedido.ped_num,pedido.ped_dtVenda, "
                + "pedido.ped_dtEntrega, ped_total, cliente.cli_nome, status_pedido.stp_nome FROM pedido "
                + "INNER JOIN cliente on pedido.cli_id = cliente.cli_id "
                + "INNER JOIN status_pedido on pedido.stp_codigo = status_pedido.stp_codigo "
                + "WHERE pedido.ped_num = ? AND pedido.ped_tipo = ?";

        ArrayList<DaoPedidoOrcamento> listaPedidos = new ArrayList<DaoPedidoOrcamento>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, getPed_num());
        comando.setString(2, getPed_tipo());
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            pedidoRetorno = new DaoPedidoOrcamento();
            pedidoRetorno.setPed_id(rs.getInt("ped_id"));
            pedidoRetorno.setPed_num(rs.getInt("ped_num"));
            pedidoRetorno.setCli_nome(rs.getString("cli_nome"));
            pedidoRetorno.setStp_nome(rs.getString("stp_nome"));
            pedidoRetorno.setDt_venda(rs.getDate("ped_dtVenda"));
            pedidoRetorno.setDt_Entrega(rs.getDate("ped_dtEntrega"));
            pedidoRetorno.setPed_total(rs.getDouble("ped_total"));

            listaPedidos.add(pedidoRetorno);
        }

        rs.close();
        comando.close();
        this.conn.close();

        return listaPedidos;
    }

    public ArrayList<DaoPedidoOrcamento> pesquisarNomeCli(DaoPedidoOrcamento pedido) throws SQLException, ClassNotFoundException {
        DaoPedidoOrcamento pedidoRetorno = null;
        String sql = "SELECT  pedido.ped_id,pedido.ped_num,pedido.ped_dtVenda, "
                + "pedido.ped_dtEntrega, ped_total, cliente.cli_nome, status_pedido.stp_nome FROM pedido "
                + "INNER JOIN cliente on pedido.cli_id = cliente.cli_id "
                + "INNER JOIN status_pedido on pedido.stp_codigo = status_pedido.stp_codigo "
                + "WHERE cliente.cli_nome LIKE ? AND pedido.ped_tipo = ?";

        ArrayList<DaoPedidoOrcamento> listaPedidos = new ArrayList<DaoPedidoOrcamento>();
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + getCli_nome() + "%");
        comando.setString(2, getPed_tipo());
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            pedidoRetorno = new DaoPedidoOrcamento();
            pedidoRetorno.setPed_id(rs.getInt("ped_id"));
            pedidoRetorno.setPed_num(rs.getInt("ped_num"));
            pedidoRetorno.setCli_nome(rs.getString("cli_nome"));
            pedidoRetorno.setStp_nome(rs.getString("stp_nome"));
            pedidoRetorno.setDt_venda(rs.getDate("ped_dtVenda"));
            pedidoRetorno.setDt_Entrega(rs.getDate("ped_dtEntrega"));
            pedidoRetorno.setPed_total(rs.getDouble("ped_total"));

            listaPedidos.add(pedidoRetorno);
        }

        rs.close();
        comando.close();
        this.conn.close();

        return listaPedidos;
    }
    
    public void geraPedOrc() throws SQLException, ClassNotFoundException{
          String sql = "UPDATE pedido SET "
                + "ped_tipo = ? "
                + "WHERE ped_id=?";

        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, this.getPed_tipo());
        comando.setInt(2, this.getPed_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

}
