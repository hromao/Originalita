package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Item_Pedido;

/**
 *
 * @author Henrique
 */
public class DaoItemPedido extends Item_Pedido {

    private Connection conn = null;
    private PreparedStatement comando = null;
    Conexao conexao = new Conexao();

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item_pedido (ped_id, pro_id, quantidade, preco, val_total) "
                + "VALUES (?,?,?,?,?)";

        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_id());
        comando.setInt(2, this.getPro_id());
        comando.setInt(3, this.getQuantidade());
        comando.setDouble(4, this.getPreco());
        comando.setDouble(5, this.getVal_total());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item_pedido SET "
                + "pro_id=?,"
                + "quantidade=?,"
                + "preco=?,"
                + "val_total=? "
                + "WHERE ped_id=? AND pro_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPro_id());
        comando.setInt(2, this.getQuantidade());
        comando.setDouble(3, this.getPreco());
        comando.setDouble(4, this.getVal_total());
        comando.setInt(5, this.getPed_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item_pedido WHERE ped_id = ?";

        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_id());
        try {
            this.conn = conexao.getConnection();
            comando = conn.prepareStatement(sql);

            comando.setInt(1, this.getPed_id());
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

    public void alterarItem(int oldProId) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item_pedido SET "
                + "pro_id=?,"
                + "quantidade=?,"
                + "preco=?,"
                + "val_total=? "
                + "WHERE ped_id=? AND pro_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPro_id());
        comando.setInt(2, this.getQuantidade());
        comando.setDouble(3, this.getPreco());
        comando.setDouble(4, this.getVal_total());
        comando.setInt(5, this.getPed_id());
        comando.setInt(6, oldProId);
        comando.execute();
        comando.close();
        this.conn.close();
    }
    
    public void deleteItensPedido() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item_pedido WHERE ped_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    public ArrayList<DaoItemPedido> retornaItensPedido(int id) throws SQLException, ClassNotFoundException {
        DaoItemPedido itemRetorno = null;
        String sql = "SELECT produto.pro_cod,produto.pro_nome, item_pedido.quantidade, item_pedido.preco, item_pedido.val_total "
                + "FROM item_pedido "
                + "INNER JOIN produto ON item_pedido.pro_id = produto.pro_id "
                + "WHERE ped_id = ?";
        ArrayList<DaoItemPedido> listaItem = new ArrayList<>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            itemRetorno = new DaoItemPedido();
            itemRetorno.setPro_cod(rs.getString("pro_cod"));
            itemRetorno.setPro_nome(rs.getString("pro_nome"));
            itemRetorno.setQuantidade(rs.getInt("quantidade"));
            itemRetorno.setPreco(rs.getDouble("preco"));
            itemRetorno.setVal_total(rs.getDouble("val_total"));

            listaItem.add(itemRetorno);
        }
        rs.close();
        comando.close();
        this.conn.close();
        return listaItem;
    }

    public boolean excluirItem() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item_pedido WHERE ped_id = ? AND pro_id = ? ";

        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getPed_id());
        comando.setInt(2, this.getPro_id());
        try {
            boolean apagou = comando.execute();
            comando.close();
            return apagou;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            this.conn.close();
        }
    }

    public int retornaProId(String cod) throws SQLException, ClassNotFoundException {
        String sql = "SELECT pro_id FROM produto WHERE pro_cod=?";
        int id = 0;
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, cod);
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            id = rs.getInt("pro_id");
        }
        comando.close();
        this.conn.close();
        return id;
    }
}
