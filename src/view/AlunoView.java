package view;

import Model.Estudante;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class AlunoView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField txtId, txtNome, txtIdade, txtMatricula;
    private JButton btnSalvar, btnAtualizar, btnDeletar, btnListar, btnVoltar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private List<Estudante> estudantes;

    public AlunoView() {
        estudantes = new ArrayList<>();
        setTitle("Gerenciamento de Alunos");
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

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 40, 80, 25);
        painel.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 40, 200, 25);
        painel.add(txtNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 70, 80, 25);
        painel.add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(100, 70, 200, 25);
        painel.add(txtIdade);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(10, 100, 100, 25);
        painel.add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setBounds(100, 100, 200, 25);
        painel.add(txtMatricula);

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

        modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Idade", "Matrícula"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 220, 670, 230);
        add(scroll);

        btnSalvar.addActionListener(e -> salvarAluno());
        btnAtualizar.addActionListener(e -> atualizarAluno());
        btnDeletar.addActionListener(e -> deletarAluno());
        btnListar.addActionListener(e -> listarAlunos());
        btnVoltar.addActionListener(e -> voltar());

        setLocationRelativeTo(null);
    }

    private void salvarAluno() {
        int id = estudantes.size() + 1;
        String nome = txtNome.getText();
        int idade = Integer.parseInt(txtIdade.getText());
        String matricula = txtMatricula.getText();

        estudantes.add(new Estudante(nome, idade, matricula));
        JOptionPane.showMessageDialog(this, "Aluno salvo com sucesso!");
        listarAlunos();
        limparCampos();
    }

    private void atualizarAluno() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para atualizar.");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        for (Estudante estudante : estudantes) {
            if (estudante.getMatricula().equals(txtMatricula.getText())) {
                estudante.setNome(txtNome.getText());
                estudante.setIdade(Integer.parseInt(txtIdade.getText()));
                estudante.setMatricula(txtMatricula.getText());
                break;
            }
        }

        JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");
        listarAlunos();
        limparCampos();
    }

    private void deletarAluno() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno para deletar.");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        estudantes.removeIf(estudante -> estudante.getMatricula().equals(txtMatricula.getText()));

        JOptionPane.showMessageDialog(this, "Aluno deletado com sucesso!");
        listarAlunos();
        limparCampos();
    }

    private void listarAlunos() {
        modelo.setRowCount(0);
        for (Estudante estudante : estudantes) {
            modelo.addRow(new Object[]{estudante.getMatricula(), estudante.getNome(), estudante.getIdade(), estudante.getMatricula()});
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtMatricula.setText("");
    }

    private void voltar() {
        new TelaInicial().setVisible(true);
        dispose();
    }
}