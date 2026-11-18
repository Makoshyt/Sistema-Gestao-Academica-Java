
import java.util.Scanner;

public class SistemaAcademico {
    private ArvoreCursos arvore;
    private Scanner entrada;

    public SistemaAcademico() {
        arvore = new ArvoreCursos();
        entrada = new Scanner(System.in);
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("O texto nao pode estar vazio.");
        }
    }

    private Curso localizarCurso() {
        int codigo = lerInteiro("Codigo do curso: ");
        Curso curso = arvore.buscar(codigo);

        if (curso == null) {
            System.out.println("Curso nao encontrado.");
        }

        return curso;
    }

    private Disciplina localizarDisciplina(Curso curso) {
        int codigo = lerInteiro("Codigo da disciplina: ");
        Disciplina disciplina = curso.buscarDisciplina(codigo);

        if (disciplina == null) {
            System.out.println("Disciplina nao encontrada.");
        }

        return disciplina;
    }

    private void cadastrarCurso() {
        int codigo = lerInteiro("Codigo do curso: ");
        String nome = lerTexto("Nome do curso: ");

        if (arvore.inserir(new Curso(codigo, nome))) {
            System.out.println("Curso cadastrado com sucesso!");
        } else {
            System.out.println("Ja existe um curso com esse codigo.");
        }
    }

    private void buscarCurso() {
        Curso curso = localizarCurso();

        if (curso != null) {
            System.out.println("Curso encontrado: " + curso);
        }
    }

    private void excluirCurso() {
        int codigo = lerInteiro("Codigo do curso: ");

        if (arvore.remover(codigo)) {
            System.out.println("Curso excluido com sucesso.");
        } else {
            System.out.println("Curso nao encontrado.");
        }
    }

    private void listarCursos() {
        System.out.println("1 - Em ordem");
        System.out.println("2 - Pre-ordem");
        System.out.println("3 - Pos-ordem");

        int opcao = lerInteiro("Escolha: ");

        switch (opcao) {
            case 1:
                arvore.emOrdem();
                break;
            case 2:
                arvore.preOrdem();
                break;
            case 3:
                arvore.posOrdem();
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private void matricularAluno() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        int matricula = lerInteiro("Matricula do aluno: ");
        String nome = lerTexto("Nome do aluno: ");

        Aluno aluno = new Aluno(matricula, nome);

        if (curso.getAlunos().adicionar(aluno)) {
            System.out.println("Aluno matriculado no curso!");
        } else {
            System.out.println("Matricula ja cadastrada neste curso.");
        }
    }

    private void buscarAluno() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        int matricula = lerInteiro("Matricula do aluno: ");
        Aluno aluno = curso.getAlunos().buscar(matricula);

        if (aluno == null) {
            System.out.println("Aluno nao encontrado.");
        } else {
            System.out.println("Aluno encontrado: " + aluno);
        }
    }

    private void removerAluno() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        int matricula = lerInteiro("Matricula do aluno: ");

        if (curso.removerAluno(matricula)) {
            System.out.println("Aluno removido do curso.");
        } else {
            System.out.println("Aluno nao encontrado.");
        }
    }

    private void listarAlunos() {
        Curso curso = localizarCurso();

        if (curso != null) {
            System.out.println("Alunos do curso " + curso.getNome());
            curso.getAlunos().listar();
        }
    }

    private void cadastrarDisciplina() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        int codigo = lerInteiro("Codigo da disciplina: ");
        String nome = lerTexto("Nome da disciplina: ");
        int vagas = lerInteiro("Quantidade de vagas: ");

        if (vagas <= 0) {
            System.out.println("A quantidade de vagas deve ser positiva.");
            return;
        }

        Disciplina disciplina = new Disciplina(codigo, nome, vagas);

        if (curso.adicionarDisciplina(disciplina)) {
            System.out.println("Disciplina cadastrada!");
        } else {
            System.out.println("Codigo de disciplina ja existente.");
        }
    }

    private void solicitarVaga() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        Disciplina disciplina = localizarDisciplina(curso);

        if (disciplina == null) {
            return;
        }

        int matricula = lerInteiro("Matricula do aluno: ");
        Aluno aluno = curso.getAlunos().buscar(matricula);

        if (aluno == null) {
            System.out.println("Aluno nao matriculado no curso.");
            return;
        }

        disciplina.solicitarVaga(aluno);
    }

    private void cancelarVaga() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        Disciplina disciplina = localizarDisciplina(curso);

        if (disciplina == null) {
            return;
        }

        int matricula = lerInteiro("Matricula do aluno: ");
        disciplina.cancelarMatricula(matricula);
    }

    private void consultarDisciplina() {
        Curso curso = localizarCurso();

        if (curso == null) {
            return;
        }

        curso.listarDisciplinas();

        Disciplina disciplina = localizarDisciplina(curso);

        if (disciplina != null) {
            disciplina.listarSituacao();
        }
    }

    private void exibirMenu() {
        System.out.println();
        System.out.println("===== ACADFLOW =====");
        System.out.println("1  - Cadastrar curso");
        System.out.println("2  - Buscar curso");
        System.out.println("3  - Excluir curso");
        System.out.println("4  - Percursos da ABB");
        System.out.println("5  - Matricular aluno no curso");
        System.out.println("6  - Buscar aluno");
        System.out.println("7  - Remover aluno");
        System.out.println("8  - Listar alunos do curso");
        System.out.println("9  - Cadastrar disciplina");
        System.out.println("10 - Solicitar vaga na disciplina");
        System.out.println("11 - Cancelar vaga na disciplina");
        System.out.println("12 - Consultar disciplina e fila");
        System.out.println("0  - Sair");
    }

    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarCurso();
                    break;
                case 2:
                    buscarCurso();
                    break;
                case 3:
                    excluirCurso();
                    break;
                case 4:
                    listarCursos();
                    break;
                case 5:
                    matricularAluno();
                    break;
                case 6:
                    buscarAluno();
                    break;
                case 7:
                    removerAluno();
                    break;
                case 8:
                    listarAlunos();
                    break;
                case 9:
                    cadastrarDisciplina();
                    break;
                case 10:
                    solicitarVaga();
                    break;
                case 11:
                    cancelarVaga();
                    break;
                case 12:
                    consultarDisciplina();
                    break;
                case 0:
                    System.out.println("Encerrando AcadFlow...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }
}
