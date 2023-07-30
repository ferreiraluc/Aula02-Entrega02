public class Pedidos {
    private Cliente cliente;
    private String status;

    public Pedidos(Cliente cliente) {
        this.cliente = cliente;
        this.status = "Pedido em andamento";
    }

    public void encerrarPedido() {
        this.status = "Pedido encerrado";
    }

    public String getStatus() {
        return status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
