package br.com.fiap.domain.entity;

import java.time.LocalDateTime;

public class ProdutoEstoque {

    private Long id;
    private Produto produto;
    private Deposito deposito;
    private String numeroDeSerie;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public ProdutoEstoque() {}

    public ProdutoEstoque(Long id, Produto produto, Deposito deposito, String numeroDeSerie, LocalDateTime entrada, LocalDateTime saida) {
        this.id = id;
        this.produto = produto;
        this.deposito = deposito;
        this.numeroDeSerie = numeroDeSerie;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Long getId() {
        return id;
    }

    public ProdutoEstoque setId(Long id) {
        this.id = id;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ProdutoEstoque setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public ProdutoEstoque setDeposito(Deposito deposito) {
        this.deposito = deposito;
        return this;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public ProdutoEstoque setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
        return this;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public ProdutoEstoque setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
        return this;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public ProdutoEstoque setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    @Override
    public String toString() {
        return "ProdutoEstoque{" +
                "id=" + id +
                ", produto=" + produto +
                ", deposito=" + deposito +
                ", numeroDeSerie='" + numeroDeSerie + '\'' +
                ", entrada=" + entrada +
                ", saida=" + saida +
                '}';
    }
}
