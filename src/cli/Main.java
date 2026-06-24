package cli;

import java.util.Scanner;
import ecommerce.Pedido;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pedido meuPedido = new Pedido();

        limparTela();
        System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "    SISTEMA DE GERENCIAMENTO DE PEDIDOS" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);
        
        System.out.println(ANSI_GREEN + "\n[SISTEMA] Um novo pedido foi gerado na memória." + ANSI_RESET);
        meuPedido.exibirStatus();
        esperarEnter(scanner);

        boolean rodando = true;

        while (rodando) {
            limparTela();
            System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "         PAINEL DO E-COMMERCE" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "========================================" + ANSI_RESET);
            
            meuPedido.exibirStatus();
            
            System.out.println("\n--- AÇÕES DISPONÍVEIS ---");
            System.out.println(ANSI_GREEN + "1 - Avançar Próxima Etapa" + ANSI_RESET);
            System.out.println(ANSI_RED + "2 - Cancelar Pedido" + ANSI_RESET);
            System.out.println("3 - Reiniciar com Novo Pedido");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            String opcao = scanner.nextLine();
            limparTela();

            System.out.println(ANSI_CYAN + "--- RETORNO DO SISTEMA ---" + ANSI_RESET);
            switch (opcao) {
                case "1":
                    meuPedido.avancarPedido();
                    esperarEnter(scanner);
                    break;
                case "2":
                    meuPedido.cancelarPedido();
                    esperarEnter(scanner);
                    break;
                case "3":
                    meuPedido = new Pedido();
                    System.out.println(ANSI_GREEN + "Pedido anterior descartado. Novo pedido inicializado." + ANSI_RESET);
                    meuPedido.exibirStatus();
                    esperarEnter(scanner);
                    break;
                case "0":
                    System.out.println(ANSI_YELLOW + "Encerrando o sistema de e-commerce." + ANSI_RESET);
                    rodando = false;
                    break;
                default:
                    System.out.println(ANSI_RED + "Opção inválida. Selecione um número do menu." + ANSI_RESET);
                    esperarEnter(scanner);
            }
        }

        scanner.close();
    }

    private static void esperarEnter(Scanner scanner) {
        System.out.print("\n" + ANSI_CYAN + "[Pressione ENTER para continuar]" + ANSI_RESET);
        scanner.nextLine();
    }

    private static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}