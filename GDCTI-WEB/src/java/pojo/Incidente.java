package pojo;



/**
 *
 * @author lucas
 */

public class Incidente {


    
    private int id;
    private String tipo, data, categoria, subcategoria, titulo, descricao, serie,prioridade, status, user_username;

    public int getId() {
        return id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Incidente [id=" + id + ", tipo=" + tipo + ", username: " + user_username + ", data=" + data + ", prioridade= " + prioridade + ", categoria= " + categoria
                + ", subcategoria= " + subcategoria + ", titulo= " + titulo + ", descricao= " + descricao + ", serie= " + serie + ", status= " + status + "]";
    }
}
