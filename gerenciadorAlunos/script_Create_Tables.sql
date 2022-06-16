use BD_PI;

set dateformat dMy

create table turma(
cod int primary key not null identity(1,1),
serie varchar(20),
periodo varchar(20));

create table Aluno(
ra int primary key not null identity(1,1),
nome varchar(40),
endereco varchar(50),
dataNasc date,
telefone varchar(11),
cpf varchar(11),
rg varchar(9),
nomeResp varchar(40),
cpfResp varchar(11),
rgResp varchar(9));

create table disciplina(
cod int primary key not null identity(1,1),
nome varchar(30),
area varchar(30)
);

create table professor(
idProfessor int primary key not null identity(1,1),
nome varchar(40),
endereco varchar(50),
dataNasc date,
telefone varchar(11),
cpf varchar(11),
rg varchar(9));

create table professor_disciplina(
cod int primary key not null identity(1,1),
idProfessor int references Professor,
codDisciplina int references Disciplina);

create table aluno_turma(
cod_alun_turm int primary key not null identity(1,1),
ra_aluno int references aluno,
cod_turma int references turma,
ano int);

create table relacao(
cod_relacao int primary key identity(1,1),
cod_prof_disc int references professor_disciplina,
cod_turma int references turma,
ano int);

drop table relacao;
drop table aluno_turma;
drop table professor_disciplina;
drop table professor;
drop table disciplina;
drop table Aluno;
drop table turma;
