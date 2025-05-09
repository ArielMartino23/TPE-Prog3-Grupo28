package tpe;
public class Maquina {
    String nombre;
    int cantidadPiezas;
    
    
    public Maquina(String nombre, int cantidadPiezas) {
        this.nombre = nombre;
        this.cantidadPiezas = cantidadPiezas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadPiezas() {
        return cantidadPiezas;
    }
    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + ", cantidadPiezas=" + cantidadPiezas + "]";
    }

}   
