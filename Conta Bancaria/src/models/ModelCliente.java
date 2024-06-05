package models;

import java.math.BigDecimal;

public class ModelCliente {
    private String nome;
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	private int agencia, numero;
	private BigDecimal saldo;

	

	public ModelCliente(String nome, BigDecimal saldo) {
		this.nome = nome;
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL ++;
		this.saldo = saldo;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(BigDecimal valor) {
		if (this.saldo.compareTo(valor) < 0) {
			System.out.println("Saldo insuficiente");
			return false;
		}
		this.setSaldo(this.saldo.subtract(valor));
		return true;
	}

	public void Depositar(BigDecimal valor){
		this.setSaldo(this.saldo.add(valor));
	}

	public void imprimirInfosComuns() {
		
		System.out.println(String.format("\n\nTitular: %s", this.getNome()));
		System.out.println(String.format("Agencia: %d", this.getAgencia()));
		System.out.println(String.format("Numero: %d", this.getNumero()));
		System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
	}
}
