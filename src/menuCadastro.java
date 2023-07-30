import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuCadastro {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.print("##------------Menu-----------##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Cadastrar Cliente |\n");
            System.out.print("| Opção 2 - Realizar Pedido   |\n");
            System.out.print("| Opção 3 - Relatiorios       |\n");
            System.out.print("| Opção 4 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    realizarCadastro rc = new realizarCadastro();
                    rc.realizarCadastro(clientes, scanner);
                    break;
                case 2:

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
                            List<Pedido> pedidos = new ArrayList<>();
                            Relatorio.gerarRelatorioPedidos(pedidos);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);

        scanner.close();



    }

}


