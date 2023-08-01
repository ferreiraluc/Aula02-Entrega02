import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCadastro {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            mostrarMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuClientes(clientes, scanner);
                    break;
                case 2:
                    menuPedidos(clientes, pedidos, scanner);
                    break;
                case 3:
                    menuRelatorios(clientes, pedidos, scanner);
                    break;
                case 4:
                    // EMITIR TXT
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.print("##------------Menu-----------##\n\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("| Opção 1 - Clientes          |\n");
        System.out.print("| Opção 2 - Pedidos           |\n");
        System.out.print("| Opção 3 - Relatórios        |\n");
        System.out.print("| Opção 4 - EMITIR TXT        |\n");
        System.out.print("| Opção 5 - Sair              |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite uma opção: ");
    }

    public static void menuClientes(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\n##--- Clientes ---##");
        System.out.println("|-----------------------------|");
        System.out.println("| 1 - Cadastrar Cliente       |");
        System.out.println("| 2 - Remover Cliente         |");
        System.out.println("| 3 - Editar Cliente          |");
        System.out.println("| 4 - Listar Clientes         |");
        System.out.println("|-----------------------------|");
        System.out.print("Digite uma opção: ");
        int opcaoClientes = scanner.nextInt();
        switch (opcaoClientes) {
            case 1:
                RealizarCadastro rc = new RealizarCadastro();
                rc.realizarCadastro(clientes, scanner);
                break;
            case 2:
                RealizarCadastro.removerCliente(clientes, scanner);
                break;
            case 3:
                Relatorio.gerarRelatorioClientes(clientes, scanner);
                RealizarCadastro.editarEnderecoCliente(clientes, scanner);
                break;
            case 4:
                Relatorio.gerarRelatorioClientes(clientes, scanner);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void menuRelatorios(List<Cliente> clientes, List<Pedido> pedidos, Scanner scanner) {
        System.out.println("\n##--- Menu de Relatórios ---##");
        System.out.println("|-----------------------------|");
        System.out.println("| 1 - Relatório de Clientes   |");
        System.out.println("| 2 - Relatório de Pedidos    |");
        System.out.println("|-----------------------------|");
        System.out.print("Digite uma opção: ");
        int opcaoRelatorio = scanner.nextInt();
        switch (opcaoRelatorio) {
            case 1:
                Relatorio.gerarRelatorioClientes(clientes, scanner);
                break;
            case 2:
                Relatorio.gerarRelatorioPedidos(pedidos);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void menuPedidos(List<Cliente> clientes, List<Pedido> pedidos, Scanner scanner) {
        System.out.println("\n##--- Menu de Pedidos ---##");
        System.out.println("|-----------------------------|");
        System.out.println("| 1 - Realizar Pedido         |");
        System.out.println("| 2 - Editar Status do Pedido |");
        System.out.println("| 3 - Listar Pedidos          |");
        System.out.println("|-----------------------------|");
        System.out.print("Digite uma opção: ");
        int opcaoPedidos = scanner.nextInt();
        switch (opcaoPedidos) {
            case 1:
                RealizarPedido.realizarPedido(clientes, pedidos, scanner);
                break;
            case 2:
                RealizarPedido.controlarStatusPedido(pedidos, scanner);
                break;
            case 3:
                Relatorio.gerarRelatorioPedidos(pedidos);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}
