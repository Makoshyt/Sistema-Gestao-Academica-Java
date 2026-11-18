
public class ListaAlunos {
    private NoAluno inicio;

    public boolean adicionar(Aluno aluno) {
        if (buscar(aluno.getMatricula()) != null) {
            return false;
        }

        NoAluno novo = new NoAluno(aluno);

        if (inicio == null) {
            inicio = novo;
        } else {
            NoAluno atual = inicio;

            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novo;
        }

        return true;
    }

    public Aluno buscar(int matricula) {
        NoAluno atual = inicio;

        while (atual != null) {
            if (atual.aluno.getMatricula() == matricula) {
                return atual.aluno;
            }

            atual = atual.proximo;
        }

        return null;
    }

    public boolean remover(int matricula) {
        if (inicio == null) {
            return false;
        }

        if (inicio.aluno.getMatricula() == matricula) {
            inicio = inicio.proximo;
            return true;
        }

        NoAluno atual = inicio;

        while (atual.proximo != null) {
            if (atual.proximo.aluno.getMatricula() == matricula) {
                atual.proximo = atual.proximo.proximo;
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("Nenhum aluno encontrado.");
            return;
        }

        NoAluno atual = inicio;

        while (atual != null) {
            System.out.println(atual.aluno);
            atual = atual.proximo;
        }
    }

    public int contar() {
        int total = 0;
        NoAluno atual = inicio;

        while (atual != null) {
            total++;
            atual = atual.proximo;
        }

        return total;
    }
}
