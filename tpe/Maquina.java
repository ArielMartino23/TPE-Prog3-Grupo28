package tpe;
import java.util.*;
public class Maquina {
    String nombre;
    int cantidadPiezas;
    Pieza piezasATrabajar;
    
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
    public Pieza getPiezasATrabajar() {
        return piezasATrabajar;
    }
    public void setPiezasATrabajar(Pieza piezasATrabajar) {
        this.piezasATrabajar = piezasATrabajar;
    }


}   
