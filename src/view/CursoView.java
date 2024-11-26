package view;

import Model.Curso;
import Model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class CursoView extends JFrame {
	 private static final long serialVersionUID = 1L;
    private JTextField txtId, txtNomeCurso, txtCargaHoraria, txtProfessor;
    private JButton btnSalvar, btnAtualizar, btnDeletar, btnListar, btnVoltar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private List<Curso> cursos;

    public CursoView() {
        cursos = new ArrayList<>();
        setTitle("Gerenciamento de Cursos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel painel = new JPanel(null);
        painel.setBounds(10, 10, 670, 200);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 10, 80, 25);
        painel.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(100, 10, 200, 25);
        txtId.setEditable(false);
        painel.add(txtId);

        JLabel lblNome = new JLabel("Nome do Curso:");
        lblNome.setBounds(10, 40, 100, 25);
        painel.add(lblNome);

        txtNomeCurso = new JTextField();
        txtNomeCurso.setBounds(120, 40, 200, 25);
        painel.add(txtNomeCurso);

        JLabel lblCarga = new JLabel("Carga Horária:");
        lblCarga.setBounds(10, 70, 100, 25);
        painel.add(lblCarga);

        txtCargaHoraria = new JTextField();
        txtCargaHoraria.setBounds(120, 70, 200, 25);
        painel.add(txtCargaHoraria);

        JLabel lblProfessor = new JLabel("Professor:");
        lblProfessor.setBounds(10, 100, 100, 25);
        painel.add(lblProfessor);

        txtProfessor = new JTextField();
        txtProfessor.setBounds(120, 100, 200, 25);
        painel.add(txtProfessor);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 140, 100, 30);
        painel.add(btnSalvar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(120, 140, 100, 30);
        painel.add(btnAtualizar);

        btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(230, 140, 100, 30);
        painel.add(btnDeletar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(340, 140, 100, 30);
        painel.add(btnListar);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(450, 140, 100, 30);
        painel.add(btnVoltar);

        add(painel);

        modelo = new DefaultTableModel(new String[]{"ID", "Curso", "Carga Horária", "Professor"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 220, 670, 230);
        add(scroll);

        btnSalvar.addActionListener(e -> salvarCurso());
        btnAtualizar.addActionListener(e -> atualizarCurso());
        btnDeletar.addActionListener(e -> deletarCurso());
        btnListar.addActionListener(e -> listarCursos());
        btnVoltar.addActionListener(e -> voltar());

        setLocationRelativeTo(null);
    }

    private void salvarCurso() {
        int id = cursos.size() + 1;
        String nome = txtNomeCurso.getText();
        int cargaHoraria = Integer.parseInt(txtCargaHoraria.getText());
        String professor = txtProfessor.getText();

        cursos.add(new Curso(nome, cargaHoraria, new Professor(professor, 0, "", ""), id));
        JOptionPane.showMessageDialog(this, "Curso salvo com sucesso!");
        listarCursos();
        limparCampos();
    }

    private void atualizarCurso() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um curso para atualizar.");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                curso.setNomeCurso(txtNomeCurso.getText());
                curso.setCargaHoraria(Integer.parseInt(txtCargaHoraria.getText()));
                curso.setProfessorResponsavel(new Professor(txtProfessor.getText(), 0, "", ""));
                break;
            }
        }

        JOptionPane.showMessageDialog(this, "Curso atualizado com sucesso!");
        listarCursos();
        limparCampos();
    }

    private void deletarCurso() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um curso para deletar.");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        cursos.removeIf(curso -> curso.getId() == id);

        JOptionPane.showMessageDialog(this, "Curso deletado com sucesso!");
        listarCursos();
        limparCampos();
    }

    private void listarCursos() {
        modelo.setRowCount(0);
        for (Curso curso : cursos) {
            modelo.addRow(new Object[]{curso.getId(), curso.getNomeCurso(), curso.getCargaHoraria(), curso.getProfessorResponsavel().getNome()});
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNomeCurso.setText("");
        txtCargaHoraria.setText("");
        txtProfessor.setText("");
    }

    private void voltar() {
        new TelaInicial().setVisible(true);
        dispose();
    }
}
