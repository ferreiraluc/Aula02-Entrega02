import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        scanner.nextLine();

        if (numCliente >= 1 && numCliente <= clientes.size()) {
            Cliente clienteSelecionado = clientes.get(numCliente - 1);

            System.out.println("Digite a quantidade de produtos do pedido:");
            int qtdProdutos = scanner.nextInt();
            scanner.nextLine();

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

    public static void controlarStatusPedido(List<Pedido> pedidos, Scanner scanner) throws IOException {
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

                if (novoStatus.equalsIgnoreCase("Encerrado")) {
                    String filename = "pedido" + numPedido + ".txt";

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                        for (Pedido pedido : pedidos) {
                            writer.write("Pedido " + pedido + ": -------------------------------------------");
                            writer.newLine();
                            writer.write("Cliente: " + pedido.getCliente().getNome());
                            writer.newLine();
                            writer.write("Endereco: " + pedido.getCliente().getEnderecos());
                            writer.newLine();
                            writer.write("Produtos: " + pedido.getProdutos());
                            writer.newLine();
                            writer.write("Valor Total: " + pedido.getValorTotal());
                            writer.newLine();
                            writer.newLine(); // Add an extra newline to separate the next "Pedido"
                        }
                        System.out.println("Pedidos gravados com sucesso!");
                    } catch (IOException e) {
                        System.err.println("Erro ao gravar os pedidos no arquivo: " + e.getMessage());
                    }
                }


                pedidoSelecionado.setStatus(novoStatus); // Alterando o status do pedido

                System.out.println("Status do pedido atualizado com sucesso!");

            } else {
                System.out.println("Número de pedido inválido.");
            }
        }
    }


}
