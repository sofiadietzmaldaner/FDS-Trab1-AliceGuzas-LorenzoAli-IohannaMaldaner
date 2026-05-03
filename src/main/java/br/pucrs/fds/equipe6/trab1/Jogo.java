package br.pucrs.fds.equipe6.trab1;

import java.util.Date;

public class Jogo {
    private int cod;
    private String nome;
    private int ano;
    private double valorMinuto;
    private Categoria categoria;
    private boolean removido;
    private Date dataObsolescencia;


    public Jogo(int cod, String nome, int ano, double valorMinuto) {
        this.cod = cod;
        this.nome = nome;
        this.ano = ano;
        this.valorMinuto = valorMinuto;
    }

    public void tornarObsoleto() {
        this.dataObsolescencia = new Date();
    }

    public boolean isRemovido() {
        return removido;
    }

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorMinuto() {
        return this.valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public void setRemovido(boolean removido) {
        this.removido = removido;
    }

}