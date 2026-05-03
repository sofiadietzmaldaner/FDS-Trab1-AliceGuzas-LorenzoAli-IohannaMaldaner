package br.pucrs.fds.equipe6.trab1;

import java.util.ArrayList;

public class Contratos {

    private ArrayList<Contrato> contratos;

    public Contratos(){
        contratos = new ArrayList<Contrato>();
    }

    public ArrayList<Contrato> getContratos() {
        return this.contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public void addContrato(Contrato c){
        contratos.add(c);
    }



}
