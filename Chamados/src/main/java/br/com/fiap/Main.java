package br.com.fiap;

import br.com.fiap.domain.entity.Area;
import br.com.fiap.domain.entity.Documento;
import br.com.fiap.domain.entity.Pessoa;
import br.com.fiap.domain.entity.TipoDocumento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");
        EntityManager manager = factory.createEntityManager();

        //addArea(manager);
        addTipoDocumento(manager);
        addPessoa(manager);

        Documento doc = new Documento();

        List<Pessoa> pessoas = manager.createQuery("FROM Pessoa ").getResultList();

        Pessoa pessoaSelecionada = (Pessoa) JOptionPane.showInputDialog(null, "Selecione uma pessoa", "Seleção de pessoas", JOptionPane.QUESTION_MESSAGE, null, pessoas.toArray(), pessoas.get(0));

        List<TipoDocumento> tipos = manager.createQuery("FROM TipoDocumento").getResultList();

        TipoDocumento tipoSelecionado = (TipoDocumento) JOptionPane.showInputDialog(null, "Selecione um tipo de documento", "Seleção de tipo de documento", JOptionPane.QUESTION_MESSAGE, null, tipos.toArray(), tipos.get(0));

        String numero = JOptionPane.showInputDialog("Numero do documento: ");

        doc.setPessoa(pessoaSelecionada).setTipo(tipoSelecionado).setNumero(numero);

        manager.getTransaction().begin();
        manager.persist(doc);
        manager.getTransaction().commit();
        System.out.println(doc);

        manager.close();
        factory.close();
    }

    private static void addPessoa(EntityManager manager) {
        boolean salvou = false;
        boolean dataValida = false;
        do {
            Pessoa pessoa = new Pessoa();
            String nome = JOptionPane.showInputDialog("Nome: ");
            do {
                try {
                    String nascimento = JOptionPane.showInputDialog("Data de nascimento no formato DD/MM/AAAA: ");
                    int dia = Integer.parseInt(nascimento.substring(0, 2));
                    int mes = Integer.parseInt(nascimento.substring(3, 5));
                    int ano = Integer.parseInt(nascimento.substring(6, 10));
                    dataValida = true;
                    pessoa.setNome(nome).setDataNascimento(LocalDate.of(ano, mes, dia));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Informe a data no formato exigido (DD/MM/AAAA).");
                }
            } while (dataValida == false);
            try {
                manager.getTransaction().begin();
                manager.persist(pessoa);
                manager.getTransaction().commit();
                System.out.println(pessoa);
                salvou = true;
            } catch (Exception ex){
                String erro = """
                    ERRO!
                    
                    NÃO FOI POSSÍVEL SALVAR OS DADOS: """ + ex.getMessage() + """
                    
                    MOTIVO: """ + ex.getLocalizedMessage();
                JOptionPane.showMessageDialog(null, erro);
            }
        } while(salvou == false);
    }

    private static void addTipoDocumento(EntityManager manager) {
        boolean salvou = false;

        do {
            TipoDocumento tp = new TipoDocumento();
            String nome = JOptionPane.showInputDialog("Nome do tipo de documento:");
            String descricao = JOptionPane.showInputDialog("Descrição:");
            tp.setNome(nome).setDescricao(descricao);
            try {
                manager.getTransaction().begin();
                manager.persist(tp);
                manager.getTransaction().commit();
                System.out.println(tp);
                salvou = true;
            } catch (Exception ex){
                String erro = """
                    ERRO!
                    
                    NÃO FOI POSSÍVEL SALVAR OS DADOS: """ + ex.getMessage() + """
                    
                    MOTIVO: """ + ex.getLocalizedMessage();
                JOptionPane.showMessageDialog(null, erro);
            }
        } while(salvou == false);
    }

    private static void addArea(EntityManager manager) { //ALT + SHIFT + M - Criar método
        boolean salvou = false;

        do {
            Area area = new Area();
            String nome = JOptionPane.showInputDialog("Nome da área:");
            String desc = JOptionPane.showInputDialog("Descrição:");
            area.setNome(nome).setDescricao(desc);
            try {
                manager.getTransaction().begin();
                manager.persist(area);
                manager.getTransaction().commit();
                System.out.println(area);
                salvou = true;
            } catch (Exception ex){
                String erro = """
                    ERRO!
                    
                    NÃO FOI POSSÍVEL SALVAR OS DADOS: """ + ex.getMessage() + """
                    
                    MOTIVO: """ + ex.getLocalizedMessage();
                JOptionPane.showMessageDialog(null, erro);
            }
        } while(salvou == false);
    }

}