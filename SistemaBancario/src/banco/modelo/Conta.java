package banco.modelo;

import java.text.DecimalFormat;

public class Conta {

	protected int numero;
	protected Cliente cliente;
	protected double saldo;
	
	private static int contador;
	
	public Conta(Cliente cliente) {
		contador++;
		numero = contador;
		this.cliente = cliente;
	}

	public String getSaldoFormatado() {
		return DecimalFormat.getCurrencyInstance().format(saldo);
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public boolean sacar(double valor) {
		if (saldo>= valor) {
			saldo -= valor;
			return true;
			
		} else {
			return false;
		}
	}
	
	public String listarDados() {
		String nome;
		if(cliente instanceof PessoaFisica) {
			nome = ((PessoaFisica)cliente).getNome();
		} else {
			nome = ((PessoaJuridica)cliente).getRazaoSocial();
		}
		return "NÚMERO: "+numero+"\n"+
		"CORRENTISTA: "+nome+"\n"+
		"SALDO: "+DecimalFormat.getCurrencyInstance().format(saldo);
	}
}
