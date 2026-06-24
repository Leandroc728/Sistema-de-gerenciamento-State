package ecommerce.estados;

import ecommerce.EstadoPedido;
import ecommerce.Pedido;

public class Entregue implements EstadoPedido {
    @Override
    public void avancar(Pedido pedido) { 
        System.out.println("\u001B[33m[AVISO] O pedido já foi entregue e finalizado. Fim do fluxo.\u001B[0m"); 
    }

    @Override
    public void cancelar(Pedido pedido) { 
        System.out.println("\u001B[31m[ERRO] Impossível cancelar um pedido que já foi entregue ao cliente.\u001B[0m"); 
    }

    @Override
    public String obterStatus() { 
        return "Entregue"; 
    }
}