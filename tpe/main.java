package tpe;
import java.util.*;
/*LEVANTAR LAS MAQUINAS A UNA ESTRUCTURA LISTA */
public class main {
    private static List<Maquina> maquinas;
    private static int piezas;

    public static void main(String[] args){
        Lector lector = new Lector("tpe/datasets/estructura.csv");

        maquinas = lector.obtenerMaquinas();
        piezas = lector.obtenerPiezas();

        System.out.println("las piezas son: "+piezas);
        for(int i = 0; i<maquinas.size();i++)
            System.out.println("las maquinas son: "+maquinas.get(i).toString());
        
    }
}
