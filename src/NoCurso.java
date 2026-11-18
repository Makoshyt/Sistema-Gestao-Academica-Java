public class NoCurso {

    Curso curso;
    NoCurso esquerda;
    NoCurso direita;

    public NoCurso(Curso curso) {
        this.curso = curso;
        this.esquerda = null;
        this.direita = null;
    }
}
