package br.com.fiap;

import br.com.fiap.domain.entity.Area;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        Area area = new Area();
        area.setNome("TI").setDescricao("Tecnologia da Informação");

        manager.getTransaction().begin();
        manager.persist(area);
        manager.getTransaction().commit();

        System.out.println(area);

        manager.close();
        factory.close();
    }
}