package Model;

public class Professor extends Pessoa {
	private String especialidade;
	private String matricula;

    public Professor() {
        super();
        this.especialidade = "";
    }

    public Professor(String nome, int idade, String especialidade, String matricula) {
        super(nome, idade);
        this.especialidade = especialidade;
        this.matricula = matricula;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
    public void exibirDados() {
        System.out.println("Professor: " + getNome() + ", Idade: " + getIdade() + ", Especialidade: " + especialidade);
    }
}
