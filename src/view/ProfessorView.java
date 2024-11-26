package view;

import Model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProfessorView extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField txtId, txtNome, txtIdade, txtEspecialidade;
    private JButton btnSalvar, btnAtualizar, btnDeletar, btnListar, btnVoltar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private List<Professor> professores;

    public ProfessorView() {
        professores = new ArrayList<>();
        setTitle("Gerenciamento de Professores");
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

        JLabel lblEspecialidade = new JLabel("Especialidade:");
        lblEspecialidade.setBounds(10, 100, 100, 25);
        painel.add(lblEspecialidade);

        txtEspecialidade = new JTextField();
        txtEspecialidade.setBounds(120, 100, 200, 25);
        painel.add(txtEspecialidade);

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

        modelo = new DefaultTableModel(new String[]{"ID", "Nome", "Idade", "Especialidade"}, 0);
        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(10, 220, 670, 230);
        add(scroll);

        btnSalvar.addActionListener(e -> salvarProfessor());
        btnAtualizar.addActionListener(e -> atualizarProfessor());
        btnDeletar.addActionListener(e -> deletarProfessor());
        btnListar.addActionListener(e -> listarProfessores());
        btnVoltar.addActionListener(e -> voltar());

        setLocationRelativeTo(null);
    }

    private void salvarProfessor() {
        int id = professores.size() + 1;
        String nome = txtNome.getText();
        int idade = Integer.parseInt(txtIdade.getText());
        String especialidade = txtEspecialidade.getText();

        professores.add(new Professor(nome, idade, especialidade, ""));
        JOptionPane.showMessageDialog(this, "Professor salvo com sucesso!");
        listarProfessores();
        limparCampos();
    }

    private void atualizarProfessor() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um professor para atualizar.");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        for (Professor professor : professores) {
            if (professor.getIdade() == id) {
                professor.setNome(txtNome.getText());
                professor.setIdade(Integer.parseInt(txtIdade.getText()));
                professor.setEspecialidade(txtEspecialidade.getText());
                break;
            }
        }

        JOptionPane.showMessageDialog(this, "Professor atualizado com sucesso!");
        listarProfessores();
        limparCampos();
    }

    private void deletarProfessor() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um professor para deletar.");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        professores.removeIf(professor -> professor.getIdade() == id);

        JOptionPane.showMessageDialog(this, "Professor deletado com sucesso!");
        listarProfessores();
        limparCampos();
    }

    private void listarProfessores() {
        modelo.setRowCount(0);
        for (Professor professor : professores) {
            modelo.addRow(new Object[]{professor.getIdade(), professor.getNome(), professor.getIdade(), professor.getEspecialidade()});
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtEspecialidade.setText("");
    }

    private void voltar() {
        new TelaInicial().setVisible(true);
        dispose();
    }
}