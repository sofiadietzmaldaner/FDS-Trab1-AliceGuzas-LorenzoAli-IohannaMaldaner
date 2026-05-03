package br.pucrs.fds.equipe6.trab1;


import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teste")
public class Controller{
    private Clientela clientes;
    private Jogos jogos;
    private Contratos contratos;

    public Controller() {
        clientes = new Clientela();
        clientes.addCliente(new Cliente("Sofia Maldener",    "111.111.111-11", "sofia.maldener@pucrs.br",    new Date(), "senha123"));
        clientes.addCliente(new Cliente("Lucas Pereira",     "222.222.222-22", "lucas.pereira@gmail.com",     new Date(), "lucas@456"));
        clientes.addCliente(new Cliente("Ana Beatriz Lima",  "333.333.333-33", "ana.lima@hotmail.com",         new Date(),  "anab789"));
        clientes.addCliente(new Cliente("Carlos Souza",      "444.444.444-44", "carlos.souza@outlook.com",    new Date(), "carl#321"));
        clientes.addCliente(new Cliente("Fernanda Oliveira", "555.555.555-55", "fernanda.oli@yahoo.com",      new Date(), "fern@000"));

        jogos = new Jogos();
        jogos.addJogo(new Jogo(1, "The Last of Us",       2013, 199.90));
        jogos.addJogo(new Jogo(2, "Red Dead Redemption",  2018, 249.99));
        jogos.addJogo(new Jogo(3, "God of War",           2022, 299.90));
        jogos.addJogo(new Jogo(4, "Cyberpunk 2077",       2020, 149.99));
        jogos.addJogo(new Jogo(5, "Elden Ring",           2022, 349.90));

        contratos = new Contratos();
        contratos.addContrato(new Contrato(1, new Date(124, 0,  10), 3600));
        contratos.addContrato(new Contrato(2, new Date(124, 2,  25), 1200));
        contratos.addContrato(new Contrato(3, new Date(124, 5,   3), 8400));
        contratos.addContrato(new Contrato(4, new Date(124, 8,  17), 600));
        contratos.addContrato(new Contrato(5, new Date(124, 11, 31), 2400));
    }

    // Consultar todos os clientes
    @GetMapping("/listaclientes")
    public List<Cliente> getClientes() {
        return clientes.getClientes();
    }

    // Consultar todos os jogos cadastrados
    @GetMapping("/listajogos")
    public List<Jogo> getJogos() {
        return jogos.getJogos();
    }

    //Consultar todos os contratos clientes, jogos e usos correspondentes
    @GetMapping("/listacontratos")
    public List<Contrato> getContratos() {
        return contratos.getContratos();
    }

    @GetMapping("/consultarjogossituacao")
    public List<Jogo> consultaJogoPorSituacao(@RequestParam String situacao) {

        switch (situacao) {
            case "DISPONIVEL":
               return jogos.consultaJogosDisponiveis();
            case "CONTRATADO":
                return jogos.consultaJogosContratados(contratos);
            case "OBSOLETO":
                return jogos.consultaJogosObsoletos(contratos);
            case "REMOVIDO":
                return jogos.consultaJogosRemovidos();
            default:
               return List.of();
        }
    }
}