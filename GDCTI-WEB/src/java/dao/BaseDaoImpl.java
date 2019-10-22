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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
    return false;
   }

  } else {
   System.out.println("DB server down.....");
  }
  return false;
 }

 @Override
 public String register(User user) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (user != null) {
     String username = (String) session.save(user);
     session.beginTransaction().commit();
     msg = "User " + username
       + " created successfully, please login...";
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading user data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
 
 @Override
 public String registerR(Requisicao req) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (req != null) {
     Integer id = (Integer)session.save(req) ;
     String tipo = req.getTipo();
     session.beginTransaction().commit();
     msg = "Requisicao #" + tipo + id
       + " created successfully...";
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading requisicao data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
 
  @Override
 public String registerI(Incidente inc) {
  String msg = "Registration unsuccessful, try again.....";
  Session session = HibernateUtil.getSession();
  if (session != null) {
   try {
    if (inc != null) {
     Integer id = (Integer)session.save(inc) ;
     String tipo = inc.getTipo();
     session.beginTransaction().commit();
     msg = "Incidente #" + tipo + id
       + " created successfully...";
    }
   } catch (Exception exception) {
    System.out.println("Exception occred while reading requisicao data: "
      + exception.getMessage());
   }

  } else {
   System.out.println("DB server down.....");
  }
  System.out.println("msg:" + msg);
  return msg;
 }
}