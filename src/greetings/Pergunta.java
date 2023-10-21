package greetings;

import javax.swing.*;

public class Pergunta {
    public static void main(String[] args) {
        String nome;

        nome = JOptionPane.showInputDialog(null,"Qual é o seu nome?");
        JOptionPane.showMessageDialog(null,"Prazer em conhecê-lo(a), " + nome);

        double conta = 0;
        try{
            String valor = JOptionPane.showInputDialog(null,"Qual o valor da conta?");
            conta = Double.parseDouble(valor);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"VALOR INVÁLIDO! Digite novamente.");
        }
    }
}
