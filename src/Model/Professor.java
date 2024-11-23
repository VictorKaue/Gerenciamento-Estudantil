package Model;

public class Professor extends Pessoa {
    private String especialidade;

    public Professor() {
        super();
        this.especialidade = "";
    }

    public Professor(String nome, int idade, String especialidade) {
        super(nome, idade);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirDados() {
        System.out.println("Professor: " + getNome() + ", Idade: " + getIdade() + ", Especialidade: " + especialidade);
    }
}
