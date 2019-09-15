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

      /* Add few employee records in database */
      Integer userReg1 = CT.addusuario("Zara", "xxx@xxx.com", "123","analista",1);
      Integer userReg2 = CT.addusuario("Daisy", "ccc@ccc.com", "123","cliente",0);
      Integer userReg3 = CT.addusuario("John", "vvvv@vvv.com", "123","cliente",1);

      /* List down all the users */
      CT.listusuario();

      /* Update user's records */
      CT.updateusuario(userReg1, 5000);

      /* Delete a user from the database */
      CT.deleteusuario(userReg2);

      /* List down new list of the users */
      CT.listusuario();
   }
   
   /* Method to CREATE a user in the database */
   public Integer addusuario(String nome, String email, String password , String funcao, int tipo){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer usuarioReg = null;
      
      try {
         tx = session.beginTransaction();
         usuario user = new usuario(nome, email, password, funcao, tipo);
          userREG = (Integer) session.save(usuario); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return userREG;
   }
   
   /* Method to  READ all the users */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            usuario user = (usuario) iterator.next(); 
            System.out.print("Nome: " + user.getNome()); 
            System.out.print("Email: " + user.getEmail()); 
            System.out.println("Função: " + user.getFuncao()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to UPDATE password for a user */
   public void uptadeuser(Integer userREG, String password ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         usuario user = (usuario)session.get(usuario.class, userREG); 
         user.setPassword(password);
		 session.update(user); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE a user from the records */
   public void deleteusuario(Integer userREG){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         usuario user = (usuario)session.get(usuario.class, userREG); 
         session.delete(user); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}