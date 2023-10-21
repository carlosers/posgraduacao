package forca.src.forca;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Principal {

	Forca forca = new Forca();
	
	JTextArea textoForca = new JTextArea();
	textoForca.setFont(new Font("Monospaced", Font.BOLD, 20));
	
	textoForca.setText(forca.getEstagioEnforcamento());
	String letra = JOptionPane.showInputDialog(null,textoForca);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
