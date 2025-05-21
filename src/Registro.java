import javax.swing.*;
import java.awt.event.*;

public class Registro extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputId;
    private JTextField inputNombre;
    private JTextField inputSuperPoder;
    private JTextField inputMision;
    private JTextField inputNivelDificultad;
    private JTextField inputPagoMensual;
    private JLabel id;
    private JLabel nombre;
    private JLabel superPoder;
    private JLabel mision;
    private JLabel nivelDificultad;
    private JLabel pagoMensual;
    public Heroe heroe = null;

    public Registro() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            String id = inputId.getText();
            String nombre = inputNombre.getText();
            String superPoder = inputSuperPoder.getText();
            String mision = inputMision.getText();
            int nivelDificultad = Integer.parseInt(inputNivelDificultad.getText());
            double pagoMensual = Double.parseDouble(inputPagoMensual.getText());
            heroe = new Heroe(id, nombre, superPoder, mision, nivelDificultad, pagoMensual);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}


