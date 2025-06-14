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
        backtrack(maquinas,new ArrayList<>(), 0, 0); 
        return mejorCombinacion;
    }

    private void backtrack(List<Maquina> disponibles, List<Maquina> seleccionadas, int piezasActuales, int start){
        estadosGenerados++;

        if (piezasActuales == cantPiezas) { //Condicion corte: Si la cantidad de piezas trabajadas actuales de las maquinas es igual a la cantidad de piezas a ser trabajadas
            if (seleccionadas.size() < mejorCantidadMaquinas) { //Condicion para obtener la minima cantidad de maquinas encendidas
                mejorCantidadMaquinas = seleccionadas.size();
                mejorCombinacion = new ArrayList<>(seleccionadas);
            }
            return;
        }

        if (piezasActuales > cantPiezas || seleccionadas.size() >= mejorCantidadMaquinas) { // Condicion de poda: si la maquina actual produce una mayor cantidad de piezas que las que tienen que ser trabajadas o si estamos obteniendo una mayor cantidad de maquinas puestas en marcha que la actual no sigue
            return;
        }
        
        for(int i = start; i < disponibles.size(); i++){ // Este For evita la repeticion de maquinas puestas en marcha reduciendo la cantidad de estados generados (arbol de exploracion)
            Maquina maquina = disponibles.get(i);
            seleccionadas.add(maquina);
            backtrack(disponibles, seleccionadas, piezasActuales+maquina.getCantidadPiezas(), i);
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
