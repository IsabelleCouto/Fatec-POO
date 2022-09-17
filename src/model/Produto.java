package model;

public class Produto {
    private String nome;
    private double preco;
    private int qtd;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void addQtd(int qtd) {
        this.qtd += qtd;
    }

    public void removeQtd(int qtd) {
        this.qtd -= qtd;
    }
}
