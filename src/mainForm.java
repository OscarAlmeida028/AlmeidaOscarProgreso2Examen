import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainForm extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTextField textIngresoNombre;
    private JButton ingresarPlatoButton;
    private JTextArea textAIngresoPlatos;
    private JButton QuemarDatosButton;
    private JTextField textIngresoPrecio;
    private JTextField textIngresoCalorias;
    private JTextField textIngresoPreparacion;
    private JButton buscarModifButton;
    private JButton modificarModifButton;
    private JTextField textoModifNombre;
    private JTextField textoModifPrecio;
    private JTextField textoModifCalorias;
    private JTextField textoModifPreparacion;
    private JTextArea textAModif;
    private JButton ButtonBuscarEliminar;
    private JTextField textNombreEliminar;
    private JTextArea textAEliminar;
    private JButton eliminarButton;
    private JComboBox comboBoxOrder;
    private JButton mostrarButton;
    private JTextArea textAMostrar;
    private JButton buscarButton;
    private JTextField textBuscarPlatoOrden;

    public mainForm() {
        Menu menu = new Menu();

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menu.agregarPlato(new Plato(textIngresoNombre.getText(), Integer.parseInt(textIngresoPrecio.getText()), Integer.parseInt(textIngresoCalorias.getText()), Integer.parseInt(textIngresoPreparacion.getText())));
                    Plato plato = new Plato(textIngresoNombre.getText(), Integer.parseInt(textIngresoPrecio.getText()), Integer.parseInt(textIngresoCalorias.getText()), Integer.parseInt(textIngresoPreparacion.getText()));
                    textAIngresoPlatos.setText(plato.toString());
                }catch (Exception x){
                    textAIngresoPlatos.setText("Faltan datos o mal ingresados");
                }
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(menu.platos.isEmpty()){
                        ArrayList datosQuemados = menu.quemarDatos();
                        textAIngresoPlatos.setText(String.valueOf(datosQuemados));
                        QuemarDatosButton.setEnabled(false);
                    }else {
                        JOptionPane.showMessageDialog(null, "Ya ha ingresado datos no necesita datos quemados");
                        QuemarDatosButton.setEnabled(false);
                    }
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plato platoEcontrado = menu.buscarPlatoPorNombre(textoModifNombre.getText());
                    if (platoEcontrado != null) {
                        textoModifPrecio.setText(platoEcontrado.getNombrePlato());
                        textoModifCalorias.setText(String.valueOf(platoEcontrado.getCalorias()));
                        textoModifPreparacion.setText(String.valueOf(platoEcontrado.getTiempoPreparación()));
                    } else {
                        textAModif.setText("No se ha encontrado el plato");
                    }
                } catch (Exception x) {
                    textAIngresoPlatos.setText("Faltan datos o mal ingresados");
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.modificarPlato(text)
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
