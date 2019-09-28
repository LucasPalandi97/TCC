
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lucas
 */
@ManagedBean(name = "Usuario")
@RequestScoped
public class Usuario {

   private int id;
   private String nome; 
   private String email;   
   private String password;
   private String funcao;
   private int tipo;  

   public Usuario() {}
   public Usuario(String nome, String email, String password,String funcao, int tipo) {
      this.nome = nome;
      this.email = email;
      this.password = password;
      this.funcao = funcao;
      this.tipo = tipo;
   }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

  
   public int getId() {
      return id;
   }
   
   public void setId( int id ) {
      this.id = id;
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
   
  
}

