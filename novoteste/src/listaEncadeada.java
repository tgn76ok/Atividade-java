public class listaEncadeada {
    private materias inicio;
    private materias fim;
    private int tamanho = 0;

    public void adiciona(materias celula) {

        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.fim.setProximo(celula);
            // aponto para a nova celula
        }
        // apois isso seto essa nova celula como ultimo
        this.fim = celula;
        this.tamanho++;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public materias getInicio() {
        return inicio;
    }

    public materias getDisplinas() {
        return inicio;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        materias atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getDiciplina()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getDiciplina()).append("]");
        return builder.toString();
    }

}
