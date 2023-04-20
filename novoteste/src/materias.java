public class materias {
    String diciplina;
    float nota;

    materias proximo = null;

    public materias(float nota, String diciplina) {

        this.diciplina = diciplina;
        this.nota = nota;
    }

    public materias() {

    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public materias getProximo() {
        return proximo;
    }

    public void setProximo(materias proximo) {
        this.proximo = proximo;
    }

}
