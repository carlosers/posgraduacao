package forca;

import java.util.Random;

public class Forca {

	private String[] palavras = new String[]{"JAVA","COMPILADOR","COMPUTADOR",
		"PRGRAMA","DUKE","ECLIPSE"};
	
	private String[] forcas = new String[7];
	
	private int erros;
	private int indicePalavraSorteada;
	}
	public Forca() {
		erros = 0;
		Random random = new Randow();
		indicePalavraSorteada = random.nextInt(palavras.length);
		
		forcas[0] = " ------ \n"
				  + " |    | \n"
				  + "      | \n"
				  + "      | \n"
				  + "      | \n"
				  + "     ===\n";
		
		forcas[1] = " ------ \n"
				  + " |    | \n"
				  + " O    | \n"
				  + "      | \n"
				  + "      | \n"
				  + "     ===\n";
		
		forcas[2] = " ------ \n"
				  + " |    | \n"
				  + " O    | \n"
				  + " |    | \n"
				  + "      | \n"
				  + "     ===\n";
		
		forcas[3] = " ------ \n"
				  + " |    | \n"
				  + " O    | \n"
				  + " |\\   | \n"
				  + "      | \n"
				  + "     ===\n";
		
		forcas[4] = " ------ \n"
				  + " |    | \n"
				  + " O    | \n"
				  + "/|\\   | \n"
				  + "      | \n"
				  + "     ===\n";
		
		forcas[5] = " ------ \n"
				  + " |    | \n"
				  + " O    | \n"
				  + "/|\\   | \n"
				  + "  \\   | \n"
				  + "     ===\n";
		
		forcas[6] = " ------ \n"
				  + " |    | \n"
				  + " O    | \n"
				  + "/|\\   | \n"
				  + "/ \\   | \n"
				  + "     ===\n";
				  
	}
	
	public String getEstagioEnforcamento() {
		return forcas[erros];

	}

}
