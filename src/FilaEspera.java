
public class FilaEspera {
    private NoFila inicio;
    private NoFila fim;

    public boolean adicionar(Aluno aluno) {
        if (buscar(aluno.getMatricula()) != null) {
            return false;
        }

        NoFila novo = new NoFila(aluno);

        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

        return true;
    }

    public Aluno buscar(int matricula) {
        NoFila atual = inicio;

        while (atual != null) {
            if (atual.aluno.getMatricula() == matricula) {
                return atual.aluno;
            }

            atual = atual.proximo;
        }

        return null;
    }

    public Aluno remover() {
        if (inicio == null) {
            return null;
        }

        Aluno aluno = inicio.aluno;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        return aluno;
    }

    public boolean removerPorMatricula(int matricula) {
        if (inicio == null) {
            return false;
        }

        if (inicio.aluno.getMatricula() == matricula) {
            remover();
            return true;
        }

        NoFila atual = inicio;

        while (atual.proximo != null) {
            if (atual.proximo.aluno.getMatricula() == matricula) {
                if (atual.proximo == fim) {
                    fim = atual;
                }

                atual.proximo = atual.proximo.proximo;
                return true;
            }

            atual = atual.proximo;
        }

        return false;
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("Fila de espera vazia.");
            return;
        }

        NoFila atual = inicio;
        int posicao = 1;

        while (atual != null) {
            System.out.println(posicao + " - " + atual.aluno);
            atual = atual.proximo;
            posicao++;
        }
    }

    public int contar() {
        int total = 0;
        NoFila atual = inicio;

        while (atual != null) {
            total++;
            atual = atual.proximo;
        }

        return total;
    }
}
