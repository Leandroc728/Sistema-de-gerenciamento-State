package ecommerce.estados;

import ecommerce.EstadoPedido;
import ecommerce.Pedido;

public class AguardandoPagamento implements EstadoPedido {
    @Override
    public void avancar(Pedido pedido) {
        System.out.println("-> Pagamento confirmado com sucesso. Preparando para envio.");
        pedido.setEstado(Pedido.PAGO);
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("-> Pedido cancelado pelo cliente antes do pagamento.");
        pedido.setEstado(Pedido.CANCELADO);
    }

    @Override
    public String obterStatus() { 
        return "Aguardando Pagamento"; 
    }
}