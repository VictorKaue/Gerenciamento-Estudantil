package view;

import javax.swing.*;

public class TelaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton btnCursos, btnProfessores, btnAlunos;

    public TelaInicial() {
        setTitle("Sistema de Gerenciamento Acadêmico");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnCursos = new JButton("Gerenciar Cursos");
        btnCursos.setBounds(100, 30, 200, 30);
        add(btnCursos);

        btnProfessores = new JButton("Gerenciar Professores");
        btnProfessores.setBounds(100, 70, 200, 30);
        add(btnProfessores);

        btnAlunos = new JButton("Gerenciar Alunos");
        btnAlunos.setBounds(100, 110, 200, 30);
        add(btnAlunos);

        btnCursos.addActionListener(e -> {
            new CursoView().setVisible(true);
            dispose();
        });

        btnProfessores.addActionListener(e -> {
            new ProfessorView().setVisible(true);
            dispose();
        });

        btnAlunos.addActionListener(e -> {
            new AlunoView().setVisible(true);
            dispose();
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}