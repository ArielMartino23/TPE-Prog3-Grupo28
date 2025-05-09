package tpe;
import java.io.File;
import java.util.*;

public class main {
    private static HashMap<String, Integer> maquinas;
    private static int piezas;

    public static void main(String[] args){
        Lector lector = new Lector("tpe/datasets/estructura.csv");

        maquinas = lector.obtenerMaquinas();
        piezas = lector.obtenerPiezas();

        System.out.println("las piezas son: "+piezas);
        System.out.println("las maquinas son: "+maquinas);
        System.out.println();
    }
}
