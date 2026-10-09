package Laboratorio2;

public class Articulo {
    
    String nombre;
    int cantidad;
    String categoria;

    public Articulo(String nombre, int cantidad, String categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad(){
        return cantidad;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%-18s | Cantidad: %-4d | Categoría: %s", nombre, cantidad, categoria);
    }
}
