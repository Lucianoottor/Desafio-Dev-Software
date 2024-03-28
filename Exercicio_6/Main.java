import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Buscar contato por nome");
            System.out.println("4. Exibir agenda em ordem alfabética");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nomeContato = scanner.nextLine();
                    System.out.print("Telefone do contato: ");
                    String telefoneContato = scanner.nextLine();
                    agenda.Adicionar_Contato(new Contatos(nomeContato, telefoneContato));
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    Contatos contatoRemover = agenda.Busca_por_Nome(nomeRemover);
                    if (contatoRemover != null) {
                        agenda.remover_Contato(contatoRemover);
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 3:
                    System.out.print("Nome do contato a ser buscado: ");
                    String nomeBuscar = scanner.nextLine();
                    Contatos contatoEncontrado = agenda.Busca_por_Nome(nomeBuscar);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado:");
                        contatoEncontrado.exibirInformacoes();
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("\nAgenda em ordem alfabética:");
                    agenda.exibir_Agenda();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, selecione novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}