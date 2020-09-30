package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

	private String dataRoute = "./data/";

	private String[] documents;

	private String[] names;

	private double[] salaries;
	
	public void readFile(String file, int payrollLength) {

		String line = "";

		File f = new File(this.dataRoute+file);

		try {

			FileReader fr = new FileReader(f);

			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();

			documents = new String[payrollLength];

			names = new String[payrollLength];

			salaries = new double[payrollLength];

			int i = 0;

			while (line != null) {
				line = br.readLine();

				if (line != null) {

					String[] data = line.split(";");

					documents[i] = data[0].trim();

					names[i] = data[1].trim();

					salaries[i] = Double.parseDouble(data[2].trim());

					i++;

				}

			}

			fr.close();
		} catch (IOException e) {
			System.out.print(e);
		}
	}
	
	public void processPayroll(String[] files) {
		
		String payslipEntry;
		
		double netSalary;
			
		double taxRate=0;
		
		String fileName ="";
		
		// Delete all entries from files 
		
		for(int i = 0; i < files.length; i++) {
			this.fileWipe(files[i]);
		}
		
		
		for(int n = 0; n < this.documents.length; n++) {
			
			if (this.salaries[n] <= 2000) {taxRate = 0.10; fileName=files[0];}

			if (this.salaries[n] > 5000) {taxRate = 0.20; fileName=files[2];}

			if (this.salaries[n] > 2000 && this.salaries[n] <= 5000) {taxRate = 0.15; fileName=files[1];}
			
			netSalary = this.salaries[n] - (this.salaries[n] * taxRate);
			
			payslipEntry = this.documents[n].trim()+", "+netSalary+",";
			
			System.out.println(payslipEntry);
			
			this.generatePayslips(payslipEntry, fileName);
			
			this.generatePayslips(this.documents[n]+", "+this.names[n], files[3]);
			
		}


	}
	
	public void fileWipe(String fileName) {
		
		File f = new File(this.dataRoute+fileName);
		
		f.delete();
		
	}
	
	public boolean generatePayslips(String entry, String fileName) {

		File f = new File(this.dataRoute+fileName);
		
		try {
			
			f.createNewFile();
			
			FileWriter fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(entry);
			
			fw.close();
			
		} catch (IOException e) {
			
			System.out.println(e);
			
			return false;
		
		} 
		
		return true;

	}
	
}
