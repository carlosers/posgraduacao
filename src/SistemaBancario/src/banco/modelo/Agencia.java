package SistemaBancario.src.banco.modelo;

import banco.modelo.Conta;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

	private int numero;
	private String nome;
	private List<banco.modelo.Conta> contas;
	
	public Agencia(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
		contas = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<banco.modelo.Conta> getContas(){
		return contas;
	}
	
	public void incluirConta(banco.modelo.Conta conta) {
		contas.add(conta);
	}
	
	public void excluirConta(Conta conta) {
		contas.remove(conta);
	}
}
