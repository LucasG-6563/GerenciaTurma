use BD_PI

set dateformat dmy

insert into Disciplina values
('Matematica', 'Exatas'),
('Portugues', 'Linguagens'),
('Ci�ncia', 'Ci�ncias'),
('Ingles', 'Linguagens');

insert into Professor values
('Mario','Rua tal, Vila Havaii, 753','30/06/1986','19998979999','12345678900','457896320'),
('Jorge','Rua Vral, Vila Boa, 333','11/03/1991','19665686162','35768415932','987654560'),
('Ana','Rua Pimba, Vale Top, 789','31/08/1983','19335373839','84635216852','685732419'),
('Gabriela','Rua onze, Vila Havaii, 951','06/07/1996','11994978273','14725896300','976453128');

insert into turma values
('9� ano A', 'diurno'),
('9� ano b', 'noturno'),
('8� ano A', 'diurno'),
('7� ano A', 'diurno'),
('7� ano b', 'diurno'),
('7� ano c', 'noturno');

insert into Aluno values
('Joao','R. A, 60','10/10/2008',null,'14785236912','141471470','Fabio','131360360','45236910'),
('Paulo','R. B, 62','05/05/2008',null,'14785236913','141471471','Junior','131360361','45236911'),
('Roberto','R. B, 64','10/07/2008',null,'14785236914','141471472','Claudio','131360362','45236912'),
('Sabrina','R. C, 66','12/12/2009',null,'14785236915','141471473','Dario','131360363','45236913'),
('Bia','R. C, 68','10/10/2009',null,'14785236916','141471474','Anta','131360364','45236914'),
('Enzo','R. C, 40','30/11/2009',null,'14785236917','141471475','Jabu','131360365','45236915'),
('Ana','R. D, 41','23/06/2010',null,'14785236918','141471476','Ticaba','131360366','45236916'),
('Claudio','R. E, 43','30/03/2010',null,'14785236919','141471477','Santo','131360367','45236917'),
('Samanta','R. A, 45','15/04/2010',null,'14785236920','141471478','Siro','131360368','45236918'),
('Julia','R. E, 47','13/07/2010',null,'14785236921','141471479','Gomes','131360369','45236919'),
('Lucas','R. A, 49','20/09/2010',null,'14785236922','141471480','Gomez','131360370','45236920'),
('Antoni','R. A, 48','20/08/2010',null,'14785236923','141471481','Paulo','131360371','45236921');

insert into professor_disciplina(idProfessor, codDisciplina) values
(1,1),
(1,3),
(1,4),
(2,2),
(3,1),
(3,2),
(3,3),
(3,4),
(4,4);

insert into aluno_turma(ra_aluno, cod_turma, ano) values
(1,1, 2020),
(2,1, 2020),
(3,2, 2020),
(4,2, 2020),
(5,3, 2020),
(6,3, 2020),
(7,4, 2020),
(8,4, 2020),
(9,5, 2020),
(10,5, 2020),
(11,6, 2020),
(12,6, 2020);

insert into relacao(cod_prof_disc, cod_turma, ano) values
(1,1,2020),
(2,2,2020),
(3,3,2020),
(4,4,2020),
(5,5,2020),
(6,6,2020),
(7,1,2020),
(8,2,2020),
(9,3,2020),
(1,4,2020),
(2,5,2020),
(3,6,2020);
