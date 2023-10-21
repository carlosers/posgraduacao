package SistemaBancario.src.banco.tela;

import javax.swing.JOptionPane;

import SistemaBancario.src.banco.modelo.Agencia;
import SistemaBancario.src.banco.modelo.Cliente;
import SistemaBancario.src.banco.modelo.Conta;
import SistemaBancario.src.banco.modelo.ContaCorrente;
import SistemaBancario.src.banco.modelo.ContaPoupanca;
import SistemaBancario.src.banco.modelo.PessoaFisica;
import SistemaBancario.src.banco.modelo.PessoaJuridica;

public class Principal {

	public static void main(String[] args) {
		
		Agencia agencia = new Agencia(1, "S�o Paulo - Centro");
		String opcaoPrincipal="";
		int aniversario = 10;
		double rendimento = 5;
		
		do {
			opcaoPrincipal = JOptionPane.showInputDialog(null, "Cadastro de Contas para a ag�ncia "
					+ agencia.getNumero()+" - "+agencia.getNome()+"\n"
					+ "\nOP��ES:\n"
					+ "1 - Incluir cliente e conta\n"
					+ "2 - Listar cntas cadastradas\n"
					+ "3 - Sair do sistema");
			
			if(opcaoPrincipal.equals("1")) {
				
				Cliente cliente = new Cliente();
				String tipoCliente = JOptionPane.showInputDialog(null,"Escolha o tipo de cliente:\n"+
						"F - Pessa F�sica\nJ - Pessoa Jur�dica");
				
				if(tipoCliente.equals("F")) {
					cliente = new PessoaFisica();
					((PessoaFisica)cliente).setNome(JOptionPane.showInputDialog(null,"Nome do Cliente:"));
					((PessoaFisica)cliente).setCpf(JOptionPane.showInputDialog(null,"CPF do Cliente:"));
				} else if (tipoCliente.equals("J")) {
					cliente = new PessoaJuridica();
					((PessoaJuridica)cliente).setRazaoSocial(JOptionPane.showInputDialog(null,"Raz�o Social: "));
					((PessoaJuridica)cliente).setCnpj(JOptionPane.showInputDialog(null,"CNPJ do Cliente:"));
				} else {
					JOptionPane.showInputDialog(null,"OP��O INV�LIDA!Encerrando o programa...");
					return;
				}
				
				cliente.setCidade(JOptionPane.showInputDialog(null,"Cidade do Cliente"));
				cliente.setEstado(JOptionPane.showInputDialog(null,"Estado do Cliente"));
				
				JOptionPane.showMessageDialog(null, "DADOS DO CLIENTE\n\n"+
						cliente.listarDados());
				
				Conta conta;
				
				String tipoConta = JOptionPane.showInputDialog(null,"Tipo de conta a ser criada:\n"+
						"C - Conta Corrente\nP - Conta Poupan�a");
				if(tipoConta.equals("P")) {
					conta = new ContaPoupanca(cliente,aniversario,rendimento);
				} else {
					conta = new ContaCorrente(cliente);
				}
				
				agencia.incluirConta(conta);
				
				JOptionPane.showMessageDialog(null, "DADOS DO CONTA\n\n"+
						cliente.listarDados());
				
				int opcao = 0;
				String ret;
				
				do {
					String mensagem = "SALDO EM CONTA: "+ conta.getSaldoFormatado()+ "\n\n"+
							"OP��ES: \n1 - Depositar valor\n2 - Sacar valor\n3 - Saldo\n4 - Finalizar";
					try {
						opcao = Integer.parseInt(JOptionPane.showInputDialog(null,mensagem));
						switch (opcao) {
						case 1:
							ret = JOptionPane.showInputDialog(null,"Valor do dep�sito");
							conta.depositar(Double.parseDouble(ret));
							JOptionPane.showMessageDialog(null, "Dep�sito realizado!");
							break;
						case 2:
							ret = JOptionPane.showInputDialog(null,"Valor do saque:");
							if (conta.sacar(Double.parseDouble(ret))) {
								JOptionPane.showMessageDialog(null, "Saque realizado!");
							} else {
								JOptionPane.showMessageDialog(null, "FALHA NO SAQUE!");
							}
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "VALOR INV�LIDO!");
					}
				} while ((opcao ==1)||(opcao==2));
			
			} else if (opcaoPrincipal.equals("2")) {
				
				if(agencia.getContas().size()==0) {
					JOptionPane.showMessageDialog(null, "N�O H� CONTAS CADASTRADAS NO MOMENTO.");
				} else {
					JOptionPane.showMessageDialog(null, "A Ag�ncia "+agencia.getNumero()+" - "
							+agencia.getNome()+" possui "+agencia.getContas().size()
							+"conta(s). \n\nVeja quais s�o nas pr�ximas telas");
				
					for(Conta umaConta:agencia.getContas()) {
						JOptionPane.showMessageDialog(null, umaConta.listarDados());
					}
				}
			}
		}while((opcaoPrincipal.equals("1"))||(opcaoPrincipal.equals("2")));
		
	}
}	