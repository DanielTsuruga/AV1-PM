public class Servico {
    private String nome, categoria;
    private double tempoEstimado, valor;

    public Servico(String nome, double tempoEstimado, double valor, String categoria){
        this.nome = nome;
        this.tempoEstimado = tempoEstimado;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getNome(){
        return nome;
    }
    public String getCategoria(){
        return categoria;
    }
    public double getTempoEstimado(){
        return tempoEstimado;
    }
    public double getValor(){
        return valor;
    }
    public String infoServico(){
        return nome + "(" + categoria + ") -- R$" + valor;
    }
}
