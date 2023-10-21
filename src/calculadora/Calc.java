package calculadora;

import javax.swing.JOptionPane;

public class Calc {

    public static void main(String[] args) {

        double valor1 = 0;
        double valor2 = 0;
        double soma, sub, mult, div;

        String valorStr;

        try {
            valorStr = JOptionPane.showInputDialog(null,"Informe o primeiro número:");
            valor1 = Double.parseDouble(valorStr);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número inválido. Considerando 0 para número 1.");
        }

        try {
            valorStr = JOptionPane.showInputDialog(null,"Informe o segundo número:");
            valor2 = Double.parseDouble(valorStr);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Número inválido. Considerando 0 para número 2.");
        }

        soma = valor1 + valor2;
        sub = valor1 - valor2;
        mult = valor1 * valor2;
        div = valor1 / valor2;

        StringBuilder resposta = new StringBuilder();
        resposta.append(valor1 + " + " + valor2 + " = " + soma + "\n");
        resposta.append(valor1 + " - " + valor2 + " = " + sub + "\n");
        resposta.append(valor1 + " * " + valor2 + " = " + mult + "\n");
        resposta.append(valor1 + " / " + valor2 + " = " + div + "\n");

        JOptionPane.showMessageDialog(null, resposta);

    }

}
