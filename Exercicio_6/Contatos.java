public class Contatos{
    private String nome_Contato;
    private String telefone;

    public Contatos(String nome_Contato, String telefone){
        this.nome_Contato = nome_Contato;
        this.telefone = telefone;
    }
    public String get_Nome_Contato(){
        return nome_Contato;
    }
    public String get_telefone(){
        return telefone;
    }
    void exibirInformacoes(){
        System.out.println("Nome: " + nome_Contato);
        System.out.println("Telefone: " + telefone);
    }
}

