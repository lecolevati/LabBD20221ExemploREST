CREATE DATABASE exemplorest
GO
USE exemplorest
GO
CREATE TABLE aluno (
ra		CHAR(13)		NOT NULL,
nome	VARCHAR(50)		NOT NULL,
email	VARCHAR(30)		NOT NULL
PRIMARY KEY (ra)
)
GO
CREATE TABLE disciplina (
codigo		INT			NOT NULL,
nome		VARCHAR(40)	NOT NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE matricula (
codigo_disciplina		INT			NOT NULL,
ra_aluno				CHAR(13)	NOT NULL
PRIMARY KEY(ra_aluno, codigo_disciplina)
FOREIGN KEY(ra_aluno) REFERENCES aluno(ra),
FOREIGN KEY(codigo_disciplina) REFERENCES disciplina(codigo)
)
