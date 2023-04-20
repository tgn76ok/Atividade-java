public class Aluno {
    int matricula;
    materias inicio;

    public Aluno() {
    }

    public Aluno(int matricula) {
        this.matricula = matricula;

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public materias getPrimeiro() {
        return inicio;
    }

    public void setPrimeiro(materias primeiro) {
        this.inicio = primeiro;
    }

}
