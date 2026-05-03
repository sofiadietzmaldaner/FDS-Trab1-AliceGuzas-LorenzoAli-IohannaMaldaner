package br.pucrs.fds.equipe6.trab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Jogos {

    private List<Jogo> jogos;
    private List<Jogo> jogosRemovidos;

    public Jogos() {
        jogos = new ArrayList<Jogo>();

    }

    public List<Jogo> getJogos() {
        return this.jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    public void addJogo(Jogo j){
        jogos.add(j);
    }

    public void removeJogo(Jogo j){
        jogos.remove(j);
        jogosRemovidos.add(j);
    }

    public List<Jogo> consultaJogosDisponiveis(){
        return jogos;
    }

    public List<Jogo> consultaJogosRemovidos(){
        return jogosRemovidos;
    }

    public List<Jogo> consultaJogosContratados(Contratos contratos) {
        return contratos.getContratos()
                            .stream()
                            .map(c -> (Jogo) c.getJogo())
                            .distinct()
                            .toList();
    }

    public List<Jogo> consultaJogosObsoletos(Contratos contratos) {

    List<Jogo> obsoletos = new ArrayList<>();
    Calendar limite = Calendar.getInstance();
    limite.add(Calendar.YEAR, -2);

    Date dataLimite = limite.getTime();

    for (Jogo jogo : jogos) {

        List<Contrato> contratosDoJogo = contratos.getContratos()
                                        .stream()
                                        .filter(c -> c.getJogo().equals(jogo))
                                        .toList();

        // Caso 1: nunca teve contrato
        if (contratosDoJogo.isEmpty()) {

            Calendar lancamento = Calendar.getInstance();
            lancamento.set(Calendar.YEAR, jogo.getAno());

            if (lancamento.getTime().before(dataLimite)) {
                obsoletos.add(jogo);
                jogo.tornarObsoleto();
            }

        } else {

            // Último contrato do jogo
            Date ultimaDataFim = contratosDoJogo.stream()
                                        .map(c -> c.getDataFim())
                                        .max(Date::compareTo)
                                        .orElse(null);

            // Caso 2: último contrato expirou há mais de 2 anos
            if (ultimaDataFim.before(dataLimite)) {
                obsoletos.add(jogo);
                jogo.tornarObsoleto();
            }
        }
    }

    return obsoletos;
}


}
