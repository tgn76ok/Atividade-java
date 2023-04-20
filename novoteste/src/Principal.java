import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean continuar = true;
        listaSequencial listaPrincipa = new listaSequencial();
        FuncoesMenu menu = new FuncoesMenu();

        while (continuar) {
            menu.menu();
            Scanner entrada = new Scanner(System.in);
            System.out.print(">>>");
            int key = entrada.nextInt();
            switch (key) {
                case 1:
                    listaEncadeada listaSecundaria = new listaEncadeada();
                    Aluno estudante = new Aluno();
                    System.out.print("Qual seu rgm? ");
                    estudante.setMatricula(entrada.nextInt());
                    entrada.nextLine();
                    System.out.print("Quer adcionar uma diciplina? [s/n] ");
                    String ops = entrada.nextLine();

                    if (ops.toLowerCase().equals("s")) {
                        while (true) {

                            materias diciplina = new materias();
                            System.out.print("\nDigite o nome da disiplina? ");
                            diciplina.setDiciplina(entrada.nextLine());
                            System.out.print("Digite a nota total? ");
                            diciplina.setNota(entrada.nextInt());

                            System.out.println("----------\n" +
                                    "A displina: " + diciplina.getDiciplina() + "\nA nota : " + diciplina.nota);

                            System.out.print("Quer salvar? [s/n] ");

                            entrada.nextLine();
                            String varificar = entrada.nextLine();

                            if (varificar.toLowerCase().equals("s") == true) {
                                listaSecundaria.adiciona(diciplina);
                            } else {
                                System.out.println("ENTAO NAO SALVOU");
                            }

                            System.out.print("Quer continuar adicionado disiplina? [s/n]");
                            String terminar = entrada.nextLine();
                            if (terminar.toLowerCase().equals("n")) {

                                estudante.setPrimeiro(listaSecundaria.getInicio());
                                listaPrincipa.inserirAluno(estudante);

                                break;
                            }

                        }

                    } else if (ops.toLowerCase().equals("n")) {
                        listaPrincipa.inserirAluno(estudante);
                    } else {
                        System.out.println("Resposta invalida");
                    }
                    break;

                case 2:
                    int rgm = entrada.nextInt();
                    System.out.print("Digite o Rgm que voce quer remover: ");
                    listaPrincipa.removerAlunoPelaMatricula(rgm);
                    listaPrincipa.exibirLista();
                    break;

                case 3:

                    System.out.print("Digite o ID que voce quer remover: ");
                    int id = entrada.nextInt();
                    listaPrincipa.removerAlunoPeloId(id);
                    listaPrincipa.exibirLista();

                    break;

                case 4:
                    System.out.println("Digite a rgm que voce quer?");
                    int rgmBusca = entrada.nextInt();

                    if (listaPrincipa.temEsseItemNaLista(rgmBusca)) {
                        int resultadoDaBusca = listaPrincipa.buscarBinariaParaSetONovolugar(rgmBusca);
                        System.out.println(resultadoDaBusca);
                        listaPrincipa.exibirListaUmElemenoto(resultadoDaBusca);

                    } else {
                        System.out.println(
                                "------------------------------------" +
                                        "NAO EXISTE NENHUM ALUNO COM ESSE RGM" +
                                        "------------------------------------");
                    }

                    break;

                case 5:
                    listaPrincipa.exibirLista();
                    System.out.print("\nprecione enter para sair... ");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;

                // case 6:
                // if (listaPrincipa.tamanho <= 0) {
                // System.out.println("NENHUM ELEMENTO NA LISTA");
                // break;
                // }

                // System.out.println("Digite o rgm que voce quer adiconar as disiplinas? ");
                // int rgmBuscaAdicona = entrada.nextInt();

                // if (listaPrincipa.temEsseItemNaLista(rgmBuscaAdicona)) {
                // int resultadoDaBusca =
                // listaPrincipa.buscarBinariaParaSetONovolugar(rgmBuscaAdicona);
                // materias atual = listaPrincipa.lista[resultadoDaBusca].inicio;

                // if (atual.getProximo() == null) {
                // materias novo = new materias();
                // novo.setDiciplina("POO");
                // atual.setProximo(novo);
                // }
                // // do {
                // // atual = atual.getProximo();
                // // } while ((atual.getProximo() != null));

                // } else {
                // System.out.println("ESSE ALUNO NAO TEM DISIPLINA");
                // }
                // break;
                case 6:
                    if (listaPrincipa.tamanho <= 0) {
                        System.out.println(
                                "-------------------------" +
                                        "NENHUM ELEMENTO NA LISTA" + "-------------------------");
                        break;
                    }
                    System.out.println("Digite o rgm que voce quer remover as disiplinas? ");
                    int rgmBuscaRemove = entrada.nextInt();

                    if (listaPrincipa.temEsseItemNaLista(rgmBuscaRemove)) {
                        int resultadoDaBusca = listaPrincipa.buscarBinariaParaSetONovolugar(rgmBuscaRemove);
                        listaPrincipa.limparListaEncadeada(resultadoDaBusca);

                    } else {
                        System.out.println(
                                "-----------------------------" +
                                        "ESSE ALUNO NAO TEM DISIPLINA" + "-----------------------------");
                    }
                    break;
                case 7:
                    continuar = false;
                    entrada.close();

                    break;

                default:
                    entrada.close();
                    break;
            }
        }

    }
}
