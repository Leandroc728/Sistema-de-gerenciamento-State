package ecommerce.estados;

import ecommerce.EstadoPedido;
import ecommerce.Pedido;

public class Pago implements EstadoPedido {
    @Override
    public void avancar(Pedido pedido) {
        System.out.println("-> Nota fiscal emitida. O produto foi despachado para a transportadora.");
        pedido.setEstado(Pedido.ENVIADO);
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("-> Estornando o valor no cartão. Pedido cancelado após o pagamento.");
        pedido.setEstado(Pedido.CANCELADO);
    }

    @Override
    public String obterStatus() { 
        return "Pago / Pronto para Envio"; 
    }
}