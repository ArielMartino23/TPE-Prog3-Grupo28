package tpe.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import tpe.Maquina;
public class CSVReader {

		public CSVReader() {
		}

	public void readMachines(String processorMachine, List<Maquina> machineList) { // Lee las Maquinas
			// Obtengo una lista con las lineas del archivo
			// lines.get(0) tiene la primer linea del archivo
			// lines.get(1) tiene la segunda linea del archivo... y así
			ArrayList<String[]> lines = this.readContent(processorMachine);
			
			for(int i = 1;i < lines.size(); i++) {
                String[] line = lines.get(i);
				// Cada linea es un arreglo de Strings (dividos por una coma), donde cada posicion guarda un elemento
				String nombre = line[0].trim();
                int cantidadPiezas = Integer.parseInt(line[1].trim());
				
				//Crear un elemento de tipo maquina con los parametros traidos desde el CSV
			    Maquina machine = new Maquina(nombre, cantidadPiezas);
		        //Guardar la Maquina(machine) en la lista de Maquinas
			    machineList.add(machine);			
            }
		}

		private ArrayList<String[]> readContent(String path) {
			ArrayList<String[]> lines = new ArrayList<String[]>();

			File file = new File(path);//Se crea un objeto File que representa el archivo en la ruta dada.
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader(file); // Lee las lineas del archivo
				bufferedReader = new BufferedReader(fileReader); // Lee las lineas del archivo de forma eficiente
				String line = null;
				while ((line = bufferedReader.readLine()) != null) { // Se lee cada linea del archivo mientras no sea null
					line = line.trim(); // Se aplica trim() para eliminar espacios en blaco al principio y al final
					lines.add(line.split(",")); // Se hace split(",") para dividir la linea en partes usando la coma como separador y se agrega el arreglo de partes a la lista lines
				}
			} catch (Exception e) {
				e.printStackTrace();
				if (bufferedReader != null)
					try {
						bufferedReader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
			
			return lines;
		}
		
		public int readPieces(String piecesPath) { //Lee las piezas
		    // Obtengo una lista con las lineas del archivo
		    // lines.get(0) tiene la primer linea del archivo
		    // lines.get(1) tiene la segunda linea del archivo... y así
		    ArrayList<String[]> lines = this.readContent(piecesPath);
		    
		    String[] line = lines.get(0);
            int cantidadPiezas = Integer.parseInt(line[0].trim());
            
            return cantidadPiezas;
		}
    }