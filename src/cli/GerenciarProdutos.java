package cli;

import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciarProdutos {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarProdutos gp = new GerenciarProdutos();
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            exibirMenu();

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    if (gp.produtos.add(inputProduto(gp, sc)))
                        System.out.println("Produto adicionado com sucesso!");
                    else
                        System.out.println("Produto nao pode ser adicionado :( ");

                    break;

                case 2:
                    exibirProdutos(gp);

                    int cod = getCod(gp, sc);
                    int qtd = getQtd(sc);
                    gp.produtos.get(cod - 1).addQtd(qtd);
                    System.out.printf("Foram adicionados %d (%s) produtos com sucesso!\n", qtd, gp.produtos.get(cod - 1).getNome());
                    break;

                case 3:
                    exibirProdutos(gp);

                    int codigo = getCod(gp, sc);
                    int quantidade = getQtd(sc);
                    gp.produtos.get(codigo - 1).removeQtd(quantidade);
                    System.out.printf("Foram retirados %d (%s) produtos com sucesso!\n", quantidade, gp.produtos.get(codigo - 1).getNome());
                    break;

                case 4:
                    exibirEstoqueTotal(gp);
                    break;

                case 9:
                    System.out.println("Ate mais!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (op != 9);
    }

    private static void exibirMenu() {
        System.out.println("Projeto Inventario");
        System.out.println("1 - Cadastrar Produtos");
        System.out.println("2 - Entrada de Produtos");
        System.out.println("3 - Saida de Produtos");
        System.out.println("4 - Estoque atual da loja");
        System.out.println("9 - Sair");
        System.out.println("Digite a opcao desejada: ");
    }

    private static int getQtd(Scanner sc) {
        System.out.println("Digite a quantidade do produto: ");
        int qtd = Integer.parseInt(sc.nextLine());
        return qtd;
    }

    private static int getCod(GerenciarProdutos gp, Scanner sc) {
        System.out.println("Digite o codigo do produto: ");
        int cod = Integer.parseInt(sc.nextLine());
        Produto produto = gp.produtos.get(cod - 1);
        return cod;
    }

    private static void exibirEstoqueTotal(GerenciarProdutos gp) {
        double total = 0;
        System.out.println("Estoque atual: ");
        for (Produto prod : gp.produtos
        ) {
            System.out.println("Codigo " + Integer.toString(prod.getCodigo()) +
                    " - Produto " + prod.getNome() +
                    " - Quantidade " + Integer.toString(prod.getQtd()) +
                    " - Valor R$" + Double.toString(prod.getPreco()) +
                    " - Total R$" + Double.toString(prod.getQtd() * prod.getPreco()));
            total = total + prod.getQtd() * prod.getPreco();
        }
        System.out.printf("Valor total do estoque: R$%.2f\n", total);
    }

    private static Produto inputProduto(GerenciarProdutos gp, Scanner sc) {
        Produto pd = new Produto();
        System.out.println("Digite o nome do produto: ");
        pd.setNome(sc.nextLine());
        System.out.println("Digite o valor do produto: ");
        pd.setPreco(Double.parseDouble(sc.nextLine()));
        pd.setCodigo(gp.produtos.size() + 1);
        return pd;
    }

    private static void exibirProdutos(GerenciarProdutos gp) {
        for (Produto pdt : gp.produtos
        ) {
            System.out.println("Codigo " + Integer.toString(pdt.getCodigo()) +
                    " - Produto " + pdt.getNome() +
                    " - Valor R$" + Double.toString(pdt.getPreco()));
        }
    }
}