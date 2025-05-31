package tpe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Greedy {
    private List<Maquina> maquinas;
    private int cantPiezas;
    private List<Maquina> mejorCombinacion;
    //private int mejorCantidadMaquinas;
    private int estadosGenerados;

    public Greedy(List<Maquina> maquinas, int cantPiezas, List<Maquina> mejorCombinacion,
            int estadosGenerados) {
        this.maquinas = maquinas;
        this.cantPiezas = cantPiezas;
        this.mejorCombinacion = mejorCombinacion;
        //this.mejorCantidadMaquinas = mejorCantidadMaquinas;
        this.estadosGenerados = estadosGenerados;
    }

    public List<Maquina> aplicarGreedy(){
        mejorCombinacion = greedy(maquinas, cantPiezas);
        return mejorCombinacion;
    }

    private List<Maquina> greedy(List<Maquina> seleccionadas, int cantPiezas){
        
        List<Maquina> candidatos = new ArrayList<>();

        List<Maquina> maquinasOrdenadas = ordenPorPiezas(seleccionadas);

        
        while(!maquinasOrdenadas.isEmpty()){
            estadosGenerados++;
            Maquina x1 = maquinasOrdenadas.get(0);
            maquinasOrdenadas.remove(x1);
            
            if(factible(candidatos,x1,cantPiezas)){
                cantPiezas = cantPiezas - x1.getCantidadPiezas();
                candidatos.add(x1);
            }
        }
        if(candidatos.isEmpty()){
                return null;
            }else{
                return candidatos;
        }
    }

    private boolean factible(List<Maquina> seleccionadas, Maquina x,int cantPiezas){
        if(x.getCantidadPiezas() <= cantPiezas){
            return true;
        }
        return false;
    }
    private List<Maquina> ordenPorPiezas(List<Maquina> seleccionadas) {
        seleccionadas.sort(Comparator.comparingInt(Maquina::getCantidadPiezas).reversed());
    return seleccionadas;
    }

    public void mostrarResultado() {
        System.out.println("Greedy");
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
