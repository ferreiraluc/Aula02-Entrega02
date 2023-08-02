import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RealizarCadastro {

    public RealizarCadastro() {
    }

    public void realizarCadastro(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\nDigite o número de pessoas que deseja cadastrar: ");
        int qtdPessoas = scanner.nextInt();
        scanner.nextLine();

        // Cadastrar pessoas com n endereços
        for (int i = 0; i < qtdPessoas; i++) {
            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.println("Digite a quantidade de endereços: ");
            int qtdEndereco = scanner.nextInt();
            scanner.nextLine();

            List<Endereco> enderecos = new ArrayList<>();
            for (int j = 0; j < qtdEndereco; j++) {
                System.out.println("Digite o endereço:");
                String rua = scanner.nextLine();
                System.out.println("Digite o número do endereço:");
                int numero = scanner.nextInt();
                scanner.nextLine();
                enderecos.add(new Endereco(rua, numero));
            }

            clientes.add(new Cliente(nome, enderecos));
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
                scanner.nextLine();
                Cliente cliente = clientes.get(numCliente - 1);
                System.out.println("Cliente selecionado: " + cliente.getNome());

                System.out.println("Digite a quantidade de endereços a serem editados: ");
                int qtdEndereco = scanner.nextInt();
                scanner.nextLine();

                List<Endereco> enderecos = new ArrayList<>();
                for (int j = 0; j < qtdEndereco; j++) {
                    System.out.println("Digite o endereço:");
                    String rua = scanner.nextLine();
                    System.out.println("Digite o número do endereço:");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    enderecos.add(new Endereco(rua, numero));
                }

                cliente.setEnderecos(enderecos);
                System.out.println("Endereço do cliente editado com sucesso.");
            } else {
                System.out.println("Número de cliente inválido.");
            }
        }
    }
}
