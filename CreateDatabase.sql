CREATE TABLE Professor (
    ProfessorID VARCHAR(50) PRIMARY KEY,  -- A chave primária será do tipo STRING (VARCHAR)
    Nome VARCHAR(100) NOT NULL,  -- Nome do Professor
    Idade INT, -- Idade do Professor
    Especialidade VARCHAR(50) -- Especialidade do Professor
);

-- Criar a tabela Curso
CREATE TABLE Curso (
    CursoID INT AUTO_INCREMENT PRIMARY KEY,  -- A chave primária do curso continua como inteiro
    Nome VARCHAR(100) NOT NULL,  -- Nome do Curso
    CargaHoraria INT, -- Carga Horário do Curso
    ProfessorID VARCHAR(50),  -- Chave estrangeira para associar o Curso ao Professor
    CONSTRAINT FK_ProfessorCurso FOREIGN KEY (ProfessorID)  -- Relacionamento entre Curso e Professor
    REFERENCES Professor(ProfessorID) ON DELETE SET NULL
);

-- Criar a tabela Aluno
CREATE TABLE Aluno (
    AlunoID VARCHAR(50) PRIMARY KEY,  -- A chave primária será do tipo STRING (VARCHAR)
    Nome VARCHAR(100) NOT NULL,   -- Nome do Aluno
    Idade INT, -- Idade do aluno
    CursoID INT,  -- Chave estrangeira para associar o Aluno ao Curso
    CONSTRAINT FK_CursoAluno FOREIGN KEY (CursoID)  -- Relacionamento entre Aluno e Curso
    REFERENCES Curso(CursoID) ON DELETE SET NULL
);
