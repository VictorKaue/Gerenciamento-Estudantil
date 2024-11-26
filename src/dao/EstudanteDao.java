package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Estudante;
public class EstudanteDao {
    public boolean inserir(Estudante estudante) {
        String sql = "INSERT INTO Aluno (AlunoID, Nome, Idade) VALUES (?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estudante.getMatricula());
            stmt.setString(2, estudante.getNome());
            stmt.setInt(3, estudante.getIdade());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir estudante: " + e.getMessage());
            return false;
        }
    }
    public boolean atualizar(Estudante estudante) {
        String sql = "UPDATE Aluno SET Nome = ?, Idade = ? WHERE AlunoID = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estudante.getNome());
            stmt.setInt(2, estudante.getIdade());
            stmt.setString(3, estudante.getMatricula());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar estudante: " + e.getMessage());
            return false;
        }
    }
    public boolean deletar(String matricula) {
        String sql = "DELETE FROM Aluno WHERE AlunoID = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar estudante: " + e.getMessage());
            return false;
        }
    }
    public List<Estudante> listar() {
        String sql = "SELECT AlunoID, Nome, Idade FROM Aluno";
        List<Estudante> estudantes = new ArrayList<>();
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Estudante estudante = new Estudante();
                estudante.setMatricula(rs.getString("AlunoID"));
                estudante.setNome(rs.getString("Nome"));
                estudante.setIdade(rs.getInt("Idade"));
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar estudantes: " + e.getMessage());
        }
        return estudantes;
    }
}