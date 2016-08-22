package view;

import dao.DaoCliente;
import dao.DaoPedidoOrcamento;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class dlgGeraPedido extends javax.swing.JDialog {

    private HashMap<String, String> dadosCliente;
    private ArrayList<DaoCliente> listaCli;

    public dlgGeraPedido(HashMap<String, String> dados) {
        initComponents();
        this.setModal(true);
        lblId.setVisible(false);
        lblId.setText(dados.get("id"));
        inicializaCombo();
        this.dadosCliente = dados;
    }

    private void inicializaCombo() {
        try {            
            DaoCliente cliente = new DaoCliente();
            cliente.setNome_cli("");
            listaCli = new ArrayList<DaoCliente>();
            cmbCliente.removeAllItems();
            listaCli.addAll(cliente.pesquisar(cliente));
            for (DaoCliente daoCli : listaCli) {
                cmbCliente.addItem(daoCli.getNome_cli());
            }

            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screen.width - this.getWidth()) / 2;
            int y = (screen.height - this.getHeight()) / 2;

            setBounds(x, y, this.getWidth(), this.getHeight());
            setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro:" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro:" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox();
        btnPesquisar = new javax.swing.JButton();
        btnGerarPedido = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerar Pedido"));

        jLabel1.setText("Selecione o Cliente");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPesquisar.setText("...");

        btnGerarPedido.setText("Gerar Pedido");
        btnGerarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarPedidoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblId.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblId))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGerarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerarPedido)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGerarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarPedidoActionPerformed
        DaoPedidoOrcamento dped = new DaoPedidoOrcamento();
        try {
            if (cmbCliente.getSelectedIndex() != 0) {
                dped.setPed_id(Integer.parseInt(lblId.getText()));
                dped.retornaDadosPedido();
                if (listaCli.get(cmbCliente.getSelectedIndex()).getId_cli() != -1) {
                    int pedNum = dped.pegaUltimoNumPed("P") + 1;
                    dped.setCli_id(listaCli.get(cmbCliente.getSelectedIndex()).getId_cli());
                    dped.setCli_endereco(listaCli.get(cmbCliente.getSelectedIndex()).getEndereco_cli());
                    dped.setCli_numero(listaCli.get(cmbCliente.getSelectedIndex()).getNumero_cli());
                    dped.setCli_comple(listaCli.get(cmbCliente.getSelectedIndex()).getComple_cli());
                    dped.setCli_bairro(listaCli.get(cmbCliente.getSelectedIndex()).getBairro_cli());
                    dped.setCli_cidade(listaCli.get(cmbCliente.getSelectedIndex()).getCidade_cli());
                    dped.setCli_uf(listaCli.get(cmbCliente.getSelectedIndex()).getUf_cli());
                    dped.setCli_cep(listaCli.get(cmbCliente.getSelectedIndex()).getCep_cli());
                    dped.setPed_num(pedNum);
                    dped.setPed_tipo("P");
                    dped.geraPedOrc();
                    this.dispose();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGerarPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGerarPedido;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables
}
