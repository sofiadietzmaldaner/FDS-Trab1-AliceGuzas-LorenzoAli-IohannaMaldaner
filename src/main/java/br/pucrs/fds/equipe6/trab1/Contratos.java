package br.pucrs.fds.equipe6.trab1;

import java.util.ArrayList;
import java.util.List;

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

    public List<Contrato> consultarContratosCompletos() {
        return contratos.stream()
                .toList();
    }

    public List<Contrato> getContratosPorCpf(String cpf) {
        return contratos.stream()
                .filter(c -> c.getCliente().getCPF().equals(cpf))
                .toList();
    }

}
