package tpe;
import java.util.*;
public class main {
    private static List<Maquina> maquinas;
    private static int piezas;

    public static void main(String[] args){
        Lector lector = new Lector("datasets/estructura.csv");

        maquinas = lector.obtenerMaquinas();
        piezas = lector.obtenerPiezas();

        System.out.println(" Piezas a producir: " + piezas);
        System.out.println(" Máquinas disponibles:");
        for (Maquina m : maquinas)
            System.out.println(m);

        Backtracking backtracking = new Backtracking(maquinas, piezas);
        backtracking.buscarCombinacion();
        backtracking.mostrarResultado();

        Greedy greedy = new Greedy(maquinas, piezas, new ArrayList<>() ,0);
        greedy.aplicarGreedy();
        greedy.mostrarResultado();
    }
}
