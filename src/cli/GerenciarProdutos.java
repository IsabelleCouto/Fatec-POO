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
            System.out.println("Projeto Inventario");
            System.out.println("1 - Cadastrar Produtos");
            System.out.println("2 - Entrada de Produtos");
            System.out.println("3 - Saida de Produtos");
            System.out.println("4 - Estoque atual da loja");
            System.out.println("9 - Sair");
            System.out.println("Digite a opcao desejada: ");

            op = Integer.parseInt(sc.nextLine());

            switch (op) {

                case 1:
                    Produto pd = new Produto();
                    System.out.println("Digite o nome do produto: ");
                    pd.setNome(sc.nextLine());
                    System.out.println("Digite o valor do produto: ");
                    pd.setPreco(Double.parseDouble(sc.nextLine()));
                    pd.setCodigo(gp.produtos.size() + 1);
                    if (gp.produtos.add(pd))
                        System.out.println("Produto adicionado com sucesso!");
                    else
                        System.out.println("Produto nao pode ser adicionado :( ");

                    break;

                case 2:
                    for (Produto pdt : gp.produtos
                    ) {
                        System.out.println("Codigo " + Integer.toString(pdt.getCodigo()) +
                                " - Produto " + pdt.getNome() +
                                " - Valor R$" + Double.toString(pdt.getPreco()));
                    }

                    System.out.println("Digite o codigo do produto: ");
                    int cod = Integer.parseInt(sc.nextLine());
                    System.out.println("Digite a quantidade do produto: ");
                    int qtd = Integer.parseInt(sc.nextLine());
                    gp.produtos.get(cod - 1).setQtd(gp.produtos.get(cod - 1).getQtd() + qtd);
                    System.out.printf("Foram adicionados %d (%s) produtos com sucesso!\n", qtd, gp.produtos.get(cod - 1).getNome());
                    break;

                case 3:
                    for (Produto pdt : gp.produtos
                    ) {
                        System.out.println("Codigo " + Integer.toString(pdt.getCodigo()) +
                                " - Produto " + pdt.getNome() +
                                " - Valor R$" + Double.toString(pdt.getPreco()));
                    }

                    System.out.println("Digite o codigo do produto: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = Integer.parseInt(sc.nextLine());
                    gp.produtos.get(codigo - 1).setQtd(gp.produtos.get(codigo - 1).getQtd() - quantidade);
                    System.out.printf("Foram retirados %d (%s) produtos com sucesso!\n", quantidade, gp.produtos.get(codigo - 1).getNome());
                    break;

                case 4:
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
}