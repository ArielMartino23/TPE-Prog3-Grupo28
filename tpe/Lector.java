package tpe;
import java.util.*;

import tpe.utils.CSVReader;
public class Lector {
    private HashMap<String, Integer> maquinas;
    private int piezas;

    public Lector(String pathEstructura){
        CSVReader reader = new CSVReader();
        this.maquinas = new HashMap<>();

        this.piezas =  reader.readPieces(pathEstructura);
        reader.readMachines(pathEstructura, this.maquinas);
        /* despues metemos algoritmos */
    }

    public HashMap<String, Integer> obtenerMaquinas(){
        HashMap<String, Integer> retorno = new HashMap<>();
            retorno.putAll(maquinas);

        return retorno;
    }

    public int obtenerPiezas(){
        return this.piezas;
    }
}
