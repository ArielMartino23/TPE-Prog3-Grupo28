package tpe;
import java.util.*;

import tpe.utils.CSVReader;
public class Lector {
    private HashMap<String, Maquina> maquinas;
    private int piezas;

    public Lector(String pathEstructura){
        CSVReader reader = new CSVReader();
        this.maquinas = new HashMap<>();

        this.piezas =  reader.readPieces(pathEstructura);
        reader.readMachines(pathEstructura, this.maquinas);
        /* despues metemos algoritmos */
    }

    public HashMap<String, Maquina> obtenerMaquinas(){
        HashMap<String, Maquina> retorno = new HashMap<>();
            retorno.putAll(maquinas);

        return retorno;
    }

    public int obtenerPiezas(){
        return this.piezas;
    }
}
