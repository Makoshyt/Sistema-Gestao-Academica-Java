AcadFlow — Sistema de Gestão Acadêmica
Projeto da disciplina Estrutura de Dados — 2026.2 | Tema 05: Sistema de Gestão Acadêmica
Sobre o projeto
O AcadFlow é uma aplicação Java de terminal destinada a simular operações acadêmicas: cadastro de cursos, matrícula de alunos, cadastro de disciplinas e gerenciamento de filas de espera quando uma disciplina atinge sua capacidade. O objetivo é demonstrar a integração de estruturas de dados implementadas manualmente.
Estado do projeto: implementação educacional. As funcionalidades abaixo descrevem o código planejado/desenvolvido durante a atividade; o grupo deve compilar, executar e registrar os resultados dos testes no próprio repositório antes da entrega.

Equipe
- Integrante 1: [NOME] — [responsabilidade]
- Integrante 2: [NOME] — [responsabilidade]
- Integrante 3: [NOME, se houver] — [responsabilidade]
- Integrante 4: [NOME, se houver] — [responsabilidade]
Professora: Karina Leite
Disciplina: Estrutura de Dados 2026.2
Estruturas de dados implementadas
Estrutura	Papel no sistema	Operações
Árvore Binária de Busca (ABB)	Organiza os cursos pelo código	Inserção, busca, remoção e percursos em ordem, pré-ordem e pós-ordem
Lista encadeada simples	Armazena alunos de cada curso e matriculados em disciplinas	Adicionar, buscar, remover, listar e contar
Fila encadeada (FIFO)	Organiza a espera por vagas em disciplinas	Adicionar, buscar, remover primeiro, remover por matrícula, listar e contar


As estruturas são implementadas por nós e referências, sem Java Collections como ArrayList, LinkedList ou Queue.
Funcionalidades do menu
1. Cadastrar curso
2. Buscar curso
3. Excluir curso
4. Percorrer a ABB em três ordens
5. Matricular aluno no curso
6. Buscar aluno
7. Remover aluno
8. Listar alunos do curso
9. Cadastrar disciplina
10. Solicitar vaga na disciplina
11. Cancelar matrícula/vaga na disciplina
12. Consultar disciplina e fila
13. Sair
Estrutura dos arquivos
ac-system/
├── src/
│   ├── Main.java
│   ├── SistemaAcademico.java
│   ├── ArvoreCursos.java
│   ├── NoCurso.java
│   ├── Curso.java
│   ├── Aluno.java
│   ├── NoAluno.java
│   ├── ListaAlunos.java
│   ├── Disciplina.java
│   ├── NoFila.java
│   └── FilaEspera.java
├── bin/                  # arquivos compilados (não versionar)
├── .gitignore
└── README.md
Requisitos
- Java JDK instalado (java -version e javac -version)
- Terminal (PowerShell, CMD ou bash)
- VS Code com suporte Java (opcional)
Compilar e executar
Abra o terminal na raiz do projeto, onde está a pasta src:

Windows / PowerShell:
New-Item -ItemType Directory -Force bin | Out-Null
javac -d bin src\*.java
java -cp bin Main
Linux / macOS:
mkdir -p bin
javac -d bin src/*.java
java -cp bin Main
Se o terminal já estiver dentro de src, use javac *.java e depois java Main.

Caso a classe principal do seu repositório tenha outro nome ou pacote, ajuste o comando de execução para refletir o código real.
Como as estruturas interagem
1. Um curso é inserido na ABB, usando seu código como chave.
2. Ao buscar esse código, o sistema localiza o curso na ABB.
3. Cada curso mantém uma lista encadeada de alunos matriculados.
4. O aluno solicita uma vaga em uma disciplina do curso.
5. Havendo vaga, ele entra na lista de matriculados da disciplina; sem vaga, entra na fila FIFO.
6. Ao cancelar a matrícula de um aluno na disciplina, o primeiro da fila ocupa a vaga liberada.
Cenário sugerido para demonstração
1. Cadastrar cursos com códigos 50, 30 e 70.
2. Mostrar os percursos da ABB e buscar o curso 50.
3. Matricular Ana (101) e Bruno (102) no curso 50.
4. Criar a disciplina Banco de Dados (10) com 1 vaga.
5. Solicitar vaga para Ana; depois, para Bruno.
6. Consultar a disciplina: Ana matriculada e Bruno na fila.
7. Cancelar a matrícula de Ana e consultar novamente: Bruno é chamado.
8. Demonstrar uma exclusão de curso e um caso de busca inexistente.
Casos que a equipe deve testar
- [ ] Compilação de todos os arquivos Java
- [ ] Inserção de cursos em ambos os lados da ABB
- [ ] Busca de curso existente e inexistente
- [ ] Rejeição de curso com código duplicado
- [ ] Remoção de nó folha da ABB
- [ ] Remoção de nó com um filho
- [ ] Remoção de nó com dois filhos
- [ ] Percursos em ordem, pré-ordem e pós-ordem
- [ ] Inserção, busca e remoção de alunos da lista
- [ ] Entrada e saída FIFO da fila
- [ ] Cancelamento de matrícula e promoção do primeiro aluno da fila
- [ ] Opções inválidas e encerramento do menu
Restrições e limitações
- Os dados são mantidos em memória e são perdidos ao encerrar a execução.
- O sistema usa interface de terminal, sem interface gráfica nem banco de dados.
- No desenho atual, a matrícula do aluno é controlada por curso; o grupo deve avaliar regras adicionais de identificação única global, se desejado.
- A ordem de busca da ABB depende de sua forma: uma árvore desequilibrada pode ter busca linear no pior caso.
Entrega
Verifique se todos os integrantes têm acesso ao projeto no GitHub, atualize os nomes no relatório e ensaie a apresentação. Confirme que o código compila no computador usado na demonstração.
Licença
Projeto acadêmico para fins educacionais. [Informar licença, caso o grupo decida adotar uma.]
