package Model;
// Generated 04/04/2018 22:50:47 by Hibernate Tools 4.3.1



/**
 * Veiculos generated by hbm2java
 */
public class Veiculos  implements java.io.Serializable {


     private Integer id;
     private String modelo;
     private String marca;
     private int ano;

    public Veiculos() {
    }

    public Veiculos(String modelo, String marca, int ano) {
       this.modelo = modelo;
       this.marca = marca;
       this.ano = ano;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAno() {
        return this.ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }




}


