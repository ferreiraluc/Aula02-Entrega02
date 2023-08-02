import java.util.List;

public class Pedido {

    private final Cliente cliente;
    private final List<String> produtos;
    private final double valorTotal;

    private String status;


    public Pedido(Cliente cliente, List<String> produtos, double valorTotal) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.status = "Em andamento";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }


}
