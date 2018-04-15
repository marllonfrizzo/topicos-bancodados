package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 *
 * @author marllonfrizzo
 */
@Entity (name="cadCliente")
public class Cliente extends Pessoa {
    private int qtdeCompras;
    private Double valorComprado;
    
    @ManyToOne
    private Venda venda;
    
    @ElementCollection
    @JoinTable(name="Telefone", joinColumns = @JoinColumn(name="id"))
    private Set<Telefone> telefones;

    public Cliente() {
        this.telefones = new HashSet<>();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public int getQtdeCompras() {
        return qtdeCompras;
    }

    public void setQtdeCompras(int qtdeCompras) {
        this.qtdeCompras = qtdeCompras;
    }

    public Double getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(Double valorComprado) {
        this.valorComprado = valorComprado;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }
    
}
