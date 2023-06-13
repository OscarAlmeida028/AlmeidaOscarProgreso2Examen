import java.util.ArrayList;

public class Ordenamiento {
    public static void ordenamientoBurbujaNombre(ArrayList<Plato> platos) {
        int tamaño = platos.size();
        for (int i = 0; i < tamaño - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tamaño; j++) {
                if (platos.get(j).getNombrePlato().compareTo(platos.get(indiceMinimo).getNombrePlato()) < 0) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Plato platoActual = platos.get(i);
                Plato platoMinimo = platos.get(indiceMinimo);
                platos.set(i, platoMinimo);
                platos.set(indiceMinimo, platoActual);
            }
        }
    }

    public static void ordenamientoBurbujaPrecio(ArrayList<Plato> platos) {
        int tamaño = platos.size();
        for (int i = 0; i < tamaño - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tamaño; j++) {
                if (platos.get(j).getPrecio() < platos.get(indiceMinimo).getPrecio()) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                Plato platoActual = platos.get(i);
                Plato platoMinimo = platos.get(indiceMinimo);
                platos.set(i, platoMinimo);
                platos.set(indiceMinimo, platoActual);
            }
        }
    }

    public static void ordenamientoIncersionCalorias(ArrayList<Plato> platos) {
        int tamaño = platos.size();
        for (int i = 1; i < tamaño; ++i) {
            Plato platoActual = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getCalorias() > platoActual.getCalorias()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, platoActual);
        }
    }

    public static void ordenamientoIncesionTiempoPreparacion(ArrayList<Plato> platos) {
        int tamaño = platos.size();
        for (int i = 1; i < tamaño; ++i) {
            Plato platoActual = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getTiempoPreparación() > platoActual.getTiempoPreparación()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, platoActual);
        }
    }
}
