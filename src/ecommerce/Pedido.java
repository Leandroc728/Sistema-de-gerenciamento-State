package ecommerce;

import ecommerce.estados.*;

public class Pedido {
    public static final EstadoPedido AGUARDANDO = new AguardandoPagamento();
    public static final EstadoPedido PAGO = new Pago();
    public static final EstadoPedido ENVIADO = new Enviado();
    public static final EstadoPedido ENTREGUE = new Entregue();
    public static final EstadoPedido CANCELADO = new Cancelado();

    private EstadoPedido estadoAtual;

    public Pedido() {
        this.estadoAtual = AGUARDANDO;
    }

    public void setEstado(EstadoPedido novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public void avancarPedido() {
        estadoAtual.avancar(this);
    }

    public void cancelarPedido() {
        estadoAtual.cancelar(this);
    }

    public void exibirStatus() {
        System.out.println(" Status Atual: " + estadoAtual.obterStatus());
    }

    public EstadoPedido getEstadoAtual() {
        return this.estadoAtual;
    }
}