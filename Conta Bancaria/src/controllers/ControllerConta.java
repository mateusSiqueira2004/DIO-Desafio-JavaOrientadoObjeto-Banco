package controllers;

import interfaces.IConta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.ModelCliente;

public class ControllerConta implements IConta {
	
	public List<ModelCliente> clientes = new ArrayList<>();

	@Override
	public void sacar(int id, BigDecimal valor) {
		var conta = buscarNaCollection(id);

		if(conta != null){
			if(conta.sacar(valor) == true){
				System.out.println("Valor de "+ valor + " sacado com sucesso");
			}
		}else{
			System.out.println("Conta definida não encontrada");
		}
	}

	@Override
	public void cadastrar(ModelCliente cliente){
		clientes.add(cliente);
		System.out.println("cadastro realizado da conta" + cliente.getNumero() + " Cadastrada");
	}

	@Override
	public void depositar(int id, BigDecimal valor) {
		var conta = buscarNaCollection(id);

		if(conta != null){
			conta.setSaldo(valor);
		}
	}

	@Override
	public void transferir(BigDecimal valor, int contaOrigem, int contaDestino) {
		var idOrigem = buscarNaCollection(contaOrigem);
		var idDestino = buscarNaCollection(contaDestino);

		if(idOrigem != null && idDestino != null){
			if(idOrigem.sacar(valor) == true){
				idDestino.Depositar(valor);
				System.out.println("transferencia realizada com sucesso");
			}
		}
	}

	public void visualizarTodos(){
		for(ModelCliente conta : clientes){
			conta.imprimirInfosComuns();
		}
	}

	public ModelCliente buscarNaCollection(int numero) {
		for (ModelCliente conta : clientes) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
}
