package Model;

public class Pessoa {
    private int idPessoa;
    private String nome; 

    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nome) {
        this.idPessoa = idPessoa;
        this.nome = nome;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                '}';
    }
}

