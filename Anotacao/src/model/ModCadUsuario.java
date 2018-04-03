package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author marllonfrizzo
 */
@Entity (name="CadUsuario")
//@Table (name="cad_usuario")
public class ModCadUsuario {
    @Id @GeneratedValue
    @Column (name="id_usuario")
    private int idUsuario;
    @Column (name="nm_usuario")
    private String nmUsuario;
    //@Transient
    @Lob
    private String obs;
    @Temporal (TemporalType.DATE)
    private Date dtNasc;
    
    //@Embedded
    @ElementCollection
    @JoinTable(name="Enderecos", joinColumns = @JoinColumn(name="idUsuario"))
    private Set<Endereco> enderecos = new HashSet<Endereco>();
    
    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
    private Collection<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Collection<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Collection<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
}
