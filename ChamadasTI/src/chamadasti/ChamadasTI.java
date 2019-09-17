/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chamadasti;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ChamadasTI {

    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ChamadasTI CT = new ChamadasTI();

        /* Add few users records in database */
        Integer userReg1 = CT.addusuario("Zara", "xxx@xxx.com", "123", "analista", 1);
        Integer userReg2 = CT.addusuario("Daisy", "ccc@ccc.com", "123", "cliente", 0);
        Integer userReg3 = CT.addusuario("John", "vvvv@vvv.com", "123", "cliente", 1);

        /* List down all the users 
        CT.listusuario();

        /* Update user's records 
        CT.updateusuario(userReg1, "1212");

        /* Delete a user from the database 
        CT.deleteusuario(userReg2);

        /* List down new list of the users *
        CT.listusuario(); */

         ChamadasTI ctc = new ChamadasTI(); 

        /* Add few chamados records in database */
        Integer chmID1 = ctc.addChamado(1, 0, "Hardware", "Disco rigido", "12/10/12", "3 semanas", "Lucas", "Problemas no disco", "lento e travando", "");
        Integer chmID2 = ctc.addChamado(2, 3, "Seguranca", "Cameras", "12/11/12", "3 dias", "Jaean", "Problemas na camera de seguranca", "Imagem distorcida", "qtx334311");
        /* List down all the chamados
        ctc.listChamados();


        /* Update chamado's records 
        ctc.updatechamados(chmID2, "Titulo test", "descricao test");

        /* Delete a chamado from the database 
        ctc.deletechamado(userReg2);

        /* List down new list of the chamados 
        ctc.listChamados();*/

    }

    /* Method to CREATE a user in the database */
    public Integer addusuario(String nome, String email, String password, String funcao, int tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userREG = null;

        try {
            tx = session.beginTransaction();
            usuario user = new usuario(nome, email, password, funcao, tipo);
            userREG = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userREG;
    }

    /* Method to  READ all the users */
    public void listusuario() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List user = session.createQuery("FROM Employee").list();
            for (Iterator iterator = user.iterator(); iterator.hasNext();) {
                usuario user = (usuario) iterator.next();
                System.out.print("Nome: " + user.getNome());
                System.out.print("Email: " + user.getEmail());
                System.out.println("Função: " + user.getFuncao());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE password for a user */
    public void updateusuario(Integer userREG, String password) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            usuario user = (usuario) session.get(usuario.class, userREG);
            user.setPassword(password);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE a user from the records */
    public void deleteusuario(Integer userREG) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            usuario user = (usuario) session.get(usuario.class, userREG);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /*chamadas*/
 /* Method to CREATE a chamado in the database */
    public Integer addChamado(int tipo, int pri, String cat, String subcat, String data, String sla, String analista, String titulo, String desc, String serie) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer chamadoID = null;

        try {
            tx = session.beginTransaction();
            Chamadas chamada = new Chamadas(tipo, pri, cat, subcat, data, sla, analista, titulo, desc, serie);
            chamadoID = (Integer) session.save(chamada);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return chamadoID;
    }

    /* Method to  READ all the chamados*/
    public void listChamados() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List chamada = session.createQuery("FROM Chamadas").list();
            for (Iterator iterator = chamada.iterator(); iterator.hasNext();) {
                Chamadas chamada = (Chamadas) iterator.next();
                System.out.println("Tipo da chamada: " + chamada.getTipo());
                System.out.println("Categoria: " + chamada.getCat());
                System.out.println("Subcategoria: " + chamada.getSubcat());
                System.out.println("Título: " + chamada.getTitulo());
                System.out.println("Descrição: " + chamada.getDesc());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE chamados */
    public void updatechamados(Integer chamadoID, String titulo, String descricao) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Chamadas chamada = (Chamadas) session.get(Chamadas.class, chamadoID);
            chamada.setDesc(descricao);
            chamada.setTitulo(titulo);
            session.update(chamada);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an chamado from the records */
    public void deletechamado(Integer chamadoID) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Chamadas chamada = (Chamadas) session.get(Chamadas.class, chamadoID);
            session.delete(chamada);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
