-- Criar a tabela Professor
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
    CargaHoraria INT, -- Carga Horária do Curso
    ProfessorID VARCHAR(50),  -- Chave estrangeira para associar o Curso ao Professor
    CONSTRAINT FK_ProfessorCurso FOREIGN KEY (ProfessorID)  -- Relacionamento entre Curso e Professor
    REFERENCES Professor(ProfessorID) ON DELETE SET NULL
);

-- Criar a tabela Aluno
CREATE TABLE Aluno (
    AlunoID VARCHAR(50) PRIMARY KEY,  -- A chave primária será do tipo STRING (VARCHAR)
    Nome VARCHAR(100) NOT NULL,   -- Nome do Aluno
    Idade INT   -- Idade do aluno
);

-- Criar a tabela associativa Aluno_Curso para o relacionamento N para N entre Aluno e Curso
CREATE TABLE Aluno_Curso (
    AlunoID VARCHAR(50),   -- Chave estrangeira para a tabela Aluno
    CursoID INT,           -- Chave estrangeira para a tabela Curso
    PRIMARY KEY (AlunoID, CursoID),  -- A combinação de AlunoID e CursoID deve ser única
    CONSTRAINT FK_Aluno FOREIGN KEY (AlunoID)  -- Relacionamento entre Aluno e Aluno_Curso
    REFERENCES Aluno(AlunoID) ON DELETE CASCADE,
    CONSTRAINT FK_Curso FOREIGN KEY (CursoID)  -- Relacionamento entre Curso e Aluno_Curso
    REFERENCES Curso(CursoID) ON DELETE CASCADE
);
