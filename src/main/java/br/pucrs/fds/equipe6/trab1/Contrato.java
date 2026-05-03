package br.pucrs.fds.equipe6.trab1;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Contrato {
    private int id;
    private Date data;
    private int periodo;
    private Cliente cliente;
    private Jogo jogo;
    private List<Uso> usos;


    public Contrato(int id, Date data, int periodo) {
        this.id = id;
        this.data = data;
        this.periodo = periodo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Jogo getJogo(){
        return this.jogo;
    }

    // Consulta a data final do contrato data + periodo
    public Date getDataFim() {

        Calendar cal = Calendar.getInstance();
        cal.setTime(data);

        cal.add(Calendar.DAY_OF_MONTH, periodo);

        return cal.getTime();
    }

}