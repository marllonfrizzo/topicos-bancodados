package Model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author marllonfrizzo
 */

@Table (name="cadVendedor")
@Entity
public class Vendedor extends Pessoa {
    @Column (name="idVendedor")
    private int codVendedor;
    @Column (name="quantidadeVendas")
    private int qtdeVendas;
    private Double valorVendas;
    
    @OneToMany(mappedBy="vendedor", cascade = CascadeType.ALL)
    private Collection<Venda> vendas = new ArrayList<Venda>();

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }

    public int getQtdeVendas() {
        return qtdeVendas;
    }

    public void setQtdeVendas(int qtdeVendas) {
        this.qtdeVendas = qtdeVendas;
    }

    public Double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(Double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public Collection<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Collection<Venda> vendas) {
        this.vendas = vendas;
    }
}
