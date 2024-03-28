import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<Pizza> menu = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menu.add(new Pizza("Margherita", 25.0, "Molho de tomate, mussarela, manjericão"));
        menu.add(new Pizza("Calabresa", 30.0, "Molho de tomate, calabresa, cebola, azeitonas"));
        menu.add(new Pizza("Frango com Catupiry", 35.0, "Molho de tomate, frango desfiado, catupiry"));

        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirMenuPizzas();
                    break;
                case 2:
                    fazerPedido();
                    break;
                case 3:
                    cancelarPedido();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("\nBem-vindo à Pizzaria!");
        System.out.println("1. Ver Menu");
        System.out.println("2. Fazer Pedido");
        System.out.println("3. Cancelar Pedido");
        System.out.println("4. Gerar Relatório");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuPizzas() {
        System.out.println("\nMenu:");
        System.out.println("Escolha o tamanho P (4 fatias), M (8 fatias [adicional de R$8.00]), ou G (12 fatias [adicional de R$12.00]): ");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i+1) + ". " + menu.get(i).get_Sabor() + " - R$" + menu.get(i).get_Valor() + " - Ingredientes: " + menu.get(i).get_Ingredientes());
        }
    }

    public static void fazerPedido() {
        exibirMenuPizzas();
        System.out.print("Escolha o número da pizza que deseja pedir: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha >= 1 && escolha <= menu.size()) {
            Pizza pizzaEscolhida = menu.get(escolha - 1);
            System.out.print("Escolha o tamanho (P, M, ou G): ");
            char tamanho = scanner.nextLine().toUpperCase().charAt(0);

            if (tamanho == 'P' || tamanho == 'M' || tamanho == 'G') {
                System.out.print("Digite o endereço de entrega: ");
                String endereco = scanner.nextLine();
                Pedido novoPedido = new Pedido(pizzaEscolhida, endereco, tamanho);
                novoPedido.calcular_Valor_Total(); 
                pedidos.add(novoPedido);
                System.out.println("Pedido realizado com sucesso! Valor total: R$" + novoPedido.get_valor());
            } else {
                System.out.println("Tamanho inválido.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void cancelarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para cancelar.");
            return;
        }

        System.out.println("\nPedidos:");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println((i+1) + ". " + pedidos.get(i).get_Pizza().get_Sabor() + " - " + pedidos.get(i).get_Endereco_Entrega());
        }

        System.out.print("Digite o número do pedido que deseja cancelar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha >= 1 && escolha <= pedidos.size()) {
            pedidos.remove(escolha - 1);
            System.out.println("Pedido cancelado com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void gerarRelatorio() {
        System.out.println("\nRelatório de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("Pizza: " + pedido.get_Pizza().get_Sabor() + " - Valor: R$" + pedido.get_valor() + " - Tamanho: " + pedido.get_tamanho() + " - Endereço de Entrega: " + pedido.get_Endereco_Entrega());
        }
    }
}
