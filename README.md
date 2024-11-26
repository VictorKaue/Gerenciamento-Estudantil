# Gerenciamento-Estudantil

# Sistema de Cadastro de Professores

Este sistema foi desenvolvido para gerenciamento de professores em uma plataforma educacional. Ele permite que os usuários realizem operações de cadastro, visualização, edição e exclusão de professores.

## Estrutura do Projeto

### Classes

1. **Professor**
   - Representa um professor com os seguintes atributos:
     - `id`: Identificador único do professor (chave primária).
     - `nome`: Nome do professor.
     - `email`: Endereço de e-mail do professor.
     - `disciplina`: Disciplina que o professor leciona.
     - `telefone`: Número de telefone do professor.
   
   Métodos principais:
   - `getId()`: Retorna o ID do professor.
   - `getNome()`: Retorna o nome do professor.
   - `getEmail()`: Retorna o e-mail do professor.
   - `getDisciplina()`: Retorna a disciplina que o professor leciona.
   - `getTelefone()`: Retorna o telefone do professor.

2. **ProfessorDAO**
   - Classe responsável pela interação com o banco de dados.
   - Métodos principais:
     - `adicionarProfessor(Professor professor)`: Adiciona um novo professor ao banco de dados.
     - `removerProfessor(int id)`: Remove um professor do banco de dados pelo ID.
     - `editarProfessor(Professor professor)`: Atualiza as informações de um professor no banco de dados.
     - `buscarProfessorPorId(int id)`: Busca um professor pelo ID.
     - `listarProfessores()`: Lista todos os professores cadastrados.

3. **ProfessorView**
   - Classe responsável pela interface gráfica (UI) do sistema.
   - Permite ao usuário interagir com o sistema de maneira amigável.
   - Funcionalidades incluem:
     - Tela para cadastrar um novo professor.
     - Tela para editar informações de um professor existente.
     - Tela para visualizar a lista de professores.
     - Tela para remover um professor.
   
   Métodos principais:
   - `iniciar()`: Inicializa a interface gráfica do sistema.
   - `cadastrarProfessor()`: Exibe a tela de cadastro de professor.
   - `editarProfessor()`: Exibe a tela de edição de um professor.
   - `removerProfessor()`: Exibe a tela de remoção de professor.
   - `listarProfessores()`: Exibe a lista de professores.

### Modelagem de Dados

O sistema utiliza um banco de dados relacional, onde a tabela `professores` armazena os dados dos professores.

**Tabela `professores`**
| Coluna     | Tipo       | Descrição                          |
|------------|------------|------------------------------------|
| id         | INT        | Identificador único do professor.  |
| nome       | VARCHAR(50)| Nome do professor.                 |
| email      | VARCHAR(100)| E-mail do professor.             |
| disciplina | VARCHAR(50)| Disciplina que o professor leciona.|
| telefone   | VARCHAR(20)| Número de telefone do professor.   |

### Fluxo do Sistema

1. O usuário inicia o sistema, que carrega a interface gráfica.
2. O usuário pode visualizar a lista de professores cadastrados no banco de dados.
3. O usuário tem as opções de adicionar um novo professor, editar um professor existente ou remover um professor.
4. O sistema interage com a classe `ProfessorDAO` para realizar as operações no banco de dados.
5. Após a realização de qualquer operação (cadastro, edição ou remoção), a lista de professores é atualizada na interface.

### Principais Funcionalidades

- **Cadastro de professores**: O usuário pode cadastrar novos professores fornecendo informações como nome, e-mail, disciplina e telefone.
- **Edição de professores**: O usuário pode editar as informações de um professor já cadastrado.
- **Remoção de professores**: O usuário pode remover um professor do sistema.
- **Visualização de professores**: O sistema permite listar todos os professores cadastrados.

### Tecnologias Utilizadas

- **Java**: Linguagem principal para o desenvolvimento do sistema.
- **Swing**: Framework para criação da interface gráfica (UI).
- **Banco de Dados Relacional**: Sistema de gerenciamento de banco de dados utilizado MySql e MySql Workbanch.
