import java.util.ArrayList;
import java.util.List;
public class Agenda {
    private List<Contatos> contatos;

    public Agenda(){
        contatos = new ArrayList<>();
    }
    public void Adicionar_Contato(Contatos contato){
        contatos.add(contato);
    }
    public void remover_Contato(Contatos contato){
        contatos.remove(contato);
    }

    public Contatos Busca_por_Nome(String nome){
        for(Contatos contato: contatos){
            if(contato.get_Nome_Contato().equals(nome)){
                return contato;
            }
        }
        return null;
    }
    public void exibir_Agenda(){
        for(Contatos contato: contatos){
            contato.exibirInformacoes();
        } 
    }
    
}
