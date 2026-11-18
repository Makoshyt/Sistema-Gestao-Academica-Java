
public class Disciplina {
    private int codigo;
    private String nome;
    private int capacidade;
    private ListaAlunos matriculados;
    private FilaEspera fila;
    Disciplina proxima;

    public Disciplina(int codigo, String nome, int capacidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.capacidade = capacidade;
        this.matriculados = new ListaAlunos();
        this.fila = new FilaEspera();
        this.proxima = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getVagasOcupadas() {
        return matriculados.contar();
    }

    public void solicitarVaga(Aluno aluno) {
        int matricula = aluno.getMatricula();

        if (matriculados.buscar(matricula) != null) {
            System.out.println("Aluno ja matriculado na disciplina.");
            return;
        }

        if (fila.buscar(matricula) != null) {
            System.out.println("Aluno ja esta na fila de espera.");
            return;
        }

        if (matriculados.contar() < capacidade) {
            matriculados.adicionar(aluno);
            System.out.println("Matricula na disciplina realizada!");
        } else {
            fila.adicionar(aluno);
            System.out.println("Disciplina lotada. Aluno adicionado a fila.");
        }
    }

    public void cancelarMatricula(int matricula) {
        if (matriculados.remover(matricula)) {
            System.out.println("Matricula na disciplina cancelada.");
            chamarProximo();
        } else if (fila.removerPorMatricula(matricula)) {
            System.out.println("Aluno removido da fila de espera.");
        } else {
            System.out.println("Aluno nao encontrado na disciplina.");
        }
    }

    public void removerAluno(int matricula) {
        fila.removerPorMatricula(matricula);

        if (matriculados.remover(matricula)) {
            chamarProximo();
        }
    }

    private void chamarProximo() {
        if (matriculados.contar() >= capacidade) {
            return;
        }

        Aluno proximo = fila.remover();

        if (proximo != null) {
            matriculados.adicionar(proximo);
            System.out.println("Vaga liberada para: " + proximo.getNome());
        }
    }

    public void listarSituacao() {
        System.out.println("Disciplina: " + nome);
        System.out.println("Codigo: " + codigo);
        System.out.println("Vagas: " + matriculados.contar()
                + "/" + capacidade);

        System.out.println("Alunos matriculados:");
        matriculados.listar();

        System.out.println("Fila de espera:");
        fila.listar();
    }
}
