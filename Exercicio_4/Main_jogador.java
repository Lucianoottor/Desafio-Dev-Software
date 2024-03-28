import java.util.ArrayList;
import java.util.Scanner;

public class Main_jogador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogador> jogadores = new ArrayList<>();
    
        int opcao;
        do {
            System.out.println("\nBem-vindo ao sistema de gerenciamento de jogadores!");
            System.out.println("Selecione uma opção:");
            System.out.println("[1] Criar novo jogador");
            System.out.println("[2] Acessar jogador existente");
            System.out.println("[0] Sair");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    criarNovoJogador(scanner, jogadores);
                    break;
                case 2:
                    acessarJogador(scanner, jogadores);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void criarNovoJogador(Scanner scanner, ArrayList<Jogador> jogadores) {
        System.out.println("\nCriando novo jogador...");
        System.out.println("Informe o nome do jogador:");
        String nome = scanner.next();
        jogadores.add(new Jogador(nome, 0, 1));
        System.out.println("Jogador criado com sucesso!");
    }
    

    private static void acessarJogador(Scanner scanner, ArrayList<Jogador> jogadores) {
        System.out.println("\nAcessando jogador existente...");
        System.out.println("Selecione o jogador que deseja acessar:");
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + jogadores.get(i).getNome());
        }
        int escolha = scanner.nextInt();
        if (escolha >= 1 && escolha <= jogadores.size()) {
            Jogador jogadorSelecionado = jogadores.get(escolha - 1);
            System.out.println("\nAcessando jogador: " + jogadorSelecionado.getNome());
            int opcao;
            do {
                System.out.println("\nSelecione uma opção para o jogador:");
                System.out.println("[1] Modificar experiência");
                System.out.println("[2] Modificar nível");
                System.out.println("[3] Alterar nome");
                System.out.println("[4] Visualizar informações");
                System.out.println("[0] Voltar");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        System.out.println("Informe a quantidade de experiência a ser adicionada:");
                        System.out.println("Lembrete: cada 1000 de experiência é convertido em 1 nível!");
                        int experiencia = scanner.nextInt();
                        jogadorSelecionado.aumentarPontuacao(experiencia);
                        System.out.println("Experiência modificada com sucesso!");
                        break;
                    case 2:
                        System.out.println("Informe o novo nível:");
                        System.out.println("Lembrete: seu nível passado será substituído!");
                        int novoNivel = scanner.nextInt();
                        jogadorSelecionado.setNivel(novoNivel);
                        System.out.println("Nível modificado com sucesso!");
                        break;
                    case 3:
                        System.out.println("Informe o novo nome:");
                        String novoNome = scanner.next();
                        jogadorSelecionado.setNome(novoNome);
                        System.out.println("Nome modificado com sucesso!");
                        break;
                    case 4:
                        jogadorSelecionado.exibirInformacoes();
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }
}