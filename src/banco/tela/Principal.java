package banco.tela;

import javax.swing.JOptionPane;

import banco.modelo.Cliente;
import banco.modelo.Conta;
import banco.modelo.PessoaFisica;
import banco.modelo.PessoaJuridica;

public class Principal {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        String tipoCliente = JOptionPane.showInputDialog(null, "Escolha o tipo de cliente:\n" +
                "F - Pessoa Física\nJ - Pessoa Jurídica");

        if (tipoCliente.equals("F")) {
            cliente = new PessoaFisica();
            ((PessoaFisica) cliente).setNome(JOptionPane.showInputDialog(null, "Nome do Cliente: "));
            ((PessoaFisica) cliente).setCpf(JOptionPane.showInputDialog(null, "CPF do Cliente: "));
        }
        else if (tipoCliente.equals("J")){
                cliente = new PessoaJuridica();
                ((PessoaJuridica)cliente).setRazaoSocial(JOptionPane.showInputDialog(null, "Razão Social: "));
                ((PessoaJuridica)cliente).setCnpj(JOptionPane.showInputDialog(null, "CNPJ do Cliente: "));
        }
        else {
                JOptionPane.showInputDialog(null, "OPÇÃO INVÁLIDA! Encerrando o programa...");
                return;
        }

        cliente.setCidade(JOptionPane.showInputDialog(null, "Cidade do Cliente: "));
        cliente.setEstado(JOptionPane.showInputDialog(null, "Estado do Cliente: "));

        JOptionPane.showInputDialog(null, "DADOS DO CLIENTE\n\n" +
                cliente.listarDados());

        Conta conta = new Conta(cliente);
        JOptionPane.showMessageDialog(null, "DADOS DA CONTA\n\n" +
                conta.listarDados());

        int opcao = 0;
        String ret;
        do {
            String mensagem = "SALDO EM CONTA: " + conta.getSaldoFormatado() + "\n\n" +
                    "OPÇÕES: \n1 - Depositar valor\n2 - Sacar valor\n3 - Finalizar";
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor do depósito:"));
                switch (opcao) {
                    case 1:
                        ret = JOptionPane.showInputDialog(null, "Valor do depósito:");
                        conta.depositar(Double.parseDouble(ret));
                        JOptionPane.showMessageDialog(null, "Depósito realizado!");
                        break;
                    case 2:
                        ret = JOptionPane.showInputDialog(null, "Valor do saque:");
                        if (conta.sacar(Double.parseDouble(ret))) {
                            JOptionPane.showMessageDialog(null, "Saque realizado!");
                            } else {
                            JOptionPane.showMessageDialog(null, "FALHA NO SAQUE!");
                            }
                        }
                } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "VALOR INVÁLIDO!");
                }
            } while ((opcao == 1) || (opcao == 2));
        }
}


