package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Curso;
import Model.Professor;

public class CursoDao {
    public boolean inserir(Curso curso) {
        String sql = "INSERT INTO Curso (Nome, CargaHoraria, ProfessorID) VALUES (?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setString(3, curso.getProfessorResponsavel() != null ? curso.getProfessorResponsavel().getMatricula() : null);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir curso: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Curso curso) {
        String sql = "UPDATE Curso SET Nome = ?, CargaHoraria = ?, ProfessorID = ? WHERE CursoID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setString(3, curso.getProfessorResponsavel() != null ? curso.getProfessorResponsavel().getMatricula() : null);
            stmt.setInt(4, curso.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM Curso WHERE CursoID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar curso: " + e.getMessage());
            return false;
        }
    }

    public List<Curso> listar() {
        String sql = "SELECT c.CursoID, c.Nome, c.CargaHoraria, p.ProfessorID, p.Nome AS ProfessorNome " +
                     "FROM Curso c LEFT JOIN Professor p ON c.ProfessorID = p.ProfessorID";

        List<Curso> cursos = new ArrayList<>();

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("CursoID"));
                curso.setNomeCurso(rs.getString("Nome"));
                curso.setCargaHoraria(rs.getInt("CargaHoraria"));

                if (rs.getString("ProfessorID") != null) {
                    Professor professor = new Professor();
                    professor.setMatricula(rs.getString("ProfessorID"));
                    professor.setNome(rs.getString("ProfessorNome"));
                    curso.setProfessorResponsavel(professor);
                }

                cursos.add(curso);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar cursos: " + e.getMessage());
        }

        return cursos;
    }
}
