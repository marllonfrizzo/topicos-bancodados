package Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author marllonfrizzo
 */
@Table (name="cadCliente")
@Entity
public class Cliente extends Pessoa {
    private int qtdeCompras;
    private Double valorComprado;
    
    @ManyToOne
    private Venda venda;
    
    @Embedded
    private Telefone fone;

    public Telefone getFone() {
        return fone;
    }

    public void setFone(Telefone fone) {
        this.fone = fone;
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
    
}
