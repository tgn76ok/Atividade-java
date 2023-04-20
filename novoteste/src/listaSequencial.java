
public class listaSequencial {
    Aluno[] lista = new Aluno[60];
    int tamanho = 0;

    public boolean estaVazia() {
        return (tamanho == 0);
    }

    public boolean estaCheia() {
        return (tamanho == lista.length);
    }

    public int tamanhoLista() {
        return (tamanho);
    }

    public int buscarBinariaParaSetONovolugar(int number) {

        int inicio = 0;
        int fim = tamanho - 1;
        int meio = (int) ((tamanho - 1) / 2);
        // verifica se pos e valida

        while (inicio <= fim) {

            meio = (int) ((inicio + fim) / 2);

            if (lista[meio].matricula == number) {

                return meio;
            } else if (lista[meio].matricula < number) {

                inicio = meio + 1;
            } else { // só pode ser maior
                fim = meio - 1;
            }

            if (inicio == fim) {

                return inicio;
            }
        }
        return meio;

    }

    public boolean temEsseItemNaLista(int number) {

        boolean achou = false;
        int inicio = 0;
        int fim = tamanho - 1;
        int meio = (int) ((tamanho - 1) / 2);
        // verifica se pos e valida

        while (inicio <= fim) {

            meio = (int) ((inicio + fim) / 2);

            if (lista[meio].matricula == number) {
                achou = true;
                break;
            } else if (lista[meio].matricula < number) {

                inicio = meio + 1;
            } else { // só pode ser maior
                fim = meio - 1;
            }

        }
        if (achou) {
            return true;
        } else {
            return false;
        }

    }

    public void deslocarParaDireita(int pos) {
        for (int i = tamanho; i > pos; i--)
            lista[i] = lista[i - 1];
    }

    public boolean inserirAluno(Aluno c1) {
        if (estaCheia())
            return false;

        if (tamanho == 0) {
            lista[0] = c1;
            tamanho++;
            return true;
        }
        if (tamanho == 1) {
            if (c1.matricula > lista[0].matricula) {
                lista[1] = c1;
                tamanho++;
                return true;
            } else {

                deslocarParaDireita(0);
                lista[0] = c1;
                tamanho++;
            }

        } else {
            int novolugar = buscarBinariaParaSetONovolugar(c1.matricula);

            if (lista[novolugar].matricula <= c1.matricula) {
                deslocarParaDireita(novolugar + 1);
                lista[novolugar + 1] = c1;
                tamanho++;

                return true;
            } else {
                deslocarParaDireita(novolugar);
                lista[novolugar] = c1;
                tamanho++;

                return true;
            }
        }

        // deslocarParaDireita(pos);
        // lista[pos] = c1;
        // tamanho++;
        return false;
    }

    public void deslocarParaEsquerda(int pos) {
        for (int i = pos; i < (tamanho - 1); i++)
            lista[i] = lista[i + 1];
    }

    public Aluno removerAlunoPelaMatricula(int matriculaRemover) {
        if (estaVazia())
            return null;

        if (!temEsseItemNaLista(matriculaRemover))
            return null;

        int lugarRemovido = buscarBinariaParaSetONovolugar(matriculaRemover);
        Aluno aux = lista[lugarRemovido];// tenho que endeter
        deslocarParaEsquerda(lugarRemovido);
        tamanho--;
        return aux;
    }

    public Aluno removerAlunoPeloId(int id) {
        if (estaVazia() || id < tamanho || id > tamanho)
            return null;

        Aluno aux = lista[id];// tenho que endeter
        deslocarParaEsquerda(id);
        tamanho--;
        return aux;
    }

    public void limparListaEncadeada(int rgm) {
        int id = buscarBinariaParaSetONovolugar(rgm);

        for (materias atual = lista[id].inicio; atual != null;) {
            materias proximo = atual.getProximo();
            atual.setDiciplina(null);
            atual.setNota(0);
            atual.setProximo(null);
            atual = proximo;
        }

        lista[id].inicio = null;
        lista[id].setPrimeiro(null);

    }

    public void exibirLista() {
        String mensage = "";
        if (tamanho == 0) {
            System.out.println("|---------------------|");
            System.out.println("|  Estamos sem alunos |");
            System.out.println("|---------------------|");

        } else {

            for (int i = 0; i < tamanho; i++) {
                materias atual = lista[i].inicio;
                if (tamanho > 1) {
                    while (atual.getProximo() != null) {

                        mensage += atual.getDiciplina() + ", ";
                        atual = atual.getProximo();
                    }
                    mensage += atual.getDiciplina();
                }

                mensage = (mensage.equals("")) ? " Nao tem disiplinas" : mensage;
                System.out
                        .println("-----------------" +
                                "\nID do Aluno " + (i + 1) +
                                "\nMatricula: " + lista[i].matricula
                                + "\ndiciplinas: " + mensage
                                + "\n-----------------");
                mensage = "";
            }
        }

    }

    public void exibirListaUmElemenoto(int id) {
        String mensage = "";
        if (tamanho == 0) {
            System.out.println("|---------------------|");
            System.out.println("|  Estamos sem alunos |");
            System.out.println("|---------------------|");

        } else {

            materias atual = lista[id].inicio;
            if (tamanho > 1) {
                while (atual.getProximo() != null) {

                    mensage += atual.getDiciplina() + ", ";
                    atual = atual.getProximo();
                }
                mensage += atual.getDiciplina();
            }

            mensage = (mensage.equals("")) ? " Nao tem disiplinas" : mensage;
            System.out
                    .println("-----------------------------" +
                            "\nID do Aluno " + (id + 1) +
                            "\nMatricula: " + lista[id].matricula
                            + "\ndiciplinas: " + mensage
                            + "\n-----------------------------");
            mensage = "";

        }
    }

}
