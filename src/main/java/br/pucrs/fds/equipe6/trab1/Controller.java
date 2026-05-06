package br.pucrs.fds.equipe6.trab1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/acmespiele")
public class Controller{
    private Clientela clientes;
    private Jogos jogos;
    private Contratos contratos;
    private Categorias categorias;

    public Controller() {
        clientes = new Clientela();
        clientes.addCliente(new Cliente("Sofia Maldener",    "111.111.111-11", "sofia.maldener@pucrs.br",    new Date(), "senha123"));
        clientes.addCliente(new Cliente("Lucas Pereira",     "222.222.222-22", "lucas.pereira@gmail.com",     new Date(), "lucas@456"));
        clientes.addCliente(new Cliente("Ana Beatriz Lima",  "333.333.333-33", "ana.lima@hotmail.com",         new Date(),  "anab789"));
        clientes.addCliente(new Cliente("Carlos Souza",      "444.444.444-44", "carlos.souza@outlook.com",    new Date(), "carl#321"));
        clientes.addCliente(new Cliente("Fernanda Oliveira", "555.555.555-55", "fernanda.oli@yahoo.com",      new Date(), "fern@000"));

        categorias = new Categorias();
        categorias.addCategoria(new Categoria(1, "Shooter", 100.00));
        categorias.addCategoria(new Categoria(2, "RPG", 200.00));
        categorias.addCategoria(new Categoria(3, "Luta", 50.50));
        categorias.addCategoria(new Categoria(4, "Simulador", 300.99));
        categorias.addCategoria(new Categoria(5, "Aventura", 150.00));

        jogos = new Jogos();
        jogos.addJogo(new Jogo(1, "The Last of Us",       2013, 199.90, categorias.getCategoriaPorNome("Aventura")));
        jogos.addJogo(new Jogo(2, "Red Dead Redemption",  2018, 249.99, categorias.getCategoriaPorNome("Aventura")));
        jogos.addJogo(new Jogo(3, "God of War",           2022, 299.90, categorias.getCategoriaPorNome("Aventura")));
        jogos.addJogo(new Jogo(4, "Cyberpunk 2077",       2020, 149.99, categorias.getCategoriaPorNome("Shooter")));
        jogos.addJogo(new Jogo(5, "Elden Ring",           2022, 349.90, categorias.getCategoriaPorNome("RPG")));
        jogos.addJogo(new Jogo(6, "Fifa",                 2016, 150.00, categorias.getCategoriaPorNome("Simulador")));
        jogos.addJogo(new Jogo(7, "CS 2",                 2023, 349.90, categorias.getCategoriaPorNome("Shooter")));
        jogos.addJogo(new Jogo(8, "EA FC 26",                 2026, 349.90, categorias.getCategoriaPorNome("Simulador")));
        jogos.addJogo(new Jogo(9, "The Witcher 3",                 2015, 349.90, categorias.getCategoriaPorNome("RPG")));
        jogos.addJogo(new Jogo(10, "GTA VI",                 2026, 349.90, categorias.getCategoriaPorNome("Shooter")));
        jogos.addJogo(new Jogo(10, "THE SIMS",                 2025, 349.90, categorias.getCategoriaPorNome("Simulador")));


        contratos = new Contratos();

        // Contrato de God Of War
        contratos.addContrato(
            new Contrato(
                1,
                new Date(125, 10, 10), // 2025
                3600,
                clientes.getClientes().get(0),
                jogos.getJogos().get(2),
                new Uso(
                    1,
                    new Date(126, 3, 1),  // abril 2026
                    new Date(126, 3, 10),
                    14,
                    18
                )
            )
        );
        // Contrato de Elden Ring
        contratos.addContrato(
            new Contrato(
                2,
                new Date(126, 1, 15), // 2026
                2400,
                clientes.getClientes().get(1),
                jogos.getJogos().get(4),
                new Uso(
                    2,
                    new Date(126, 1, 15),
                    new Date(126, 1, 20),
                    9,
                    12
                )
            )
        );

        //Contrato Obsoleto Red Dead
        contratos.addContrato(
            new Contrato(
                3,
                new Date(121, 2, 10), // 2021
                1200,
                clientes.getClientes().get(2),
                jogos.getJogos().get(1),
                new Uso(
                    3,
                    new Date(121, 2, 10),
                    new Date(121, 2, 15),
                    19,
                    22
                )
            )
        );
        //Contrato The Last of Us Removido
        contratos.addContrato(
            new Contrato(
                4,
                new Date(118, 5, 5), // 2018
                600,
                clientes.getClientes().get(3),
                jogos.getJogos().get(0),
                new Uso(
                    4,
                    new Date(118, 5, 5),
                    new Date(118, 5, 8),
                    10,
                    11
                )
            )
        );
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
    public List<Contrato> consultarContratos() {
        return contratos.getContratos();
    }

    // Consultar jogos por situação Disponivel, Contratado, Obsoleto ou Removido
    @GetMapping("/consultarjogossituacao/{situacao}")
    public List<Jogo> consultaJogoPorSituacao(@PathVariable String situacao) {
        jogos.atualizarSituacaoJogos(contratos);
        return jogos.consultaJogos(situacao);
    }

    // Calcula cobrança total de um cliente
    @GetMapping("/consultatotalcliente")
    public double consultaCobrancaPorCpf(@RequestParam String cpf) {
        double valorTotal = 0;
        List<Contrato> contratosCliente = contratos.getContratosPorCpf(cpf);

        for (Contrato c : contratosCliente) {
            double valorBase = c.getJogo().getCategoria().getValorMinimo();
            double valorMinuto = c.getJogo().getValorMinuto();

            for (Uso u : c.getUsos()) {
                long minutos = u.getDuracaoMinutos();
                double valorCalculado = valorBase + (minutos * valorMinuto);

                if (valorCalculado > 500) {
                    valorTotal += valorCalculado * 0.97;
                } else {
                    valorTotal += valorCalculado;
                }
            }
        }

        return valorTotal;
    }
}