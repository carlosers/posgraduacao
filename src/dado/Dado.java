package dado;

import javax.swing.*;

public class Dado {
    public static void main(String[] args) {

        int numeroSorteado = (int)((Math.random() * 6) + 1);
        JOptionPane.showMessageDialog(null,"Sua jogada: "+numeroSorteado);
    }

}
