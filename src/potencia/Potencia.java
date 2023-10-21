package potencia;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class Potencia {
    public static void main(String[] args) {
        double base = 0;
        double expoente = 0;
        double potencia;
        String sBase,sExpoente;

        try {
            sBase = JOptionPane.showInputDialog(null,"Digite o valor da base:");
            base = Double.parseDouble(sBase);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Valor digitado para a base é inválido.\nO programa será fechado por este motivo.");
        }

        try {
            sExpoente = JOptionPane.showInputDialog(null,"Digite um para valor para o expoente:");
            expoente = Double.parseDouble(sExpoente);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Valor digitado para o expoente é inválido.\nO programa será fechado por este motivo.");
        }

        potencia = Math.pow(base,expoente);
        JOptionPane.showMessageDialog(null,base+" elevado a "+expoente+" é igual a "+potencia);
    }
}
