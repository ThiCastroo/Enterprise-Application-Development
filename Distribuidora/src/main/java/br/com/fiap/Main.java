package br.com.fiap;

import br.com.fiap.domain.entity.Deposito;
import br.com.fiap.domain.entity.Produto;
import br.com.fiap.domain.entity.ProdutoEstocado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Deposito d1 = new Deposito();
        d1.setId(null).setNome("Avenida Interlagos");

        Deposito d2 = new Deposito();
        d2.setId(null).setNome("Santo Amaro");

        var prod1 = new Produto();
        var prod2 = new Produto();

        prod1.setNome("Oculos").setDescricao("De sol").setValor(BigDecimal.valueOf(699.99));
        prod2.setNome("Carteira").setDescricao("Masculina").setValor(BigDecimal.valueOf(350.90));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(d1);
        manager.persist(d2);
        manager.persist(prod1);
        manager.persist(prod2);

        int cont = 0;
        int qtd = 10;
        while (cont<qtd) {
            var item1 = new ProdutoEstocado();
            var item2 = new ProdutoEstocado();

            item1.setDeposito(d1).setProduto(prod1).setEntrada(LocalDateTime.now()).setNumeroDeSerie(cont + "NR" + prod1.getId());
            item2.setDeposito(d2).setProduto(prod2).setEntrada(LocalDateTime.now()).setNumeroDeSerie(cont + "NR" + prod2.getId());
            manager.persist(item1);
            manager.persist(item2);
            cont++;
        }

        manager.getTransaction().commit();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(prod1);
        System.out.println(prod2);

        manager.close();
        factory.close();
    }
}