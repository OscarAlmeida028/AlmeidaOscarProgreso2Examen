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
                        JOptionPane.showMessageDialog(null, "Se ha encontrado el plato");
                        textoModifPrecio.setEditable(true);
                        textoModifCalorias.setEditable(true);
                        textoModifPreparacion.setEditable(true);
                        textoModifPrecio.setText(String.valueOf(platoEcontrado.getPrecio()));
                        textoModifCalorias.setText(String.valueOf(platoEcontrado.getCalorias()));
                        textoModifPreparacion.setText(String.valueOf(platoEcontrado.getTiempoPreparación()));
                    } else {
                        textAModif.setText("No se ha encontrado el plato");
                    }
                } catch (Exception x) {
                    textAModif.setText("Faltan datos o mal ingresados");
                }
            }
        });
        modificarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plato platoEcontrado = menu.buscarPlatoPorNombre(textoModifNombre.getText());
                    float newPrecio = Float.valueOf(textoModifPrecio.getText());
                    float newCalorias = Float.valueOf(textoModifCalorias.getText());
                    int newTiempoPreparacion = Integer.parseInt(textoModifPreparacion.getText());
                    Plato platoModif = menu.modificarPlato(platoEcontrado, newPrecio, newCalorias, newTiempoPreparacion);
                    JOptionPane.showMessageDialog(null, "Se ha modificado el plato");
                    textoModifPrecio.setEditable(false);
                    textoModifCalorias.setEditable(false);
                    textoModifPreparacion.setEditable(false);
                    textoModifPrecio.setText("");
                    textoModifCalorias.setText("");
                    textoModifPreparacion.setText("");

                    textAModif.setText(platoModif.toString());
                } catch (Exception x) {
                    textAModif.setText("No se ha encontrado el plato");
                }
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plato platoEcontrado = menu.buscarPlatoPorNombre(textoModifNombre.getText());
                    textAEliminar.setText(platoEcontrado.toString());
                } catch (Exception x) {
                    textAModif.setText("Faltan datos o mal ingresados");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String platoeliminado = menu.removerPlatoNombre(textoModifNombre.getText());
                    textAEliminar.setText(platoeliminado);
                }catch (Exception x) {
                    textAModif.setText("Faltan datos o mal ingresados");
                }
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
