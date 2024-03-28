import java.util.ArrayList;
import java.util.Scanner;

public class Main_carro {
    private static ArrayList<Carro> listaCarros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Registrar novo carro");
            System.out.println("2. Consultar informações de um carro");
            System.out.println("3. Acelerar/Frear");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao) {
                case 1:
                    registrarCarro();
                    break;
                case 2:
                    consultarCarro();
                    break;
                    case 3:
                    System.out.print("Digite a placa do carro que deseja atualizar: ");
                    String placaCarro = scanner.nextLine();
                    boolean encontradoCarro = false;
                    for (Carro carro : listaCarros) {
                        if (carro.getPlaca().equals(placaCarro)) {
                            encontradoCarro = true;
                            exibirMenuAcelerarFrear(carro);
                            break;
                        }
                    }
                    if (!encontradoCarro) {
                        System.out.println("Carro com a placa " + placaCarro + " não encontrado.");
                    }
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        System.out.println("Saindo do programa...");
        scanner.close();
    }

    private static void registrarCarro() {
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o ano do carro: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        System.out.print("Digite a velocidade atual do carro: ");
        int velocidadeAtual = scanner.nextInt();
        scanner.nextLine(); 
        
        Carro novoCarro = new Carro(marca, modelo, ano, placa, velocidadeAtual);
        listaCarros.add(novoCarro);
        System.out.println("Carro registrado com sucesso!");
    }

    private static void consultarCarro() {
        System.out.print("Digite a placa do carro que deseja consultar: ");
        String placa = scanner.nextLine();
        boolean encontrado = false;
        for (Carro carro : listaCarros) {
            if (carro.getPlaca().equals(placa)) {
                carro.exibirInformacoes();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Carro com a placa " + placa + " não encontrado.");
        }
    }
    private static void exibirMenuAcelerarFrear(Carro carro) {
        boolean sairMenu = false;
        while (!sairMenu) {
            System.out.println("\n=== Menu Acelerar/Frear ===");
            System.out.println("1. Acelerar");
            System.out.println("2. Frear");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");
            
            int opcaoMenu = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcaoMenu) {
                case 1:
                    System.out.print("Digite a quantidade de velocidade para acelerar: ");
                    int novaVelocidadeAcelerar = scanner.nextInt();
                    carro.acelerar(novaVelocidadeAcelerar);
                    break;
                case 2:
                    System.out.print("Digite a quantidade de velocidade para frear: ");
                    int novaVelocidadeFrear = scanner.nextInt();
                    carro.frear(novaVelocidadeFrear);
                    break;
                case 3:
                    sairMenu = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}