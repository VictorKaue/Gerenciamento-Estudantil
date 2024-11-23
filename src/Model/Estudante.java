package Model;

public class Estudante extends Pessoa {
    private String matricula;

    public Estudante() {
        super();
        this.matricula = "";
    }

    public Estudante(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //metodo de sobrescrita
    @Override
    public void exibirDados() {
        System.out.println("Estudante: " + getNome() + ", Idade: " + getIdade() + ", Matrícula: " + matricula);
    }
}
