/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import dao.BaseDao;
import dao.BaseDaoImpl;
import pojo.Incidente;
import pojo.Requisicao;
import pojo.User;

public class BaseServiceImpl implements BaseService {

 private BaseDao loginDao = (BaseDao) new BaseDaoImpl();

 @Override
 public boolean login(String username, String password) {
  return loginDao.login(username, password);
 }

 @Override
 public String registration(User user) {
  return loginDao.register(user);
 }
 
  @Override
 public String registrationR(Requisicao req) {
  return loginDao.registerR(req);
 }
 
   @Override
 public String registrationI(Incidente inc) {
  return loginDao.registerI(inc);
 }

}