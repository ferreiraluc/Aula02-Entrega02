
import java.util.List;
import java.util.Scanner;

public class Relatorio {

    public static void gerarRelatorioClientes(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\n--- Relatório de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("Cliente " + (i + 1) + ":------------------------------------");
                System.out.println("Nome: " + clientes.get(i).getNome());

                List<Endereco> enderecos = clientes.get(i).getEnderecos();
                System.out.println("Endereços:");
                for (int j = 0; j < enderecos.size(); j++) {
                    System.out.println("  Endereço " + (j + 1) + ": " + enderecos.get(j).getRua() + ", Número: " + enderecos.get(j).getNumero());
                }
            }
        }
    }



    public static void gerarRelatorioPedidos(List<Pedido> pedidos) {
        System.out.println("\n--- Relatório de Pedidos ---");
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos em andamento.");
        } else {
            long pedidosEmAndamento = pedidos.stream().filter(pedido -> pedido.getStatus().equalsIgnoreCase("Em andamento")).count();
            long pedidosEncerrados = pedidos.stream().filter(pedido -> pedido.getStatus().equalsIgnoreCase("Encerrado" )).count();


            System.out.println("Quantidade de pedidos em andamento: " + pedidosEmAndamento);
            System.out.println("Quantidade de pedidos encerrados: " + pedidosEncerrados);

            // Exibir detalhes de cada pedido
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);
                System.out.println("Pedido " + (i + 1) + ": -------------------------------------------");
                System.out.println("Cliente: " + pedido.getCliente().getNome());
                System.out.println("Produtos: " + pedido.getProdutos());
                System.out.println("Valor Total: " + pedido.getValorTotal());
                System.out.println("Status: " + pedido.getStatus());
            }
        }
    }

}
