import java.util.Scanner;

public class Calculadora {

    private double num1;
    private double num2;
    private double resultado;

    public Calculadora() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o valor do primeiro número:");
        num1 = scanner.nextDouble();
        System.out.println("Informe o valor do segundo número:");
        num2 = scanner.nextDouble();
        scanner.close();
    }
    public double adicao() {
        resultado = num1 + num2;
        return resultado;
    }

    public double subtracao() {
        resultado = num1 - num2;
        return resultado;
    }

    public double multiplicacao() {
        resultado = num1 * num2;
        return resultado;
    }

    public double divisao() {
        if (num2 == 0) {
            System.out.println("Impossível dividir por 0.");
            resultado = Double.NaN;
            return resultado;
        } else {
            resultado = num1 / num2;
            return resultado;
        }
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo à Calculadora Java!");
        System.out.println("Digite a operação para ser realizada:");
        System.out.println("[1] Soma (+)");
        System.out.println("[2] Subtração (-)");
        System.out.println("[3] Multiplicação (*)");
        System.out.println("[4] Divisão (/)");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();       
        double resultado = 0;
        Calculadora calculadora = new Calculadora();

        switch (input) {
            case 1:
                resultado = calculadora.adicao();
                break;
            case 2:
                resultado = calculadora.subtracao();
                break;
            case 3:
                resultado = calculadora.multiplicacao();
                break;
            case 4:
                resultado = calculadora.divisao();
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
        System.out.printf("Resultado = %.2f%n", resultado); 
        scanner.close();
    }
}