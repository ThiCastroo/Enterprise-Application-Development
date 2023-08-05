package br.com.fiap;

import br.com.fiap.domain.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");

        EntityManager manager = factory.createEntityManager();

        Aluno benezinho = new Aluno();
        benezinho.setNome("Benefrancis do Nascimento").setRm("RM17171");

        Aluno aluno = new Aluno();
        aluno.setNome("Thiago Gyorgy Teixeira de Castro").setRm("RM97136");

        manager.getTransaction().begin();
        manager.persist(benezinho);
        manager.persist(aluno);
        manager.getTransaction().commit();
        manager.close();

        factory.close();

        System.out.println(benezinho);
        System.out.println(aluno);

    }
}