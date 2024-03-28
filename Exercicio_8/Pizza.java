public class Pizza {
    String sabor;
    double valor;
    String ingredientes;

    public Pizza(String sabor, double valor, String ingredientes){
        this.sabor = sabor;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String get_Sabor(){
        return sabor;
    }

    public double get_Valor(){
        return valor;
    }

    public String get_Ingredientes(){
        return ingredientes;
    }
}