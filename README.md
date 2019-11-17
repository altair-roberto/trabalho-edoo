# trabalho-edoo

1. O Trabalho T tem como objetivo definir horários de aulas e alocações de salas e verificar se há problemas
na entrada de dados ou conflitos.

2. A entrada possui vários blocos de linhas, sendo que um bloco é separado do outro por uma linha em
branco.

(a) Cada linha possui uma associação entre informações, em que cada informação será colocada entre
aspas duplas e separada por vírgula.

(b) O primeiro bloco é um conjunto de linhas que associa o nome completo de um professor e um acrônimo de 1 a 10 caracteres diferente para cada professor.

(c) O segundo bloco é um conjunto de linhas que associa o nome completo de uma turma de disciplina e
um acrônimo de 1 a 12 caracteres diferente para cada turma.

(d) O terceiro bloco é um conjunto de linhas que associa o nome completo de uma sala ou laboratório e
um acrônimo de 1 a 7 caracteres diferente para cada sala ou laboratório.

(e) O quarto bloco é um conjunto de linhas que associa o acrônimo de turma de disciplina a uma quádrupla composta por dia da semana, horário inicial, duração e local. O dia da semana será um entre
2, 3, 4, 5, 6, s, ou d, respectivamente, para segunda, terça, quarta, quinta, sexta, sábado e domingo.
Os horários de início da aula é um entre: 7h15, 8h15, 9h25, 10h25, 11h25, 13h15, 14h15, 15h25, 16h25,
17h25, 18h30, 19h30, 20h40, 21h40. A duração da aula é múltipla de 1 hora, sendo que os horários
não podem entrar dentro dos seguintes intervalos: [9h15,9h25), [12h25,13h15), [15h15, 15h25), [18h25,
18h30) e [20h30,20h40). O local é uma sala ou um laboratório.

(f) O quinto bloco é um conjunto de linhas que associa o acrônimo de turma de disciplina a um acrônimo
de professor.

3. Os requisitos do Trabalho T são:
(a) O desenvolvimento de T é em grupo de 1 ou 2 acadêmicos.

(b) A codificação de T deve ser em Java.

(c) Ler corretamente a entrada conforme a especificação (item 2 e subitens).

(d) Armazenar os dados lidos em estruturas de dados adequadas, entre aquelas estudadas nesta disciplina, vetores, listas, filas e pilhas.

(e) Verificar e armazenar todos os detalhes de problemas ou conflitos de: a) Professor ministrando duas
ou mais turmas no mesmo horário; b) Uma turma sendo ministrada por mais de um professor; c) Sala
ou laboratório com mais de uma turma de disciplina alocada no mesmo horário; d) Horário inicial
de aula não permitido; e) Duração de aula ultrapassa os limites permitidos; f) Turma inexistente; g)
Professor inexistente; h) Sala ou laboratório inexistente.

(f) Quando houver conflito que envolveria sobreposição de alguma alocação (disciplina, sala, laboratório,
ou professor), mantenha a primeira informação armazenada como a correta e não faça a sobreposição.

(g) Mostrar todos os detalhes dos problemas e conflitos detectados.

4. Um exemplo de entrada e saída é:

Exemplo de entrada:

“Irineu Sotoma”, “IS”
“Outro Professor”, “OP”
“Estruturas de Dados e Programação Orientada a Objetos - T01”, “EDOO-T01”
“Tópicos em Redes de Computadores III - T01”, “TRC3-T01”
“Sistemas Operacionais - T20”, “SO-T20”
“Laboratório de Ensino I”, “LAB1”
“Sala do Multiuso M13”, “M13”
“Sala do Multiuso M12”, “M12”
“Laboratório de Ensino X”, “LABX”
“SO-T20”, “2”, “7h15”, “4”, “M12”
“EDOO-T01”, “2”, “18h30”, “2”, “LAB1”
“EDOO-T01”, “4”, “18h30”, “2”, “M13”
“EDOO-T01”, “6”, “18h30”, “2”, “LAB1”
“TRC3-T01”, “4”, “18h30”, “2”, “M13”
“EDOO-T01”, “IS”
“TRC3-T01”, “IS”
“SO-T20”, “OP”
“OD-T01”, “IS”
“SO-T20”, “IS”

Exemplo de saída:
Duração de aula de SO-T20 ultrapassa os limites permitidos
M13 está com mais de uma turma alocada no mesmo horário: EDOO-T01,TRC3-T01
IS está ministrando duas turmas no mesmo horário: EDOO-T01,TRC3-T01
OD-T01 é uma turma inexistente
SO-T20 está sendo ministrada por mais de um professor: OP, IS
