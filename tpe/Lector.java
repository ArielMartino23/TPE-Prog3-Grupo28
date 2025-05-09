package tpe;
import java.util.*;

import tpe.utils.CSVReader;
public class Lector {
    private List<Maquina> maquinas;
    private int piezas;

    public Lector(String pathEstructura){
        CSVReader reader = new CSVReader();
        this.maquinas = new ArrayList<>();

        this.piezas =  reader.readPieces(pathEstructura);
        reader.readMachines(pathEstructura, this.maquinas);
        /* despues metemos algoritmos */
    }

    public List<Maquina> obtenerMaquinas(){
        List<Maquina> retorno = new ArrayList<>();
            retorno.addAll(maquinas);

        return retorno;
    }

    public int obtenerPiezas(){
        return this.piezas;
    }
}
