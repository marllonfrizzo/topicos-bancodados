package Model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author marllonfrizzo
 */
@Table (name="cadVenda")
@Entity
public class Venda {
    @Id @GeneratedValue
    private int idVenda;
    
    @Column (name="quantidadeItems")
    private int qtdeItems;
    
    @ManyToOne
    private Vendedor vendedor;
    
    private Double valorTotal;
    
    @OneToMany(mappedBy="venda", cascade = CascadeType.ALL)
    private Collection<Cliente> clientes = new ArrayList<Cliente>();

    public int getQtdeItems() {
        return qtdeItems;
    }

    public void setQtdeItems(int qtdeItems) {
        this.qtdeItems = qtdeItems;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Collection<Cliente> clientes) {
        this.clientes = clientes;
    }
}
