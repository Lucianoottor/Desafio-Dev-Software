/*Em uma pequena cidade, um desenvolvedor entusiasta decide criar um sistema para ajudar a gerenciar as contas bancárias dos cidadãos locais.
 Com o crescimento da comunidade, ficou evidente a necessidade de um método mais eficiente e seguro para o manejo de transações bancárias, 
 que até então eram feitas manualmente e levavam muito tempo.
Inspirado por essa necessidade comunitária, o objetivo é desenvolver um sistema bancário simples em Java, focando na orientação a objetos. 
Este sistema permitirá a criação de contas bancárias, cada uma capaz de realizar operações básicas como depósitos, saques e consultas de 
saldo. O desafio é estruturar o programa de forma que cada conta seja um objeto, refletindo os princípios da programação orientada a 
objetos.
Dica:
“Projete uma classe `ContaBancaria` que encapsule os atributos de uma conta, como `numeroConta`, `nomeTitular` e `saldo`. 
Utilize modificadores de acesso para garantir o encapsulamento e a segurança dos dados. Implemente métodos para `depositar(valor)`, 
`sacar(valor)` e um método que retorne o `saldo` atual da conta. Lembre-se de que cada operação deve ajustar o saldo da conta de acordo 
com a transação realizada.”

 */

import java.util.Scanner;
import java.util.ArrayList;

class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private String senha;

    public ContaBancaria(int numeroConta, String nomeTitular, double saldo, String senha) {
        
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.senha = senha;
    }

    public void exibirInfo() {
        System.out.printf("Número da conta: %d\n", numeroConta);
        System.out.printf("Proprietário da conta: %s\n", nomeTitular);
        System.out.printf("Saldo da conta: %.2f\n", saldo);
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public void depositar(double valor, String senha) {
        if (validarSenha(senha)) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    public void sacar(double valor, String senha) {
        if (validarSenha(senha)) {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            }else {
                System.out.println("Saldo insuficiente para realizar esta operação.");
            }
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numeroConta;
        String senha;
        boolean acessoConcedido = false;

        do {
            System.out.println("\nBem-vindo ao Banco!");
            System.out.println("1. Cadastrar conta");
            System.out.println("2. Acessar conta");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do titular da conta: ");
                    scanner.nextLine();
                    String nomeTitular = scanner.nextLine();
                    boolean contaExiste = true;
                    while (contaExiste) {
                        System.out.print("Digite o número da conta: ");
                        int numeroContaInput = scanner.nextInt();
                        contaExiste = contas.stream().anyMatch(conta -> conta.numeroConta == numeroContaInput);
                        if (contaExiste) {
                            System.out.println("Este número de conta já existe. Tente outro.");
                        }
                        else{
                            numeroConta = numeroContaInput;
                            System.out.print("Digite a senha da conta: ");
                            senha = scanner.next();
                            criarNovaConta(nomeTitular, numeroConta, senha, contas);
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextInt();
                    System.out.print("Digite a senha da conta: ");
                    senha = scanner.next();
                    boolean encontrouConta = false;
                    for (ContaBancaria conta : contas) {
                        if(conta.numeroConta == numeroConta && conta.validarSenha(senha)){
                            encontrouConta = true;
                            int opcao2;

                            do {
                                System.out.println("\nConta encontrada!");
                                System.out.println("1. Exibir informações");
                                System.out.println("2. Depositar");
                                System.out.println("3. Sacar");
                                System.out.println("4. Sair");
                                System.out.print("Digite a opção desejada: ");
                                opcao2 = scanner.nextInt();

                                switch (opcao2) {
                                    case 1:
                                        conta.exibirInfo();
                                        break;
                                    case 2:
                                        System.out.print("Informe o valor do depósito: ");
                                        double valorDeposito = scanner.nextDouble();
                                        conta.depositar(valorDeposito, senha);
                                        break;
                                    case 3:
                                        System.out.print("Informe o valor do saque: ");
                                        double valorSaque = scanner.nextDouble();
                                        conta.sacar(valorSaque, senha);
                                        break;
                                    case 4:
                                        System.out.println("Saindo...");
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                        break;
                                }

                            } while (opcao2 != 4);
                        }
                    }

                    if (!encontrouConta) {
                        System.out.println("Conta não encontrada.");
                    }

                    acessoConcedido = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (!acessoConcedido);

        scanner.close();
    }

    private static void criarNovaConta(String nomeTitular, int numeroConta, String senha, ArrayList<ContaBancaria> contas) {
        ContaBancaria contaBancaria = new ContaBancaria(numeroConta, nomeTitular, 0, senha);
        contas.add(contaBancaria);
        System.out.println("Conta criada com sucesso!");
    }
}