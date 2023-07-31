import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealizarPedido {

    public static void realizarPedido(List<Cliente> clientes, List<Pedido> pedidos, Scanner scanner) {
        System.out.println("\n--- Realizar Pedido ---");

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados. O pedido não pode ser realizado.");
            return;
        }

        System.out.println("Lista de clientes disponíveis:");

        // Exibindo lista de clientes para o usuário selecionar
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }

        System.out.println("Digite o número do cliente que deseja associar ao pedido:");
        int numCliente = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()

        if (numCliente >= 1 && numCliente <= clientes.size()) {
            Cliente clienteSelecionado = clientes.get(numCliente - 1);

            System.out.println("Digite a quantidade de produtos do pedido:");
            int qtdProdutos = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()

            List<String> produtos = new ArrayList<>();
            for (int i = 0; i < qtdProdutos; i++) {
                System.out.println("Digite o nome do produto " + (i + 1) + ":");
                String produto = scanner.nextLine();
                produtos.add(produto);
            }

            System.out.println("Digite o valor total do pedido:");
            double valorTotal = scanner.nextDouble();

            // Criando o pedido e associando ao cliente
            Pedido novoPedido = new Pedido(clienteSelecionado, produtos, valorTotal);
            pedidos.add(novoPedido);

            System.out.println("Pedido realizado com sucesso!");

        } else {
            System.out.println("Número de cliente inválido.");
        }
    }

    public static void controlarStatusPedido(List<Pedido> pedidos, Scanner scanner) {
        System.out.println("\n--- Controlar Status do Pedido ---");
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos em andamento.");
        } else {
            // Código existente para exibir lista de pedidos

            System.out.println("Digite o número do pedido cujo status deseja controlar:");
            int numPedido = scanner.nextInt();
            scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()

            if (numPedido >= 1 && numPedido <= pedidos.size()) {
                Pedido pedidoSelecionado = pedidos.get(numPedido - 1);

                System.out.println("Digite o novo status do pedido:");
                String novoStatus = scanner.nextLine();

                pedidoSelecionado.setStatus(novoStatus); // Alterando o status do pedido

                System.out.println("Status do pedido atualizado com sucesso!");

            } else {
                System.out.println("Número de pedido inválido.");
            }
        }
    }


}
