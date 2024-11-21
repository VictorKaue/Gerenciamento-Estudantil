package interface_grafica;

public class Estudante extends Pessoa {
	private int matricula;

	public Estudante(String nome, int idade, int matricula) {
		super(nome, idade);
		this.matricula = matricula;
	}
	
	public void exibirDados() {
		
	}
	
}
