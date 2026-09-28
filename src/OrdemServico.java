public class OrdemServico {
    private String codigo, cliente, modeloVeiculo, placaVeiculo, data, status;
    private double valorEstimado;
    private Servico servico;
    private Box box;

    public OrdemServico(String codigo, String cliente, String modeloVeiculo, String placaVeiculo, String data, double valor, Servico servico) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.modeloVeiculo = modeloVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.data = data;
        this.valorEstimado = valor;
        this.servico = servico;
        this.status = "aberta";
        this.box = null;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getCliente(){
        return cliente;
    }
    public String getModeloVeiculo(){
        return modeloVeiculo;
    }
    public String getPlacaVeiculo(){
        return placaVeiculo;
    }
    public String getData(){
        return data;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public double getValorEstimado(){
        return valorEstimado;
    }
    public Servico getServico(){
        return servico;
    }
    public Box getBox(){
        return box;
    }
    public void setBox(Box box){
        this.box = box;
    }
    public String infoOrdemServico(){
        return "OrdemServico:" + codigo +
                "-- Cliente: " + cliente +
                "-- Status:" + status +
                "-- Box" + (box != null ? box.getNumero(): "Nenhum");
    }
}
