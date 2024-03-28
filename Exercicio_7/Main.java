import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Atualizar produto");
            System.out.println("3. Remover produto");
            System.out.println("4. Gerar relatório de estoque");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarProduto(estoque, scanner);
                    break;
                case 2:
                    atualizarProduto(estoque, scanner);
                    break;
                case 3:
                    removerProduto(estoque, scanner);
                    break;
                case 4:
                    gerarRelatorio(estoque);
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

    private static void adicionarProduto(List<Produto> estoque, Scanner scanner) {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();

        Produto novoProduto = new Produto(nome, codigo, preco, quantidade);
        estoque.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void atualizarProduto(List<Produto> estoque, Scanner scanner) {
        System.out.print("Digite o código do produto a ser atualizado: ");
        String codigo = scanner.nextLine();
        
        Produto produto = buscarProdutoPorCodigo(estoque, codigo);
        if (produto != null) {
            System.out.print("Novo nome do produto: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Novo preço do produto: ");
            produto.setPreco(scanner.nextDouble());
            System.out.print("Nova quantidade em estoque: ");
            produto.setQuantidade(scanner.nextInt());
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void removerProduto(List<Produto> estoque, Scanner scanner) {
        System.out.print("Digite o código do produto a ser removido: ");
        String codigo = scanner.nextLine();
        
        Produto produto = buscarProdutoPorCodigo(estoque, codigo);
        if (produto != null) {
            estoque.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static Produto buscarProdutoPorCodigo(List<Produto> estoque, String codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    private static void gerarRelatorio(List<Produto> estoque) {
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Relatório de estoque:\n");
            retornar_Estoque(estoque);
        }
    }

    private static void retornar_Estoque(List<Produto> estoque) {
        for(Produto produto: estoque){
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Quantidade em estoque: " + produto.getQuantidade());
            System.out.println("---------------------------");
        }
    }
    
}
    