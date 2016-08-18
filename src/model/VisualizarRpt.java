package model;

import dao.Conexao;
import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Henrique
 */
public class VisualizarRpt {

    public static void geraRelatorio(String arquivoRpt, Map parameter, String titulo) throws Exception {
        Connection conn = Conexao.getConnection();
        JasperPrint jp = JasperFillManager.fillReport("lib/rpt/" + arquivoRpt, parameter, conn);
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setTitle(titulo);
        viewer.setVisible(true);

    }

}
