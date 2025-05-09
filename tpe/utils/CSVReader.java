package tpe.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class CSVReader {

		public CSVReader() {
		}

	public void readMachines(String processorMachine, HashMap<String, Integer> machineMap) {
			
			// Obtengo una lista con las lineas del archivo
			// lines.get(0) tiene la primer linea del archivo
			// lines.get(1) tiene la segunda linea del archivo... y así
			ArrayList<String[]> lines = this.readContent(processorMachine);
			
			for(int i = 1;i < lines.size(); i++) {
                String[] line = lines.get(i);
				// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
				String nombre = line[0].trim();
                int cantidadPiezas = Integer.parseInt(line[1].trim());
				
				
			    //Maquina machine = new Maquina(nombre, cantidadPiezas);
		        // Guardar la tarea en el HashMap usando el id como clave
			    machineMap.put(nombre, cantidadPiezas);			
            }
		}

		private ArrayList<String[]> readContent(String path) {
			ArrayList<String[]> lines = new ArrayList<String[]>();

			File file = new File(path);
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				String line = null;
				while ((line = bufferedReader.readLine()) != null) {
					line = line.trim();
					lines.add(line.split(","));
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
		
		public int readPieces(String piecesPath) {
		    // Obtengo una lista con las lineas del archivo
		    // lines.get(0) tiene la primer linea del archivo
		    // lines.get(1) tiene la segunda linea del archivo... y así
		    ArrayList<String[]> lines = this.readContent(piecesPath);
		    
		    String[] line = lines.get(0);
            int cantidadPiezas = Integer.parseInt(line[0].trim());
            
            return cantidadPiezas;
		}
    }