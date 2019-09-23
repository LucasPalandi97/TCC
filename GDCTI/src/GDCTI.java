import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GDCTI {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (HibernateException ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      GDCTI gdc = new GDCTI();

      /* Add few USER records in database */
      Integer userID1 = gdc.addUsuario("Zara", "zaraa@hotmail.com", "1234","Analista",1);
      Integer userID2 = gdc.addUsuario("Diva", "divaa@gmail.com", "4321","Usuario",2);
      Integer userID3 = gdc.addUsuario("Paulo", "paulo@hotmail.com","3432","Usuario",2);
     

      /* Update USER's records */
      gdc.updateUsuario(userID1,"1111");

      /* Delete an USER from the database */
      gdc.deleteUsuario(userID3);

      /* List down new list of the USER */
      gdc.listUsuarios();
   }
   
   /* Method to CREATE an USER in the database */
   public Integer addUsuario(String nome, String email, String password,String funcao, int tipo){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer UsuarioID = null;
      
      try {
         tx = session.beginTransaction();
         Usuario user = new Usuario(nome, email, password, funcao, tipo);
         UsuarioID = (Integer) session.save(user); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return UsuarioID;
   }
   
   /* Method to  READ all the USERS */
   public void listUsuarios( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List users = session.createQuery("FROM Usuario").list(); 
         for (Iterator iterator = users.iterator(); iterator.hasNext();){
            Usuario user = (Usuario) iterator.next(); 
            System.out.print("Nome: " + user.getNome()); 
            System.out.print("  Email: " + user.getEmail()); 
            System.out.println("  Função: " + user.getFuncao()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to UPDATE password for an USER */
   public void updateUsuario(Integer UsuarioID, String password ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Usuario user = (Usuario)session.get(Usuario.class, UsuarioID); 
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
   
   /* Method to DELETE an USER from the records */
   public void deleteUsuario(Integer UsuarioID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Usuario user = (Usuario)session.get(Usuario.class, UsuarioID); 
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