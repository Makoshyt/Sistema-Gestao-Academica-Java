
public class Curso {
    private int codigo;
    private String nome;
    private ListaAlunos alunos;
    private Disciplina disciplinas;

    public Curso(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = new ListaAlunos();
        this.disciplinas = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public ListaAlunos getAlunos() {
        return alunos;
    }

    public boolean adicionarDisciplina(Disciplina disciplina) {
        if (buscarDisciplina(disciplina.getCodigo()) != null) {
            return false;
        }

        if (disciplinas == null) {
            disciplinas = disciplina;
        } else {
            Disciplina atual = disciplinas;

            while (atual.proxima != null) {
                atual = atual.proxima;
            }

            atual.proxima = disciplina;
        }

        return true;
    }

    public Disciplina buscarDisciplina(int codigo) {
        Disciplina atual = disciplinas;

        while (atual != null) {
            if (atual.getCodigo() == codigo) {
                return atual;
            }

            atual = atual.proxima;
        }

        return null;
    }

    public void listarDisciplinas() {
        if (disciplinas == null) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        Disciplina atual = disciplinas;

        while (atual != null) {
            System.out.println(atual.getCodigo() + " - "
                    + atual.getNome());
            atual = atual.proxima;
        }
    }

    public boolean removerAluno(int matricula) {
        if (alunos.buscar(matricula) == null) {
            return false;
        }

        Disciplina atual = disciplinas;

        while (atual != null) {
            atual.removerAluno(matricula);
            atual = atual.proxima;
        }

        return alunos.remover(matricula);
    }

    public String toString() {
        return codigo + " - " + nome;
    }
}
