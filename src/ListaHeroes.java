import javax.swing.*;
import java.util.ArrayList;

public class ListaHeroes {
    public ArrayList<Heroe> lista;

    public ListaHeroes (){
        this.lista = new ArrayList<>();
    }

    public void registro (Heroe heroe, JTextArea txtCont){
        if (lista.isEmpty()){
            lista.add(heroe);
        } else {
            if (indexId(heroe.getId()) != -1){
                JOptionPane.showMessageDialog(null, "Id existente");
                return;
            }
            if (heroe.getNivelDificultad()>=1 && heroe.getNivelDificultad()<=5){
                lista.add(heroe);
            } else {
                JOptionPane.showMessageDialog(null, "El nivel de dificultad tiene que estar en el rango de 1 a 5");
                return;
            }

        }
        listar(txtCont);
    }

    public int indexId(String id){
        for (Heroe heroe : lista){
            if (heroe.getId().equals(id)){
                return lista.indexOf(heroe);
            }
        }
        return -1;
    }

    public void modificar (JTextArea jTextArea, JTextField jTextField, Registro registro){
        String idBuscar = jTextField.getText();
        int index = indexId(idBuscar);
        if (index!=-1){
            registro.pack();
            registro.setVisible(true);
            lista.set(index, registro.heroe);
            listar(jTextArea);
        } else {
            JOptionPane.showMessageDialog(null, "Héroe no encontrado");
        }
    }

    public void listar(JTextArea txtCont){
        txtCont.setText("");
       if (lista.isEmpty()){
           txtCont.setText("La lista está vacía");
       } else {
           StringBuilder listado = new StringBuilder("\t\tLista de Super héroes\n");
           for (Heroe heroe : lista){
               listado.append(heroe.toString());
           }
           txtCont.setText(listado.toString());
       }
    }

    public void listaSimple (JTextArea txtCont){
        txtCont.setText("");
        if (lista.isEmpty()){
            txtCont.setText("La lista está vacía");
        } else {
            StringBuilder listado = new StringBuilder("\t\tLista de Super héroes \nID\t\tNombre\n");
            for (Heroe heroe : lista){
                listado.append(heroe.getId()).append(heroe.getNombre()).append("\n");
            }
            txtCont.setText(listado.toString());
        }
    }

    public void informes(Informe informe){
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
            return;
        }
        for(Heroe heroe : lista){
            double pagoNeto = heroe.getPagoMensual()*12 - heroe.getAporteFondo()*12 - heroe.getImpuestoGobierno();
            Object[] fila = {heroe.getId(), heroe.getSuperpoder(), heroe.getPagoMensual(), heroe.getAporteFondo(), heroe.getImpuestoGobierno(), pagoNeto};
            informe.getModel().addRow(fila);
        }
        informe.getTabla().setModel(informe.getModel());
    }

}
