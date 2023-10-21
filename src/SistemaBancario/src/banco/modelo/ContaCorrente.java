package SistemaBancario.src.banco.modelo;

import banco.modelo.Cliente;
import banco.modelo.Conta;
import banco.modelo.PessoaFisica;

import java.text.DecimalFormat;

public class ContaCorrente extends Conta {

	private double limite;
	private double juros;
	
	public ContaCorrente(banco.modelo.Cliente cliente) {
		super(cliente);
		limite = 1000;
		juros = 5.9;
	}
	
	public ContaCorrente(Cliente cliente, double limite, double juros) {
		super(cliente);
		this.limite = limite;
		this.juros = juros;
	}
    
    @Override
    public String getSaldoFormatado() {
    	return DecimalFormat.getCurrencyInstance().format(saldo + limite);
    }
    
    @Override
	public boolean sacar(double valor) {
		
		if(saldo+limite >= valor) {
			saldo -= valor;
			return true;
		} else {
			return false;
		}
	}
    
    @Override
    public String listarDados() {
    	String nome;
    	if(cliente instanceof banco.modelo.PessoaFisica) {
    		nome = ((PessoaFisica)cliente).getNome();
    	} else {
    		nome = ((PessoaJuridica)cliente).getRazaoSocial();
    	}
    	return 	"NUMERO: "+ numero+"\n"+
    			"CORRENTISTA: "+ nome+"\n"+
    			"SALDO:"+ DecimalFormat.getCurrencyInstance().format(saldo+limite);
    }
    
    public void aplicarJuros() {
		saldo += (this.limite + (this.limite * juros/100));  
	}

}
