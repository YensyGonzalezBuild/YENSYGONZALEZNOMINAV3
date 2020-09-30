package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {
	
	private Properties prop = new Properties();
	private String configRoute = "./data/Config.properties";

	public boolean setProperties() {
		
		File configFile = new File(configRoute);
		boolean exists = configFile.exists();
		
		if(!exists) {
			
			try {
				prop.setProperty("proyecto", "YENSYGONZALEZNOMINAV3");
				prop.setProperty("numeroArchivosSalida", "4");
				prop.setProperty("maximoRegistros", "26");
				prop.setProperty("archivoInterior", "nomina1.txt");
				prop.setProperty("archivoMedio", "nomina2.txt");
				prop.setProperty("archivoSuperior", "nomina3.txt");
				prop.setProperty("archivoMaestro", "maestro.txt");
				prop.setProperty("archivoNomina", "datosprincipales.csv");
				prop.setProperty("mensajeExito", "Su nomina fue procesada con exito!");
				
				prop.store(new FileOutputStream(configRoute), null);
			} 
			catch (IOException ex) {
				return false;
			}
			
		}
		
		return true;
	}	
	
	public Properties getProperties() {
		try {
			// leer el archivo de propiedades
		prop.load(new FileInputStream(configRoute));

		// obtener las propiedades definidas
		prop.list(System.out);
		
		} 
		catch (IOException ex) {
			return null;
		}
		return prop;
	}
	
}
