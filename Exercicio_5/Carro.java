public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa, int velocidadeAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = velocidadeAtual;
    }

    public void acelerar(int novaVelocidade) {
        if (novaVelocidade <= 0) {
            System.out.println("Insira uma velocidade válida.");
            return;
        }
        this.velocidadeAtual += novaVelocidade;
        System.out.println("Acelerando!");
    }

    public void frear(int novaVelocidade) {
        if (novaVelocidade < 0) {
            System.out.println("Insira uma velocidade válida.");
            return;
        }
        if (this.velocidadeAtual - novaVelocidade < 0) {
            System.out.println("O carro já está parado.");
            this.velocidadeAtual = 0;
            return;
        }
        this.velocidadeAtual -= novaVelocidade;
        System.out.println("Freando!");
    }

    public void exibirInformacoes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Velocidade atual: " + velocidadeAtual);
    }
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAno() {
        return ano;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
}