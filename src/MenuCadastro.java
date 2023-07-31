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
            System.out.print("##------------Menu-----------##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Clientes |\n");
            System.out.print("| Opção 2 - Pedidos   |\n");
            System.out.print("| Opção 3 -      |\n");
            System.out.print("| Opção 4 -    |\n");
            System.out.print("| Opção 5 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n##--- Clientes ---##");
                    System.out.println("|-----------------------------|");
                    System.out.println("| 1 - Cadastrar Cliente   |");
                    System.out.println("| 2 - Remover Cliente    |");
                    System.out.println("| 3 - Editar Cliente    |");
                    System.out.println("| 4 - Listar Clientes    |");
                    System.out.println("|-----------------------------|");
                    System.out.print("Digite uma opção: ");
                    int opcaoClientes = scanner.nextInt();
                    switch (opcaoClientes) {
                        case 1:
                            RealizarCadastro rc = new RealizarCadastro();
                            rc.RealizarCadastro(clientes, scanner);
                            break;
                        case 2:
                            RealizarCadastro.removerCliente(clientes, scanner);
                            break;
                        case 3:
                            RealizarCadastro.editarEnderecoCliente(clientes, scanner);
                            break;
                        case 4:
                            Relatorio.gerarRelatorioClientes(clientes, scanner);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 2:
                    RealizarPedido.realizarPedido(clientes, pedidos, scanner);
                    break;
                case 3:
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
                    break;
                case 4:
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

}


