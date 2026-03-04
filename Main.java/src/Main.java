import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        int contadorId = 1;
        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n1 - Cadastrar nome");
            System.out.println("2 - Listar nomes");
            System.out.println("3 - Remover nome");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (opcao == 1) {

                System.out.print("Digite um nome: ");
                String nome = scanner.nextLine();

                if (nome.isEmpty()) {
                    System.out.println("Nome não pode ser vazio.");
                } else {
                    Cliente cliente = new Cliente(contadorId, nome);
                    clientes.add(cliente);
                    contadorId++;
                    System.out.println("Nome cadastrado com sucesso!");
                }

            } else if (opcao == 2) {

                if (clientes.isEmpty()) {
                    System.out.println("Nenhum nome cadastrado.");
                } else {
                    System.out.println("\nLista de nomes:");
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }
                }

            } else if (opcao == 3) {

                if (clientes.isEmpty()) {
                    System.out.println("Lista vazia! Nada para remover.");
                } else {

                    System.out.println("\nLista de nomes:");
                    for (Cliente c : clientes) {
                        System.out.println(c);
                    }

                    System.out.print("Digite o ID do nome para remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    Cliente clienteRemover = null;

                    for (Cliente c : clientes) {
                        if (c.getId() == idRemover) {
                            clienteRemover = c;
                            break;
                        }
                    }

                    if (clienteRemover != null) {
                        clientes.remove(clienteRemover);
                        System.out.println("Nome removido com sucesso!");
                    } else {
                        System.out.println("ID não encontrado!");
                    }
                }

            } else if (opcao == 4) {

                System.out.println("Encerrando o sistema...");

            } else {
                System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}