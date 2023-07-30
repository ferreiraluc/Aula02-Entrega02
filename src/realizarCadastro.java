import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class realizarCadastro {

    public void realizarCadastro(List<Cliente> clientes, Scanner scanner) {
        System.out.println("\nDigite o número de pessoas que deseja cadastrar: ");
        int qtdPessoas = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha deixada pelo nextInt()

        // Cadastrar pessoas com n endereços
        for (int i = 0; i < qtdPessoas; i++) {
            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();
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

            clientes.add(new Cliente(nome, enderecos));
        }
    }
}
