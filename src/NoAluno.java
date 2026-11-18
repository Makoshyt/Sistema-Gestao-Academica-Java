public class NoAluno {
    Aluno aluno;
    NoAluno proximo;

    public NoAluno(Aluno aluno) {
        this.aluno = aluno;
        this.proximo = null;
    }
}
