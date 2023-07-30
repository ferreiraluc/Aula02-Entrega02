import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuCadastro {

    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Pedidos> pedidos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Realizar pedido");
            System.out.println("3. Relatórios");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    realizarPedido(scanner);
                    break;
                case 3:
                    exibirRelatorios();
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


    private static void cadastrarCliente(Scanner scanner) {
        scanner.nextLine();

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        System.out.print("Digite o endereco (rua): ");
        String rua = scanner.nextLine();
        System.out.print("Digite o numero da residencia: ");
        int numero = scanner.nextInt();
        Endereco endereco = new Endereco(rua, numero);
        cliente.addEndereco(endereco);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

    }

    private static void realizarPedido(Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }

        System.out.print("Digite o número do cliente: ");
        int numeroCliente = scanner.nextInt();

        if (numeroCliente <= 0 || numeroCliente > clientes.size()) {
            System.out.println("Cliente inválido. Operação cancelada.");
            return;
        }

        Cliente clienteSelecionado = clientes.get(numeroCliente - 1);
        Pedidos pedido = new Pedidos(clienteSelecionado);
        clienteSelecionado.addPedido(pedido);

        System.out.println("Pedido vinculado ao cliente " + clienteSelecionado.getNome() + " com sucesso!");

        exibirRelatorios();
    }

    private static void exibirRelatorios() {
        int totalPedidos = pedidos.size();
        int totalPedidosEncerrados = 0;
        int totalPedidosEmAtendimento = 0;

        for (Pedidos pedido : pedidos) {
            if (pedido.getStatus().equals("Encerrado")) {
                totalPedidosEncerrados++;
            } else {
                totalPedidosEmAtendimento++;
            }
        }

        System.out.println("Quantidade de pedidos: " + totalPedidos);
        System.out.println("Quantidade de pedidos encerrados: " + totalPedidosEncerrados);
        System.out.println("Quantidade de pedidos em atendimento: " + totalPedidosEmAtendimento);

        emitirTxtEntrega();
    }
    private static void emitirTxtEntrega() {
        for (Pedidos pedido : pedidos) {
            if (pedido.getStatus().equals("Encerrado")) {
                Cliente cliente = pedido.getCliente();
                List<Endereco> enderecos = cliente.getEnderecos();
                if (!enderecos.isEmpty()) {
                    Endereco enderecoEntrega = enderecos.get(0);
                    String nomeCliente = cliente.getNome();
                    String enderecoEntregaStr = enderecoEntrega.toString();


                    System.out.println("TXT de entrega para o cliente " + nomeCliente + ":");
                    System.out.println(enderecoEntregaStr);
                }
            }
        }
    }


}
