package Model;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private Professor professorResponsavel;
    private int id;
    
    public Curso() {
        this.nomeCurso = "";
        this.cargaHoraria = 0;
        this.professorResponsavel = null;
    }

    public Curso(String nomeCurso, int cargaHoraria, Professor professorResponsavel, int id) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }


	public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public void exibirDados() {
        System.out.println("Curso: " + nomeCurso + ", Carga Horária: " + cargaHoraria);
        if (professorResponsavel != null) {
            System.out.println("Professor Responsável: " + professorResponsavel.getNome());
        } else {
            System.out.println("Professor Responsável: Não definido");
        }
    }
}
