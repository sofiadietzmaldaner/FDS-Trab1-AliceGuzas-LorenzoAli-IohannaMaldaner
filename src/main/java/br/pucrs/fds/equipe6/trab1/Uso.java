package br.pucrs.fds.equipe6.trab1;

import java.util.Date;

public class Uso {
    private  int numero;
    private  Date dataInicio;
    private  Date dataFim;
    private  int horarioInicio;
    private  int horarioFim;


    public Uso(int numero, Date dataInicio, Date dataFim, int horarioInicio, int horarioFim) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public int getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getHorarioFim() {
        return this.horarioFim;
    }

    public void setHorarioFim(int horarioFim) {
        this.horarioFim = horarioFim;
    }

}