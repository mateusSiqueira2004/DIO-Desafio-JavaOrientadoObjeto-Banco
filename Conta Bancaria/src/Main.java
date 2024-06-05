import controllers.ControllerConta;
import java.math.BigDecimal;
import models.ModelCliente;

public class Main {

	public static void main(String[] args) {
		
		
		ModelCliente cliente = new ModelCliente("Vanilton", new BigDecimal(30.5));
		ControllerConta cc = new ControllerConta();
		cc.cadastrar(cliente);
		ModelCliente cliente2 = new ModelCliente("Robson", new BigDecimal(20));
		cc.cadastrar(cliente2);
		

		cc.visualizarTodos();
		
		
		
	}

}
