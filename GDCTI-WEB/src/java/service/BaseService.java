/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;



import pojo.Incidente;
import pojo.Requisicao;
import pojo.User;

public interface BaseService {
 public boolean login(String username, String password);

 public String registration(User user);
 
  public String registrationR(Requisicao req);
  
  public String registrationI(Incidente inc);
}