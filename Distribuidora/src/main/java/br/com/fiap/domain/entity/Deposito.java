package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "TB_DEPOSITO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_DEPOSITO", columnNames = "NM_DEPOSITO")
})
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPOSITO")
    @SequenceGenerator(name = "SQ_DEPOSITO", sequenceName = "SQ_DEPOSITO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_DEPOSITO")
    private Long id;
    @Column(name = "NM_DEPOSITO", nullable = false)
    private String nome;

    //SHIFT + SHIFT -> "Encapsulate Fields"

    public Deposito() {}

    public Deposito(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Deposito setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Deposito setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
