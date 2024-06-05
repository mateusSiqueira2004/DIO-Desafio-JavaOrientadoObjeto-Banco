package interfaces;
import java.math.BigDecimal;
import models.ModelCliente;
public interface IConta {
	
	void sacar(int id,BigDecimal valor);
	
	void depositar(int id, BigDecimal valor);

	void cadastrar(ModelCliente cliente);
	
	void transferir(BigDecimal valor, int contaOrigem, int contaDestino);
	
	
}
