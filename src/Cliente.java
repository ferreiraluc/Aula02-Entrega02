import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private List<Endereco> enderecos;
    private List<Pedidos> pedidos; // Adicionamos a lista de pedidos

    public Cliente(String nome) {
        this.nome = nome;
        this.enderecos = new ArrayList<>();
        this.pedidos = new ArrayList<>(); // Inicializamos a lista de pedidos
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

    public void addPedido(Pedidos pedido) {
        this.pedidos.add(pedido);
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }
}
