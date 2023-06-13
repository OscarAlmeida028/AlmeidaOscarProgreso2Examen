import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Plato platoEliminar;

    public mainForm() {
        menu menu = new menu();
        modificarModifButton.setEnabled(false);
        eliminarButton.setEnabled(false);

        ingresarPlatoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menu.agregarPlato(new Plato(textIngresoNombre.getText(), Integer.parseInt(textIngresoPrecio.getText()), Integer.parseInt(textIngresoCalorias.getText()), Integer.parseInt(textIngresoPreparacion.getText())));
                    Plato plato = new Plato(textIngresoNombre.getText(), Integer.parseInt(textIngresoPrecio.getText()), Integer.parseInt(textIngresoCalorias.getText()), Integer.parseInt(textIngresoPreparacion.getText()));
                    textAIngresoPlatos.setText(plato.toString());
                } catch (Exception x) {
                    textAIngresoPlatos.setText("Faltan datos o mal ingresados");
                }
            }
        });
        QuemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textAIngresoPlatos.setText(menu.quemarDatos().toString());
                    QuemarDatosButton.setEnabled(false);
                } catch (Exception x) {
                    textAIngresoPlatos.setText("Faltan datos o mal ingresados");
                }
            }
        });
        buscarModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plato platoEcontrado = menu.buscarPlatoPorNombre(textoModifNombre.getText());
                    if (platoEcontrado != null) {
                        modificarModifButton.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Se ha encontrado el plato");
                        textoModifNombre.setEditable(false);
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
                    if (platoEcontrado != null) {
                        float newPrecio = Float.valueOf(textoModifPrecio.getText());
                        float newCalorias = Float.valueOf(textoModifCalorias.getText());
                        int newTiempoPreparacion = Integer.parseInt(textoModifPreparacion.getText());
                        Plato platoModif = menu.modificarPlato(platoEcontrado, newPrecio, newCalorias, newTiempoPreparacion);
                        JOptionPane.showMessageDialog(null, "Se ha modificado el plato");
                        textoModifNombre.setEditable(true);
                        textoModifPrecio.setEditable(false);
                        textoModifCalorias.setEditable(false);
                        textoModifPreparacion.setEditable(false);
                        textoModifPrecio.setText("");
                        textoModifCalorias.setText("");
                        textoModifPreparacion.setText("");
                        textAModif.setText(platoModif.toString());
                        modificarModifButton.setEnabled(false);
                    }
                } catch (Exception x) {
                    textAModif.setText("No se ha encontrado el plato");
                }
            }
        });
        ButtonBuscarEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Plato platoEcontrado = menu.buscarPlatoPorNombre(textNombreEliminar.getText());
                    if (platoEcontrado != null) {
                        eliminarButton.setEnabled(true);
                        mainForm.this.platoEliminar = platoEcontrado;
                        JOptionPane.showMessageDialog(null, "El plato se ha encontrado");
                        textAEliminar.setText(platoEcontrado.toString());
                    }
                } catch (Exception x) {
                    textAModif.setText("Faltan datos o mal ingresados");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminarButton.setEnabled(false);
                    menu.removerPlatoNombre(platoEliminar);
                    textAEliminar.setText("No se ha encontrado el plato");
                } catch (Exception x) {
                    textAModif.setText("Faltan datos o mal ingresados");
                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder sb = new StringBuilder();
                    if (comboBoxOrder.getSelectedIndex() == 0) { //Nombre
                        Ordenamiento.ordenamientoBurbujaNombre(menu.getPlatos());
                        for (Plato plato : menu.getPlatos()) {
                            sb.append(plato.toString());
                        }
                        textAMostrar.setText(sb.toString());
                    } else if (comboBoxOrder.getSelectedIndex() == 1) {//Precio
                        Ordenamiento.ordenamientoBurbujaPrecio(menu.getPlatos());
                        for (Plato plato : menu.getPlatos()) {
                            sb.append(plato.toString());
                        }
                        textAMostrar.setText(sb.toString());
                    } else if (comboBoxOrder.getSelectedIndex() == 2) {//Calorías
                        Ordenamiento.ordenamientoIncersionCalorias(menu.getPlatos());
                        for (Plato plato : menu.getPlatos()) {
                            sb.append(plato.toString());
                        }
                        textAMostrar.setText(sb.toString());
                    } else {//Tiempo de preparación
                        Ordenamiento.ordenamientoIncesionTiempoPreparacion(menu.getPlatos());
                        for (Plato plato : menu.getPlatos()) {
                            sb.append(plato.toString());
                        }
                        textAMostrar.setText(sb.toString());
                    }
                } catch (Exception x) {
                    textAMostrar.setText("Faltan datos o mal ingresados");
                }
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean encontrado = false;
                    if (comboBoxOrder.getSelectedIndex() == 0) { //Si es 0 es por nombre
                        Ordenamiento.ordenamientoBurbujaNombre(menu.getPlatos());
                        Plato platoEncontrado = menu.buscarPorNombre(menu.getPlatos(), textBuscarPlatoOrden.getText());
                        if (platoEncontrado != null) {
                            textAMostrar.setText(platoEncontrado.toString());
                        }else{
                            JOptionPane.showMessageDialog(null, "No hay resultados");
                            textAMostrar.setText("No hay resultados");
                        }
                    } else if (comboBoxOrder.getSelectedIndex() == 1) { //Es precio
                        Ordenamiento.ordenamientoBurbujaPrecio(menu.getPlatos());
                        Plato platoEncontrado = menu.buscarPorPrecio(menu.getPlatos(), Double.parseDouble(textBuscarPlatoOrden.getText()));
                        if (platoEncontrado != null) {
                            textAMostrar.setText(platoEncontrado.toString());
                        }else{
                            JOptionPane.showMessageDialog(null, "No hay resultados");
                            textAMostrar.setText("No hay resultados");
                        }
                    } else if (comboBoxOrder.getSelectedIndex() == 2) { //Calorias
                        Ordenamiento.ordenamientoIncersionCalorias(menu.getPlatos());
                        Plato platoEncontrado = menu.buscarPorCalorias(menu.getPlatos(), Double.parseDouble(textBuscarPlatoOrden.getText()));
                        if (platoEncontrado != null) {
                            textAMostrar.setText(platoEncontrado.toString());
                        }else{
                            JOptionPane.showMessageDialog(null, "No hay resultados");
                            textAMostrar.setText("No hay resultados");
                        }
                    } else { //Tiempo de preparacion
                        Ordenamiento.ordenamientoIncesionTiempoPreparacion(menu.getPlatos());
                        Plato platoEncontrado = menu.buscarPorTiempoPreparación(menu.getPlatos(), Double.parseDouble(textBuscarPlatoOrden.getText()));
                        if (platoEncontrado != null) {
                            textAMostrar.setText(platoEncontrado.toString());
                        }else{
                            JOptionPane.showMessageDialog(null, "No hay resultados");
                            textAMostrar.setText("No hay resultados");
                        }
                    }
                    }catch(Exception x){
                        textAMostrar.setText("Faltan datos o mal ingresados");
                    }
                }
        });
    }


    //Get mainPanel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
