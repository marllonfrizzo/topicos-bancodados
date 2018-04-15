package Model;

import javax.persistence.Embeddable;

/**
 *
 * @author marllonfrizzo
 */
@Embeddable
public class Telefone {
    private int DDD;
    private String numero;

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
