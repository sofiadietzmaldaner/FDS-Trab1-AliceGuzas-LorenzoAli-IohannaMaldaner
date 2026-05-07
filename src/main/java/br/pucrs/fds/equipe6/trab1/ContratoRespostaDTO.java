package br.pucrs.fds.equipe6.trab1;

import java.util.List;

public class ContratoRespostaDTO {

    private int id;
    private int periodo;

    private String cpf;
    private String nomeCliente;

    private int codigoJogo;
    private String nomeJogo;
    private String categoria;

    private List<UsoDTO> usos;

    public ContratoRespostaDTO(Contrato c) {
        this.id = c.getId();
        this.periodo = c.getPeriodo();

        this.cpf = c.getCliente().getCPF();
        this.nomeCliente = c.getCliente().getNome();

        this.codigoJogo = c.getJogo().getCod();
        this.nomeJogo = c.getJogo().getNome();
        this.categoria = c.getJogo()
                          .getCategoria()
                          .getNome();

        this.usos = c.getUsos()
                     .stream()
                     .map(UsoDTO::new)
                     .toList();
    }


    public int getId() {return this.id;}

    public void setId(int id) {this.id = id;}

    public int getPeriodo() {return this.periodo;}

    public void setPeriodo(int periodo) {this.periodo = periodo;}

    public String getCpf() {return this.cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getNomeCliente() {return this.nomeCliente;}

    public void setNomeCliente(String nomeCliente) {this.nomeCliente = nomeCliente; }

    public int getCodigoJogo() {return this.codigoJogo;}

    public void setCodigoJogo(int codigoJogo) {this.codigoJogo = codigoJogo;}

    public String getNomeJogo() {return this.nomeJogo;}

    public void setNomeJogo(String nomeJogo) {this.nomeJogo = nomeJogo;}

    public String getCategoria() {return this.categoria;}

    public void setCategoria(String categoria) {this.categoria = categoria;}

    public List<UsoDTO> getUsos() {return this.usos;}

    public void setUsos(List<UsoDTO> usos) {this.usos = usos;}


}
