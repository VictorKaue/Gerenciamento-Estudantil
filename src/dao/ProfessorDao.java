package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Professor;

public class ProfessorDao {
    public boolean inserir(Professor professor) {
        String sql = "INSERT INTO Professor (ProfessorID, Nome, Idade, Especialidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professor.getMatricula());
            stmt.setString(2, professor.getNome());
            stmt.setInt(3, professor.getIdade());
            stmt.setString(4, professor.getEspecialidade());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir professor: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Professor professor) {
        String sql = "UPDATE Professor SET Nome = ?, Idade = ?, Especialidade = ? WHERE ProfessorID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getEspecialidade());
            stmt.setString(4, professor.getMatricula());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar professor: " + e.getMessage());
            return false;
        }
    }

    public boolean deletar(String matricula) {
        String sql = "DELETE FROM Professor WHERE ProfessorID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, matricula);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar professor: " + e.getMessage());
            return false;
        }
    }

    public List<Professor> listar() {
        String sql = "SELECT ProfessorID, Nome, Idade, Especialidade FROM Professor";
        List<Professor> professores = new ArrayList<>();

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor professor = new Professor();
                professor.setMatricula(rs.getString("ProfessorID"));
                professor.setNome(rs.getString("Nome"));
                professor.setIdade(rs.getInt("Idade"));
                professor.setEspecialidade(rs.getString("Especialidade"));

                professores.add(professor);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar professores: " + e.getMessage());
        }

        return professores;
    }
}
