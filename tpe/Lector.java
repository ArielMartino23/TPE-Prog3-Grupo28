package tpe;
import java.util.*;

import tpe.utils.CSVReader;

/*
*Esta clase se encarga de leer el archivo CSV y de esta forma se crean y se guardan las maquinas y las piezas que
* vamos a trabajar
 */
public class Lector {
    private List<Maquina> maquinas;
    private int piezas;

    public Lector(String pathEstructura){
        CSVReader reader = new CSVReader();
        this.maquinas = new ArrayList<>();

        this.piezas =  reader.readPieces(pathEstructura);
        reader.readMachines(pathEstructura, this.maquinas);
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
