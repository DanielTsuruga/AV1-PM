public class Box {
    private int numero, capacidadeMaxima;
    private String tipoServicoPermitido, localizacao;
    private Mecanico mecanico;

    public Box(int numero, String tipoServicoPermitido, int capacidadeMaxima, String localizacao){
        this.numero = numero;
        this.tipoServicoPermitido = tipoServicoPermitido;
        this.capacidadeMaxima = capacidadeMaxima;
        this.localizacao = localizacao;
    }

    public int getNumero(){
        return numero;
    }
    public int getCapacidadeMaxima(){
        return capacidadeMaxima;
    }
    public String getTipoServicoPermitido(){
        return tipoServicoPermitido;
    }
    public String getLocalizacao(){
        return localizacao;
    }
    public Mecanico getMecanico(){
        return mecanico;
    }
    public void setMecanico(Mecanico mecanico){
        this.mecanico = mecanico;
    }
    public String infoBox() {
        return "Box" + numero + "[" + tipoServicoPermitido + "] -- " +
                "Mecanico: " + (mecanico != null ? mecanico.getNome() : "Nenhum");
    }
}
