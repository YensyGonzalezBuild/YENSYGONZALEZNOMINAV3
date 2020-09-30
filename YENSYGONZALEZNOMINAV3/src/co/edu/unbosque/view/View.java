package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	public String inputData() 
	{
		return (JOptionPane.showInputDialog(null,"Ingrese un dato","Titulo del InputDialog",JOptionPane.INFORMATION_MESSAGE));
	}


	public void outputData(String data, String title) 
	{
		JOptionPane.showMessageDialog(null, data, title, JOptionPane.INFORMATION_MESSAGE);
	}

}
