public class Mecanico {
    private String nome, CPF, especialidade, telefone;
    private Box boxResponsavel;

    public Mecanico(String nome, String CPF, String especialidade, String telefone){
        this.nome = nome;
        this.CPF = CPF;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }
    public String getCPF(){
        return CPF;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public String getTelefone(){
        return telefone;
    }
    public Box getBoxResponsavel(){
        return boxResponsavel;
    }
    public void setBoxResponsavel(Box box){
        this.boxResponsavel = boxResponsavel;
    }
    public String infoMecanico(){
        return nome + "(Especialidade:" + especialidade + ") -- " +
                "Box:" + (boxResponsavel != null ? boxResponsavel.getNumero() : "Nenhum");
    }
}
