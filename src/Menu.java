import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Menu {
    ArrayList<Plato> platos = new ArrayList<>();

    public void agregarPlato(Plato plato) {
        for (Plato p : platos) {
            if (plato.getNombrePlato().equals(p.getNombrePlato())) {
                JOptionPane.showMessageDialog(null, "Ya existe un plato con ese nombre");
                return;
            }
        }
        platos.add(plato);
        JOptionPane.showMessageDialog(null, "El plato se ha agregado con éxito");
    }

    public ArrayList<Plato> quemarDatos(){
        ArrayList<Plato> datosQuemados = new ArrayList<>();
        Plato plato1 = new Plato("Plato1", 1, 1, 1);
        datosQuemados.add(plato1);

        Plato plato2 = new Plato("Plato2", 2, 2, 2);
        datosQuemados.add(plato2);

        Plato plato3 = new Plato("Plato3", 3, 3, 3);
        datosQuemados.add(plato3);

        Plato plato4 = new Plato("Plato4", 4, 4, 4);
        datosQuemados.add(plato4);

        Plato plato5 = new Plato("Plato5", 5, 5, 5);
        datosQuemados.add(plato5);

        platos.addAll(datosQuemados);
        return datosQuemados;
    }

    public String buscarPlatoPorNombre(String nombrePlato) {
        String platoEncontrado = "";
        for (Plato plato : platos) {
            if (plato.getNombrePlato().equals(nombrePlato)) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado el plato");
                platoEncontrado = plato.toString();
                return platoEncontrado;
            }
        }
        JOptionPane.showMessageDialog(null, "El plato no se ha encontrado");
        return null;
    }


/*
    public Empleado buscarEmpleadoPorNombre(String nombreBuscado) {
        int izquierda = 0;
        int derecha = pilaEmpleados.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            pilaEmpleados.sort(Comparator.comparing(Empleado::getNombreCompleto)); //Ordeno la pila
            int comparacion = nombreBuscado.compareTo(pilaEmpleados.elementAt(medio).getNombreCompleto());

            if (comparacion == 0) {
                return pilaEmpleados.elementAt(medio);

            } else if (comparacion < 0) {
                derecha = medio - 1;
            } else {
                // La cédula buscada está después que el elemento medio
                izquierda = medio + 1;
            }
        }
        return null;
    }

    public Empleado buscarEmpleadoPorCedula(String cedulaBuscada) {
        int izquierda = 0;
        int derecha = pilaEmpleados.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            //(s1, s2) -> s1.getCedula().compareTo(s2.getCedula())
            pilaEmpleados.sort(Comparator.comparing(Empleado::getCedula));
            int comparacion = cedulaBuscada.compareTo(pilaEmpleados.elementAt(medio).getCedula());

            if (comparacion == 0) {
                return pilaEmpleados.elementAt(medio);

            } else if (comparacion < 0) {
                derecha = medio - 1;
            } else {
                // La cédula buscada está después que el elemento medio
                izquierda = medio + 1;
            }
        }
        return null;
    }

    public boolean ModificarDatosEmpleado(String CedulaBuscada, String newNombre, double newSueldo, String newCedula, String newTelefono) {
        Empleado x = buscarEmpleadoPorCedula(newCedula); //Tu cedula
        if ( x == null) {
            for (Empleado e : pilaEmpleados) {
                if (e.getCedula().equals(CedulaBuscada)) {
                    e.setCedula(newCedula);
                    e.setSueldoMensual(newSueldo);
                    e.setNombreCompleto(newNombre);
                    e.setTelefono(newTelefono);
                    return true;
                }
            }
        }
        return false;
    }

    public StringBuilder ListadoEmpleados () {

        StringBuilder sb = new StringBuilder();
        sb.append("-\tLista de nombres los empleados\n");

        for (Empleado e : pilaEmpleados) {
            sb.append("Nombre: ").append(e.getNombreCompleto()).append("\n");
        }

        return sb;
    }

    public StringBuilder ListadoEmpleadosCompleta () {

        StringBuilder sb = new StringBuilder();
        sb.append("-\tLista completa de los empleados\n");

        for (Empleado e : pilaEmpleados) {
            sb.append(e.toString());
        }

        return sb;
    }



*/

}
