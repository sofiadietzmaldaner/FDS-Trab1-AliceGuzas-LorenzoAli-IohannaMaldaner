package br.pucrs.fds.equipe6.trab1;

import java.util.List;

public class ContratoDTO {
    private int id;
    private int periodo;

    private int codigoJogo;

    private String cpf;
    private String nomeCliente;
    private String nomeJogo;
    private String categoria;

    private List<UsoDTO> usos;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPeriodo() { return periodo; }
    public void setPeriodo(int periodo) { this.periodo = periodo; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public int getCodigoJogo() { return codigoJogo; }
    public void setCodigoJogo(int codigoJogo) { this.codigoJogo = codigoJogo; }
}
