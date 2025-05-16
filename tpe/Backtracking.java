package tpe;

import java.util.*;

/*
 * Estrategia de resolución:
 * - Generamos el árbol de exploración donde cada nodo representa una combinación parcial de máquinas
 *   para llegar a la cantidad objetivo.
 * - Cada vez que alcanzamos la cantidad exacta de piezas, evaluamos si es la mejor solución (menos puestas en marcha).
 * - Podamos ramas cuando ya usamos más máquinas que la mejor solución encontrada hasta ahora.
 * - Métrica: contamos cuántos estados (nodos) se generaron en total.
 */
public class Backtracking {
    private List<Maquina> maquinas;
    private int cantPiezas;
    private List<Maquina> mejorCombinacion;
    private int mejorCantidadMaquinas;
    private int estadosGenerados;

    public Backtracking(List<Maquina> maquinas, int cantPiezas) {
        this.maquinas = maquinas;
        this.cantPiezas = cantPiezas;
        this.mejorCombinacion = new ArrayList<>();
        this.mejorCantidadMaquinas = Integer.MAX_VALUE;
        this.estadosGenerados = 0;
    }

    public List<Maquina> buscarCombinacion(){
        backtrack(new ArrayList<>(), 0);
        return mejorCombinacion;
    }

    private void backtrack(List<Maquina> seleccionadas, int piezasActuales){
        estadosGenerados++;

        if (piezasActuales == cantPiezas) {
            if (seleccionadas.size() < mejorCantidadMaquinas) {
                mejorCantidadMaquinas = seleccionadas.size();
                mejorCombinacion = new ArrayList<>(seleccionadas);
            }
            return;
        }

        if (piezasActuales > cantPiezas || seleccionadas.size() >= mejorCantidadMaquinas) {
            return;
        }

        for (Maquina maquina : maquinas) {
            seleccionadas.add(maquina);
            backtrack(seleccionadas, piezasActuales + maquina.getCantidadPiezas());
            seleccionadas.remove(seleccionadas.size() - 1);
        }
    }
    

    public void mostrarResultado() {
        System.out.println("Backtracking");
        if (mejorCombinacion.isEmpty()) {
            System.out.println("No se encontró una combinación posible.");
            return;
        }

        System.out.print("Solución obtenida (secuencia de máquinas): ");
        for (Maquina m : mejorCombinacion) {
            System.out.print(m.getNombre() + " ");
        }
        System.out.println();

        int piezasTotales = mejorCombinacion.stream().mapToInt(Maquina::getCantidadPiezas).sum();
        System.out.println("Cantidad de piezas producidas: " + piezasTotales);
        System.out.println("Cantidad de puestas en funcionamiento: " + mejorCombinacion.size());
        System.out.println("Estados generados (nodos explorados): " + estadosGenerados);
    }
}   
