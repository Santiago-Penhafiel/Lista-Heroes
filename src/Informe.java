import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Informe extends JDialog{
    private JScrollPane scroll;
    private JTable tabla;
    private JPanel Informe;
    private DefaultTableModel model;

    public Informe(){
        setContentPane(Informe);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        String[] columnas = new String[]{"Nombre", "Superpoder principal", "Pago mensual", "Aporte al fondo de héroes",
        "Impuesto del gobierno", "Pago neto a recibir"};
        this.model  = new DefaultTableModel(columnas, 0);
        tabla.setModel(model);
    }

    public JTable getTabla (){
        return tabla;
    }
    public DefaultTableModel getModel(){
        return model;
    }

}
