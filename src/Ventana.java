import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTextArea txtCont;
    private JButton añadirButton;
    private JButton modificarButton;
    private JPanel panel;
    private JLabel titulo;
    private JTextField inputModificar;
    private JButton generarInformeButton;
    private JButton listarHéroesButton;
    ListaHeroes lista = new ListaHeroes();

    public Ventana() {
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Registro registro = new Registro();
                    registro.pack();
                    registro.setVisible(true);
                    Heroe registrado = registro.heroe;
                    if (registrado!=null) {
                        lista.registro(registrado, txtCont);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lista.modificar(txtCont, inputModificar, new Registro());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        generarInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Informe informe = new Informe();
                    lista.informes(informe);
                    informe.pack();
                    informe.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
        listarHéroesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    lista.listaSimple(txtCont);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
