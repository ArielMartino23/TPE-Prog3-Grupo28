package tpe;

import java.util.*;
public class Backtracking {
    private List<Maquina> maquinas;
    private int cantPiezas;
    private List<Maquina> combinacionFinal;

    public Backtracking(List<Maquina> maquinas, int cantPiezas) {
        this.maquinas = maquinas;
        this.cantPiezas = cantPiezas;
        this.combinacionFinal = new ArrayList<>();
    }

    public List<Maquina> buscarCombinacion(){
        List<Maquina> combineta = new ArrayList<>();
        backtrack(maquinas, cantPiezas, combineta);
        return combinacionFinal;
    }

    public int getSiza(){
        return combinacionFinal.size();
    }

    private void backtrack(List<Maquina> maquinas, int cantPiezas, List<Maquina> inspeccionaMaquina){
        List<Maquina> minimasActual = new ArrayList<>();
        inspeccionaMaquina = new ArrayList<>();
        if(cantPiezas == 0){
            if(inspeccionaMaquina.size() > minimasActual.size()){
                minimasActual = inspeccionaMaquina;
                combinacionFinal = minimasActual;
            }  
            

        }else{
            for(Maquina maquina: maquinas){
                if(maquina.getCantidadPiezas() <= cantPiezas){
                    inspeccionaMaquina.add(maquina);
                    cantPiezas = cantPiezas - maquina.getCantidadPiezas();
                    backtrack(maquinas, cantPiezas, inspeccionaMaquina);
                    inspeccionaMaquina.remove(maquina);
                    cantPiezas = cantPiezas + maquina.getCantidadPiezas();
                }
            }
        }
    }
}   
