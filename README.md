# Gerenciador de Estados de Pedidos (E-commerce) — Padrão State

Este projeto é uma implementação prática desenvolvida para a avaliação de Padrões de Projeto GoF da disciplina de Tópicos Especiais em Sistemas de Informação. O objetivo é demonstrar a aplicação do padrão de projeto comportamental State de forma limpa e compreensível, utilizando um cenário clássico: o ciclo de vida e o gerenciamento de estados de um pedido de e-commerce.
---

## Objetivo do Projeto

Sistemas de e-commerce tradicionais costumam sofrer com acúmulo de estruturas condicionais (`if/else` ou `switch/case`) para validar se uma ação (como cancelar ou despachar) é permitida no estado atual do pedido. 

O padrão **State** resolve esse problema encapsulando os comportamentos específicos de cada fase em classes isoladas. Com isso, o objeto `Pedido` delega dinamicamente a execução de suas ações para a instância do estado em que se encontra, alterando seu comportamento em tempo de execução sem violar o princípio de Responsabilidade Única (SRP).

---
## Escopo

O escopo do projeto consiste em uma aplicação interativa construída nativamente em Java para rodar via linha de comando (CLI). A simulação restringe-se a gerenciar a transição de estados de um único pedido (Aguardando Pagamento ➔ Pago ➔ Enviado ➔ Entregue) com base nas interações do usuário e regras de negócio.

A arquitetura foi desenhada para priorizar a engenharia de software rigorosa:
* **Sem condicionais complexas:** Remoção total de estruturas `if/else` ou `switch/case` longas para controle e validação do comportamento do pedido.

## Funcionamento

O sistema opera delegando as ações do pedido para a classe que representa o seu momento atual no fluxo de gerenciamento. O funcionamento técnico divide-se em:

* **Contexto (Pedido):** A classe principal com a qual o usuário interage. Ela mantém uma referência para a interface do estado ativo e gerencia a troca de estados através das constantes centralizadas.
* **Interface (EstadoPedido):** Define as regras, transições e ações que todo estado de pedido deve obrigatoriamente possuir (ex: `avancar()`, `cancelar()`).
* **Estados Concretos (AguardandoPagamento, Pago, Enviado, Entregue, Cancelado):** Cada classe define quais ações são permitidas naquele estágio. Por exemplo, se o método `cancelarPedido()` for chamado enquanto o estado for `Enviado`, a própria classe do estado barra a ação e dispara uma mensagem de erro, protegendo as regras de negócio.

## Compilação e Execução

Compile os arquivos (na raiz do projeto):
```bash
javac -d bin src/ecommerce/*.java src/ecommerce/estados/*.java src/cli/*.java

```

Execute o programa:

```bash
java -cp bin cli.Main
```

## Ações

As ações presentes na CLI são:
1. **Avançar Próxima Etapa**: Modifica o estado do pedido para a próxima fase lógica do e-commerce se a transição for permitida.
2. **Cancelar Pedido**: Tenta cancelar o pedido (permitido apenas nas fases iniciais e bloqueado se o produto já tiver sido enviado ou entregue).
3. **Reiniciar com Novo Pedido**: Descarta o fluxo atual e inicializa um novo pedido no estado zero para novos testes.
0. **Sair**: Encerra o sistema.

---

Feita como trabalho para a disciplina "Tópicos Especiais em Sistemas de Informação"