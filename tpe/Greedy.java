package tpe;

import java.util.*;


/*
 * Estrategia de resolucion:
 * - Los candidatos es el conjunto de maquinas
 * - Las maquinas son ordenadas de mayor a menor teniendo en cuenta la cantidad de piezas que producen.
 * - Puede no llegar a trabajar el total de piezas dependiendo de la configuracion de maquinas elegida.
 * - etc.>>
 */
public class Greedy {
    private List<Maquina> maquinas;
    private int cantPiezas;
    private Map<Maquina, Integer> mejorCombinacion;
    private int estadosGenerados;

    public Greedy(List<Maquina> maquinas, int cantPiezas, Map<Maquina, Integer> mejorCombinacion,
            int estadosGenerados) {
        this.maquinas = maquinas;
        this.cantPiezas = cantPiezas;
        this.mejorCombinacion = mejorCombinacion;
        this.estadosGenerados = estadosGenerados;
    }

    public Map<Maquina, Integer> aplicarGreedy(){
        mejorCombinacion = greedy(maquinas, cantPiezas);
        return mejorCombinacion;
    }

    private Map<Maquina, Integer> greedy(List<Maquina> seleccionadas, int cantPiezas){

        Map<Maquina, Integer> candidatos = new HashMap<>();// Conjunto solucion inicialmente vacio

        List<Maquina> maquinasOrdenadas = ordenPorPiezas(seleccionadas);// Lista de maquinas ordenadas de mayor a menor por cantidad de piezas que producen

        

        while(!maquinasOrdenadas.isEmpty() && cantPiezas > 0 ){ // Mientas hayan candidatos o hayan piezas por producir...
            estadosGenerados++;

            Maquina x1 = maquinasOrdenadas.get(0);

            maquinasOrdenadas.remove(x1);
            
            if(factible(x1,cantPiezas)){ // Agarrando un candidato vemos si es factible o no
                //La factibilidad seria la cantidad de piezas que trabaja el candidato es menor o igual a la actual
                int total = cantPiezas / x1.getCantidadPiezas();
                cantPiezas = cantPiezas - (x1.getCantidadPiezas() * total);
                //hace el calculo de cuantas veces se puede poner en funcionamiento ese candidato
                candidatos.put(x1, total);
            }

        }
        if(cantPiezas > 0){
               // Si no se pudo agregar ningun cadidato o no se llego a producir la cantidad total de piezas retornamos null
                return null;
            }else{ // Si la lista tiene al menos uno la devolvemos
                return candidatos;
        }

    }

    private boolean factible( Maquina x,int cantPiezas){ //Compara la cantidad de piezas que produce el candidato con la actual. Si es menor retorna true, sino, false.
        if(x.getCantidadPiezas() <= cantPiezas){
            return true;
        }
        return false;
    }
    private List<Maquina> ordenPorPiezas(List<Maquina> seleccionadas) { // Ordenamos de mayor a menor las maquinas por la cantidad de piezas que producen
        seleccionadas.sort(Comparator.comparingInt(Maquina::getCantidadPiezas).reversed());
    return seleccionadas;
    }

    public void mostrarResultado() {
        int piezasTotales = 0;
        System.out.println("Greedy");
        if (mejorCombinacion == null) {
            System.out.println("No se encontró una combinación posible.");
            return;
        }

        System.out.print("Solución obtenida (secuencia de máquinas): ");
        for (Map.Entry<Maquina, Integer> entry : mejorCombinacion.entrySet()) {
            Maquina m = entry.getKey();
            int veces = entry.getValue();
            for (int i = 0; i < veces; i++) {
                System.out.print(m.getNombre() + " ");
            }

            piezasTotales += m.getCantidadPiezas() * veces;
        }
        System.out.println();

        System.out.println("Cantidad de piezas producidas: " + piezasTotales);
        System.out.println("Cantidad de puestas en funcionamiento: " + mejorCombinacion.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("Estados generados (nodos explorados): " + estadosGenerados);
    }
}
