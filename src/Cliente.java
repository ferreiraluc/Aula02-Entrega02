import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private List<Endereco> enderecos;

    public Cliente(String nome) {
        this.nome = nome;
        this.enderecos = new ArrayList<>();
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    public String getNome() {
        return nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void addPedido(Pedidos pedidos) {
    }
}

