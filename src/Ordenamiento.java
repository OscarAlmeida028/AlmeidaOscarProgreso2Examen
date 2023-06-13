import java.util.ArrayList;

public class Ordenamiento {
    public static void ordenamientoBurbujaNombre(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (platos.get(j).getNombrePlato().compareTo(platos.get(j + 1).getNombrePlato()) > 0) {
                    Plato temp = platos.get(j);
                    platos.set(j, platos.get(j + 1));
                    platos.set(j + 1, temp);
                }
            }
        }
    }

    public static void ordenamientoBurbujaPrecio(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (platos.get(j).getPrecio() > platos.get(j + 1).getPrecio()) {
                    // Intercambiar platos.get(j) y platos.get(j + 1)
                    Plato temp = platos.get(j);
                    platos.set(j, platos.get(j + 1));
                    platos.set(j + 1, temp);
                }
            }
        }
    }

    public static void ordenamientoIncersionCalorias(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 1; i < n; ++i) {
            Plato key = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getCalorias() > key.getCalorias()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, key);
        }
    }

    public static void ordenamientoIncesionTiempoPreparacion(ArrayList<Plato> platos) {
        int n = platos.size();
        for (int i = 1; i < n; ++i) {
            Plato key = platos.get(i);
            int j = i - 1;

            while (j >= 0 && platos.get(j).getTiempoPreparación() > key.getTiempoPreparación()) {
                platos.set(j + 1, platos.get(j));
                j = j - 1;
            }
            platos.set(j + 1, key);
        }
    }
}
