package ecommerce.estados;

import ecommerce.EstadoPedido;
import ecommerce.Pedido;

public class Enviado implements EstadoPedido {
    @Override
    public void avancar(Pedido pedido) {
        System.out.println("-> O cliente assinou o recebimento. Pedido finalizado!");
        pedido.setEstado(Pedido.ENTREGUE);
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("\u001B[31m[ERRO] Não é possível cancelar. O produto já está com a transportadora.\u001B[0m");
    }

    @Override
    public String obterStatus() { 
        return "Enviado / Em Trânsito"; 
    }
}