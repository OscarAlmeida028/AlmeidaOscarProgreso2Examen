import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class menu {
    ArrayList<Plato> platos = new ArrayList<>();

    public void agregarPlato(Plato plato) {
        Boolean validacion = validarNombreUnico(plato);
        if (validacion) {
            platos.add(plato);
            JOptionPane.showMessageDialog(null, "El plato se ha agregado con éxito");
        } else
            JOptionPane.showMessageDialog(null, "El plato no se ha podido agregar");
    }

    public boolean validarNombreUnico(Plato platoIngreso) {
        for (Plato plato : platos) {
            if (plato.getNombrePlato().equals(platoIngreso.getNombrePlato())) {
                JOptionPane.showMessageDialog(null, "Ya existe un plato con ese nombre");
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Nombre de plato válido");
        return true;
    }


    public ArrayList<Plato> quemarDatos(){
        ArrayList<Plato> datosQuemados = new ArrayList<>();
        Plato plato1 = new Plato("Plato1", 1, 1, 1);
        Plato plato2 = new Plato("Plato2", 1, 2, 2);
        Plato plato3 = new Plato("Plato3", 3, 3, 3);
        Plato plato4 = new Plato("Plato4", 6, 4, 4);
        Plato plato5 = new Plato("Plato5", 5, 5, 5);

        datosQuemados.add(plato1);
        datosQuemados.add(plato2);
        datosQuemados.add(plato3);
        datosQuemados.add(plato4);
        datosQuemados.add(plato5);

        agregarPlato(plato1);
        agregarPlato(plato2);
        agregarPlato(plato3);
        agregarPlato(plato4);
        agregarPlato(plato5);

        return datosQuemados;
    }

    public Plato buscarPlatoPorNombre(String nombrePlato) {
        for (Plato plato : platos) {
            if (plato.getNombrePlato().equals(nombrePlato)) {
                return plato;
            }
        }
        JOptionPane.showMessageDialog(null, "El plato no se ha encontrado");
        return null;
    }

    public Plato modificarPlato(Plato plato, float newPrecio, float newCalorias, int newTiempoPreparacion) {
        if (plato != null) {
            plato.setPrecio(newPrecio);
            plato.setCalorias(newCalorias);
            plato.setTiempoPreparación(newTiempoPreparacion);
            return plato;
        }
        return null;
    }

    public void removerPlatoNombre(Plato platoRemover){
        if(platoRemover != null){
            platos.remove(platoRemover);
            JOptionPane.showMessageDialog(null, "El plato se ha eliminado con éxito");
        }else
            JOptionPane.showMessageDialog(null, "No se puedo eliminar el plato, ya que no existe");
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public static int buscarPorNombre(List<Plato> platos, String nombre) {
        int izquierda = 0;
        int derecha = platos.size() - 1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            int comparacion = platos.get(medio).getNombrePlato().compareTo(nombre);
            if (comparacion == 0) {
                return medio;
            }
            if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

    public static int buscarPorPrecio(List<Plato> platos, double precio) {
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0;
        ultimo = platos.size() - 1;
        while (primero <= ultimo) {
            centro = (primero+ultimo)/2;
            valorCentro = platos.get(centro).getPrecio();

            if (precio == valorCentro) {
                return centro;
            } else if (precio < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return -1;
    }

    public static int buscarPorCalorias(List<Plato> platos, double calorias) {
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0;
        ultimo = platos.size() - 1;
        while (primero <= ultimo) {
            centro = (primero+ultimo)/2;
            valorCentro = platos.get(centro).getCalorias();

            if (calorias == valorCentro) {
                return centro;
            } else if (calorias < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return -1;
    }

    public static int buscarPorTiempoPreparación(List<Plato> platos, double tiempo) {
        int centro, primero, ultimo;
        double valorCentro;
        primero = 0;
        ultimo = platos.size() - 1;
        while (primero <= ultimo) {
            centro = (primero+ultimo)/2;
            valorCentro = platos.get(centro).getTiempoPreparación();

            if (tiempo == valorCentro) {
                return centro;
            } else if (tiempo < valorCentro) {
                ultimo = centro - 1;
            } else {
                primero = centro + 1;
            }
        }
        return -1;
    }


}
