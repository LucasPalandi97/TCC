/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author lucas
 */
import org.hibernate.Session;
import pojo.Incidente;
import pojo.Requisicao;
import pojo.User;
import util.HibernateUtil;

public class BaseDaoImpl implements BaseDao {

 @Override
 public boolean login(String username, String password) {
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    User user = (User) session.get(User.class, username);
    if (password.equals(user.getPassword())) {
     System.out.println("User: " + user.toString());
     return true;
    }
   } catch (Exception exception) {
    System.out.println("Erro Excpetion ao ler data do usuário: "
      + exception.getMessage());
    return false;
   }

  } else {
   System.out.println("Servidor desconectado.....");
  }
  return false;
 }

 @Override
 public String register(User user) {
  String msg = "Registro não concluido, tente de novo.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (user != null) {
     String username = (String) session.save(user);
     session.beginTransaction().commit();
     msg = "Usuário " + username
       + " criado com sucesso, porfavor realize o login...";
    }
   } catch (Exception exception) {
    System.out.println("Erro Exception ao ler dados do usuário: "
      + exception.getMessage());
   }

  } else {
   System.out.println("Servidor desconectado.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
 
 @Override
 public String registerR(Requisicao req) {
  String msg = "Registro não concluido, tente de novo.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (req != null) {
     Integer id = (Integer)session.save(req);
     String tipo = req.getTipo();
     session.beginTransaction().commit();
     msg = "Requisição #" + tipo + id
       + " criada com sucesso...";
    }
   } catch (Exception exception) {
    System.out.println("Erro Exception ao ler dados da requisição: "
      + exception.getMessage());
   }

  } else {
   System.out.println("Servidor desconectado.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
 
  @Override
 public String registerI(Incidente inc) {
  String msg = "Registro não concluido, tente de novo.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (inc != null) {
     Integer id = (Integer)session.save(inc) ;
     String tipo = inc.getTipo();
     session.beginTransaction().commit();
     msg = "Incidente #" + tipo + id
       + " criado com sucesso...";
    }
   } catch (Exception exception) {
    System.out.println("Erro Exception ao ler dados do incidente: "
      + exception.getMessage());
   }

  } else {
   System.out.println("Servidor desconectado.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
 
}