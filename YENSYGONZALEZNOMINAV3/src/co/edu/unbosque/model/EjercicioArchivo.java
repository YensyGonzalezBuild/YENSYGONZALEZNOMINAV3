package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.FileManager;

import co.edu.unbosque.model.persistence.PropertiesManager;
import co.edu.unbosque.view.View;

import java.io.*;
import java.util.Properties;

public class EjercicioArchivo{
	
	private View gui;
	
	private PropertiesManager propertiesManager;
	
	private FileManager filesManager;
	
	private Properties properties;
	
	private String ProjectName;
	
	private int FileOutputCount;
	
	private int EmployeeCount;
	
	private String[] Files;
	
	private String RawPayroll;
	
	private String SuccessMessage;
	
	public void gestionarArchivoCadena() {
		
		//Basic Declarations
		
		this.propertiesManager = new PropertiesManager();
		
		this.filesManager = new FileManager();
		
		this.gui = new View();
		
		//Get Attributes
		
		this.propertiesManager.setProperties();
		
		this.properties = this.propertiesManager.getProperties();
		
		//Set Basic Attributes
		
		this.ProjectName = this.properties.getProperty("proyecto");
		
		this.FileOutputCount = Integer.parseInt(this.properties.getProperty("numeroArchivosSalida"));
		
		this.EmployeeCount = Integer.parseInt(this.properties.getProperty("maximoRegistros"));
		
		this.RawPayroll = this.properties.getProperty("archivoNomina");
		
		this.SuccessMessage = this.properties.getProperty("mensajeExito");
		
		//Set File Routes
		
		this.Files = new String[this.FileOutputCount];
		
		this.Files[0] = this.properties.getProperty("archivoInterior");
		
		this.Files[1] = this.properties.getProperty("archivoMedio");
		
		this.Files[2] = this.properties.getProperty("archivoSuperior");
		
		this.Files[3] = this.properties.getProperty("archivoMaestro");
		
		//Show Messages
		
		System.out.println("Starting software -"+this.ProjectName+" - Processing Company Payroll");
		
		//Process Payroll
		
		this.filesManager.readFile(this.RawPayroll, this.EmployeeCount);
		
		this.filesManager.processPayroll(this.Files);
		
		this.gui.outputData(this.SuccessMessage, "Run Complete");
		
	}
	
}



