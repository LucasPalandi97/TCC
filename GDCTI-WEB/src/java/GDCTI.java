import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.faces.context.FacesContext;
import java.io.Serializable; 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "GDCTI")
@RequestScoped

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
      Integer userID1 = gdc.addUsuario("Zara","zaraa@hotmail.com", "1234","Analista",1);
      Integer userID2 = gdc.addUsuario("Diva", "divaa@gmail.com", "4321","Usuario",2);
      Integer userID3 = gdc.addUsuario("Paulo", "paulo@hotmail.com","3432","Usuario",2);
      
      /* Add few Requisicoes records in database */
      
      Integer reqID1 = gdc.addRequisicao(1, "Hardware", "Disco Ridido","11/9/2019","1 semana","Solicitacao de hardware","Necessita-se de um novo disco rigido para a máquina",2);
      Integer reqID2 = gdc.addRequisicao(1, "Audio e Video", "Caixas de som","12/9/2019","3 semanas","Novas caixas","necessita de caixas de som na sala",1);
      Integer reqID3 = gdc.addRequisicao(1, "Segurança", "Cameras de seguranca","22/9/2019","3 dias","Instalação de cameras","é necessario a instalacao de cameras no setor administrativo",0);
      
      /* Add few Incidentes records in database */
      Integer incID1 = gdc.addIncidente(2,1, "Hardware", "Placa mãe","22/9/2019","1 semana","Aquecimento da placa","placa mãe sobreaquecendo, necessidade de troca imediata","73GNFDFVN3",1);
      Integer incID2 = gdc.addIncidente(2,2, "Audio e Video", "Caixas de som","12/9/2019","3 semanas","Novas caixas","necessita de caixas de som na sala","FFGH223G82F",1);
      Integer incID3 = gdc.addIncidente(2,3, "Energia", "Queda de energia","22/9/2019","2 horas","Queda na administração","o setor administrativo esta sem energia portanto inoperante","-",0);
      /*-----------------------------------*/
      /* Update USER's records */
      gdc.updateUsuario(userID1,"1111");

      /* Delete an USER from the database */
      gdc.deleteUsuario(userID3);

      /* List down new list of the USER */
      gdc.listUsuarios();
      
       /*-----------------------------------*/
      /* Update Requisicao's records */
      gdc.updateRequsicao(reqID3,2);

      /* Delete an USER from the database */
      gdc.deleteRequisicao(reqID2);

      /* List down new list of the USER */
      gdc.listRequisicao();
      
      /*-----------------------------------*/
      /* Update Incidente's records */
      gdc.updateIncidente(incID3,2);

      /* Delete a Incidente from the database */
      gdc.deleteIncidente(incID2);

      /* List down new list of the USER */
      gdc.listIncidente();
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

    
   
   /* Method to CREATE a Requisicao in the database */
   public Integer addRequisicao(int tipo, String categoria, String subcategoria, String data, String sla, String titulo, String descricao, int status){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer RequisicaoID = null;
      
      try {
         tx = session.beginTransaction();
         Requisicao req = new Requisicao(tipo, categoria, subcategoria, data, sla, titulo, descricao, status);
         RequisicaoID = (Integer) session.save(req); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return RequisicaoID;
   }
 
   /* Method to CREATE a Incidente in the database */
   public Integer addIncidente(int tipo,int prioridade, String categoria, String subcategoria, String data, String sla, String titulo, String descricao, String serie, int status){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer IncidenteID = null;
      
      try {
         tx = session.beginTransaction();
         Incidente inc = new Incidente(tipo, prioridade, categoria, subcategoria, data, sla, titulo, descricao, serie, status);
         IncidenteID = (Integer) session.save(inc); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return IncidenteID;
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
   
   /* Method to  READ all the Requsicao */
   public void listRequisicao( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List reqs = session.createQuery("FROM Requisicao").list(); 
         for (Iterator iterator = reqs.iterator(); iterator.hasNext();){
            Requisicao req = (Requisicao) iterator.next(); 
            System.out.print("Categoria: " + req.getCategoria()); 
            System.out.println("  Subcategoria: " + req.getSubcategoria()); 
            System.out.print("  Data: " + req.getData()); 
            System.out.println("  SLA: " + req.getSla()); 
            System.out.print("  Título: " + req.getTitulo());
            System.out.println("  Descricao: " + req.getDescricao()); 
            System.out.println("  Status: " + req.getStatus()); 
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
    /* Method to  READ all the Incidente */
   public void listIncidente( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List incs = session.createQuery("FROM Incidente").list(); 
         for (Iterator iterator = incs.iterator(); iterator.hasNext();){
            Incidente inc = (Incidente) iterator.next();
            System.out.print("Prioridade: " + inc.getPrioridade()); 
            System.out.print("  Categoria: " + inc.getCategoria()); 
            System.out.println("  Subcategoria: " + inc.getSubcategoria()); 
            System.out.print("  Data: " + inc.getData()); 
            System.out.println("  SLA: " + inc.getSla()); 
            System.out.print("  Título: " + inc.getTitulo());
            System.out.println("  Descricao: " + inc.getDescricao()); 
            System.out.print("  Numero de série: " + inc.getSerie()); 
            System.out.println("  Status: " + inc.getStatus()); 
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
   /* Method to UPDATE status for Requisicao */
   public void updateRequsicao(Integer RequisicaoID, int status ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Requisicao req = (Requisicao)session.get(Requisicao.class, RequisicaoID); 
         req.setStatus(status);
		 session.update(req); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to UPDATE status for Incidente */
   public void updateIncidente(Integer IncidenteID, int status ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Incidente inc = (Incidente)session.get(Incidente.class, IncidenteID); 
         inc.setStatus(status);
		 session.update(inc); 
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
   
    /* Method to DELETE a Requisicao from the records */
   public void deleteRequisicao(Integer RequisicaoID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Requisicao req = (Requisicao)session.get(Requisicao.class, RequisicaoID); 
         session.delete(req); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
       /* Method to DELETE a Incidente from the records */
   public void deleteIncidente(Integer IncidenteID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Incidente inc = (Incidente)session.get(Incidente.class, IncidenteID); 
         session.delete(inc); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}