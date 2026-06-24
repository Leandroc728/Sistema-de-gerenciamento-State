package ecommerce.estados;

import ecommerce.EstadoPedido;
import ecommerce.Pedido;

public class Cancelado implements EstadoPedido {
    @Override 
    public void avancar(Pedido pedido) { 
        System.out.println("\u001B[31m[ERRO] Pedidos cancelados não podem avançar no fluxo.\u001B[0m"); 
    }

    @Override 
    public void cancelar(Pedido pedido) { 
        System.out.println("\u001B[33m[AVISO] Este pedido já se encontra cancelado.\u001B[0m"); 
    }

    @Override 
    public String obterStatus() { 
        return "Cancelado"; 
    }
}