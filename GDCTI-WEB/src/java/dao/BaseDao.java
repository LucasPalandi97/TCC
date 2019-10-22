/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojo.Incidente;
import pojo.Requisicao;
import pojo.User;

public interface BaseDao {
 public boolean login(String username, String password);

 public String register(User user);
 
 public String registerR(Requisicao req);
 
  public String registerI(Incidente inc);
}
