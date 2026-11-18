
public class ArvoreCursos {

    private NoCurso raiz;

    public ArvoreCursos() {
        this.raiz = null;
    }

    public boolean inserir(Curso curso) {
        if (curso == null) {
            return false;
        }

        if (buscar(curso.getCodigo()) != null) {
            return false;
        }

        raiz = inserirNo(raiz, curso);
        return true;
    }

    private NoCurso inserirNo(NoCurso no, Curso curso) {
        if (no == null) {
            return new NoCurso(curso);
        }

        if (curso.getCodigo() < no.curso.getCodigo()) {
            no.esquerda = inserirNo(no.esquerda, curso);
        } else if (curso.getCodigo() > no.curso.getCodigo()) {
            no.direita = inserirNo(no.direita, curso);
        }

        return no;
    }

    public Curso buscar(int codigo) {
        NoCurso atual = raiz;

        while (atual != null) {
            if (codigo == atual.curso.getCodigo()) {
                return atual.curso;
            }

            if (codigo < atual.curso.getCodigo()) {
                atual = atual.esquerda;
            } else {
                atual = atual.direita;
            }
        }

        return null;
    }

    public boolean remover(int codigo) {
        if (buscar(codigo) == null) {
            return false;
        }

        raiz = removerNo(raiz, codigo);
        return true;
    }

    private NoCurso removerNo(NoCurso no, int codigo) {
        if (no == null) {
            return null;
        }

        if (codigo < no.curso.getCodigo()) {
            no.esquerda = removerNo(no.esquerda, codigo);
        } else if (codigo > no.curso.getCodigo()) {
            no.direita = removerNo(no.direita, codigo);
        } else {

            if (no.esquerda == null && no.direita == null) {
                return null;
            }

            if (no.esquerda == null) {
                return no.direita;
            }

            if (no.direita == null) {
                return no.esquerda;
            }

            NoCurso sucessor = menorNo(no.direita);
            no.curso = sucessor.curso;

            no.direita = removerNo(
                no.direita,
                sucessor.curso.getCodigo()
            );
        }

        return no;
    }

    private NoCurso menorNo(NoCurso no) {
        NoCurso atual = no;

        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        return atual;
    }

    public void emOrdem() {
        System.out.println("=== CURSOS EM ORDEM ===");
        percorrerEmOrdem(raiz);
    }

    private void percorrerEmOrdem(NoCurso no) {
        if (no == null) {
            return;
        }

        percorrerEmOrdem(no.esquerda);
        System.out.println(no.curso);
        percorrerEmOrdem(no.direita);
    }

    public void preOrdem() {
        System.out.println("=== CURSOS EM PRE-ORDEM ===");
        percorrerPreOrdem(raiz);
    }

    private void percorrerPreOrdem(NoCurso no) {
        if (no == null) {
            return;
        }

        System.out.println(no.curso);
        percorrerPreOrdem(no.esquerda);
        percorrerPreOrdem(no.direita);
    }

    public void posOrdem() {
        System.out.println("=== CURSOS EM POS-ORDEM ===");
        percorrerPosOrdem(raiz);
    }

    private void percorrerPosOrdem(NoCurso no) {
        if (no == null) {
            return;
        }

        percorrerPosOrdem(no.esquerda);
        percorrerPosOrdem(no.direita);
        System.out.println(no.curso);
    }
}
