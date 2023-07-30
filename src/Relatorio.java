import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Relatorio {

    public static void gerarRelatorioClientes(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\n--- Relatório de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("Cliente " + (i + 1) + ":");
                System.out.println("Nome: " + clientes.get(i).getNome());

                List<Endereco> enderecos = clientes.get(i).getEnderecos();
                System.out.println("Endereços:");
                for (int j = 0; j < enderecos.size(); j++) {
                    System.out.println("  Endereço " + (j + 1) + ": " + enderecos.get(j).getRua() + ", Número: " + enderecos.get(j).getNumero());
                }
            }
        }
    }

    public static void removerCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\n--- Remover Cliente ---");
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados para remover.");
        } else {
            System.out.println("Digite o número do cliente que deseja remover:");
            int numCliente = scanner.nextInt();
            if (numCliente >= 1 && numCliente <= clientes.size()) {
                clientes.remove(numCliente - 1);
                System.out.println("Cliente removido com sucesso.");
            } else {
                System.out.println("Número de cliente inválido.");
            }
        }
    }

    public static void editarEnderecoCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\n--- Editar Endereço do Cliente ---");
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados para editar endereço.");
        } else {
            System.out.println("Digite o número do cliente cujo endereço deseja editar:");
            int numCliente = scanner.nextInt();
            if (numCliente >= 1 && numCliente <= clientes.size()) {
                scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()
                System.out.println("Digite a quantidade de endereços: ");
                int qtdEndereco = scanner.nextInt();
                scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()

                List<Endereco> enderecos = new ArrayList<>();
                for (int j = 0; j < qtdEndereco; j++) {
                    System.out.println("Digite o endereço:");
                    String rua = scanner.nextLine();
                    System.out.println("Digite o número do endereço:");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()
                    enderecos.add(new Endereco(rua, numero));
                }

                clientes.get(numCliente - 1).setEnderecos(enderecos);
                System.out.println("Endereço do cliente editado com sucesso.");
            } else {
                System.out.println("Número de cliente inválido.");
            }
        }
    }

    public static void gerarRelatorioPedidos(List<Pedido> pedidos) {
        System.out.println("\n--- Relatório de Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos em andamento.");
        } else {
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println("Pedido " + (i + 1) + ":");
                System.out.println("Cliente: " + pedido.getCliente().getNome());
                System.out.println("Produtos: " + pedido.getProdutos());
                System.out.println("Valor Total: " + pedido.getValorTotal());
            }
        }
    }
}
