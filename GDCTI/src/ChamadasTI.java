/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
           factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
          
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

        /* Add few requisitions records in database */
        Integer reqID1 = ctc.addReq(1,"Hardware", "Disco rigido", "12/10/12", "3 semanas","Problemas no disco", "lento e travando");
        Integer reqID2 = ctc.addReq(2,"Seguranca", "Cameras", "12/11/12", "3 dias", "Problemas na camera de seguranca", "Imagem distorcida");
    
           
       /* Update chamado's records */
        ctc.updatereq(reqID2, "Titulo test", "descricao test");

         /*Delete a chamado from the database*/ 
        ctc.deletereq(reqID1);

       /* List down new list of the chamados */
        ctc.listReq();

    }

    /* Method to CREATE a user in the database */
    public Integer addusuario(String nome, String email, String password, String funcao, int tipo) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userREG = null;

        try {
            tx = session.beginTransaction();
            Usuario user = new Usuario(nome, email, password, funcao, tipo);
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
                Usuario user1 =  (Usuario) iterator.next();
                System.out.print("Nome: " + user1.getNome());
                System.out.print("Email: " + user1.getEmail());
                System.out.println("Função: " + user1.getFuncao());
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
            Usuario user = (Usuario) session.get(Usuario.class, userREG);
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
            Usuario user = (Usuario) session.get(Usuario.class, userREG);
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
    public Integer addReq(int tipo, String cat, String subcat, String data, String sla, String titulo, String desc) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer reqID = null;

        try {
            tx = session.beginTransaction();
            Requisicao req = new Requisicao(tipo,cat, subcat, data, sla, titulo, desc);
            reqID = (Integer) session.save(req);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reqID;
    }

    /* Method to  READ all the chamados*/
    public void listReq() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List req = session.createQuery("FROM Requisicao").list();
            for (Iterator iterator = req.iterator(); iterator.hasNext();) {
                Requisicao req1 = (Requisicao) iterator.next();
                System.out.println("Tipo da chamada: " + req1.getTipo());
                System.out.println("Categoria: " + req1.getCat());
                System.out.println("Subcategoria: " + req1.getSubcat());
                System.out.println("Título: " + req1.getTitulo());
                System.out.println("Descrição: " + req1.getDesc());
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
    public void updatereq(Integer reqID, String titulo, String descricao) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Requisicao req = (Requisicao) session.get(Requisicao.class, reqID);
            req.setDesc(descricao);
            req.setTitulo(titulo);
            session.update(req);
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
    public void deletereq(Integer reqID) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Requisicao req  = (Requisicao) session.get(Requisicao.class, reqID);
            session.delete(req);
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
