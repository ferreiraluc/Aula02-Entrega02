import java.io.BufferedReader;
import java.io.InputStreamReader;
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


