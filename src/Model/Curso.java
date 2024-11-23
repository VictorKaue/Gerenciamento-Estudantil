package Model;

public class Curso {
    private String nomeCurso;
    private int cargaHoraria;
    private Professor professorResponsavel;

    public Curso() {
        this.nomeCurso = "";
        this.cargaHoraria = 0;
        this.professorResponsavel = null;
    }

    public Curso(String nomeCurso, int cargaHoraria, Professor professorResponsavel) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
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
