public class Pedido {
    Pizza pizza;
    char tamanho;
    String endereco_Entrega;
    double valor;

    public Pedido(Pizza pizza, String endereco_Entrega, char tamanho){
        this.pizza = pizza;
        this.endereco_Entrega = endereco_Entrega;
        this.tamanho = tamanho;
    }

    public Pizza get_Pizza(){
        return pizza;
    }

    public char get_tamanho(){
        return tamanho;
    }

    public String get_Endereco_Entrega(){
        return endereco_Entrega;
    }

    public double get_valor(){
        return valor;
    }

    public void calcular_Valor_Total() {
        switch (tamanho) {
            case 'P':
                valor = pizza.get_Valor() + 0; 
                break;
            case 'M':
                valor = pizza.get_Valor() + 8; 
                break;
            case 'G':
                valor = pizza.get_Valor() + 12; 
                break;
        }
    }
}