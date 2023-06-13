public class Plato {
    private String nombrePlato;
    private float precio, calorias;
    private int tiempoPreparación;

    public Plato(String nombrePlato, float precio, float calorias, int tiempoPreparación) {
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.calorias = calorias;
        this.tiempoPreparación = tiempoPreparación;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public int getTiempoPreparación() {
        return tiempoPreparación;
    }

    public void setTiempoPreparación(int tiempoPreparación) {
        this.tiempoPreparación = tiempoPreparación;
    }

    @Override
    public String toString() {
        return "\nNomnbre:" + nombrePlato +
                "\nPrecio: " + precio +
                "\nCalorías: " + calorias +
                "\nTiempo de Preparación: " + tiempoPreparación;
    }
}
