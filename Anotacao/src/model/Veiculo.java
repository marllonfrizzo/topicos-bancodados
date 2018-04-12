package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author marllonfrizzo
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Veiculo {
    @Id @GeneratedValue
    private int idVeiculo;
    private String marca;
    
    @ManyToOne
    private ModCadUsuario usuario;

    public ModCadUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(ModCadUsuario usuario) {
        this.usuario = usuario;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
