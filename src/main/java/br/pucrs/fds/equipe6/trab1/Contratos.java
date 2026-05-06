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
    
    //metodos que usei nos endpoints 5,6 e 10

    public Contrato buscarContratoPorId(int id) {
        return contratos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean addContratoValidado(ContratoDTO contratoDTO, Clientela clientes, Jogos jogos) {
        if (buscarContratoPorId(contratoDTO.getId()) != null) return false; // id duplicado

        Cliente cliente = clientes.buscarClienteCPF(contratoDTO.getCpf());
        Jogo jogo = jogos.buscaJogoCod(contratoDTO.getCodigoJogo());

        if (cliente == null || jogo == null) return false;

        Contrato novo = new Contrato(contratoDTO.getId(), new Date(), contratoDTO.getPeriodo(), cliente, jogo);
        contratos.add(novo);
        return true;
    }

}
