import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> colecao;

    public Biblioteca() {
        colecao = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        Livro livro = new Livro(titulo, autor, ano);
        colecao.add(livro);
    }

    public void exibirInfoLivro(int indice) {
        if (indice >= 0 && indice < colecao.size()) {
            Livro livro = colecao.get(indice);
            livro.exibirInfo();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void exibirColecao() {
        for (int i = 0; i < colecao.size(); i++) {
            System.out.println((i + 1) + ". " + colecao.get(i).getTitulo());
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n1. Adicionar livro");
            System.out.println("2. Exibir informações de um livro");
            System.out.println("3. Exibir coleção");
            System.out.println("0. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.next();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.next();
                    System.out.print("Digite o ano de publicação do livro: ");
                    int ano = scanner.nextInt();
                    biblioteca.adicionarLivro(titulo, autor, ano);
                    break;
                case 2:
                    System.out.print("Digite o índice do livro: ");
                    int indice = scanner.nextInt();
                    biblioteca.exibirInfoLivro(indice - 1);
                    break;
                case 3:
                    biblioteca.exibirColecao();
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
}

class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public void exibirInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + ano);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }
}