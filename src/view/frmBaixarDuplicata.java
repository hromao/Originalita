package view;

import dao.DaoDuplicata;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import static view.frmBaixarDuplicata.duplicata;

/**
 *
 * @author Henrique
 */
public class frmBaixarDuplicata extends javax.swing.JDialog {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static DaoDuplicata duplicata;
    NumberFormatter nfPreco;
    MaskFormatter mfData;
    Date dataAtual = new Date(System.currentTimeMillis());

    /**
     * Creates new form frmBaixarDuplicata2
     */
    public frmBaixarDuplicata(DaoDuplicata ddup) {
        try {
            initComponents();
            
            DecimalFormat dFormat = new DecimalFormat("#,###,##0.00");
            NumberFormatter formatter = new NumberFormatter(dFormat);
            nfPreco = new NumberFormatter(dFormat);
            nfPreco.setValueClass(Double.class);
            formatter.setFormat(dFormat);
            formatter.setAllowsInvalid(false);
            txtValorPago.setFormatterFactory(new DefaultFormatterFactory(formatter));
            //txtValorTitulo.setFormatterFactory(new DefaultFormatterFactory(formatter));

            mfData = new MaskFormatter("##/##/####");
            mfData.setValueContainsLiteralCharacters(true);
            mfData.setPlaceholderCharacter('_');
            mfData.setValueClass(String.class);
            DefaultFormatterFactory ddfData = new DefaultFormatterFactory(mfData);
            txtDataPgto.setFormatterFactory(ddfData);
            txtDataPgto.setText(sdf.format(dataAtual));
            
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (screen.width = this.getWidth()) / 2;
            int y = (screen.height - this.getHeight()) / 2;
            
            setBounds(x, y, this.getWidth(), this.getHeight());
            
            ddup.retornaDadosDuplicata(ddup.getDup_id());
            txtId.setText(String.valueOf(ddup.getDup_id()));
            txtValorTitulo.setText(nfPreco.valueToString(ddup.getDup_valor()));
            txtNumero.setText(ddup.getDup_numero());
            //para calculo do valor pago
            double valorDup = ddup.getDup_valor();
            double saldo = ddup.getDup_saldo();
            double valorPago = valorDup - saldo;
            txtValorPago.setText(nfPreco.valueToString(valorPago));
            setModal(true);
            setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            setVisible(true);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro " + ex.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro no Banco de Dados" + e.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro de classe" + e.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtValorTitulo = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDataPgto = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorPago = new javax.swing.JFormattedTextField();
        btnBaixar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtId.setEditable(false);

        jLabel1.setText("ID");

        jLabel2.setText("Número");

        txtNumero.setEditable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pagamento"));

        txtValorTitulo.setEditable(false);

        jLabel3.setText("Valor do Título");

        jLabel4.setText("Valor Pago");

        jLabel5.setText("Data do Pagamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtDataPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorTitulo))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnBaixar.setText("Baixar");
        btnBaixar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaixarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnBaixar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaixar)
                    .addComponent(btnCancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaixarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaixarActionPerformed
        try {
            DaoDuplicata ddup = new DaoDuplicata();
            double valorDuplicata = Double.parseDouble(txtValorTitulo.getText().replaceAll(",", "."));
            double valorPago = Double.parseDouble(txtValorPago.getText().replaceAll(",", "."));
            double saldo = valorDuplicata - valorPago;
            ddup.setDup_saldo(saldo);
            java.util.Date dataUtil = sdf.parse(txtDataPgto.getText());
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            ddup.setDtPagamento(dataSql);
            ddup.setDup_id(Integer.parseInt(txtId.getText()));
            ddup.baixaDuplicata(dataSql);
            JOptionPane.showMessageDialog(this, "Título Baixado com sucesso!");
            this.dispose();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro " + ex.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro no Banco de Dados" + e.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro de classe" + e.getMessage(), "Erro:",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBaixarActionPerformed
    
    public static DaoDuplicata showBaixarDup(DaoDuplicata ddup) throws SQLException, ClassNotFoundException {
        frmBaixarDuplicata frmBaixarDuplicata = new frmBaixarDuplicata(ddup);
        return duplicata;
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaixar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtDataPgto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtValorPago;
    private javax.swing.JFormattedTextField txtValorTitulo;
    // End of variables declaration//GEN-END:variables
}
