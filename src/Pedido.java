import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<String> produtos;
    private double valorTotal;

    public Pedido(Cliente cliente, List<String> produtos, double valorTotal) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // Outros métodos, se necessário
}
