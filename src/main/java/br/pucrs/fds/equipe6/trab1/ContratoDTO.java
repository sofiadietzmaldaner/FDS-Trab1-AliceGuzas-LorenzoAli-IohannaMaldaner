package br.pucrs.fds.equipe6.trab1;

public class ContratoDTO {
    private int id;
    private int periodo;
    private String cpf;
    private int codigoJogo;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPeriodo() { return periodo; }
    public void setPeriodo(int periodo) { this.periodo = periodo; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getCodigoJogo() { return codigoJogo; }
    public void setCodigoJogo(int codigoJogo) { this.codigoJogo = codigoJogo; }
}
