package model;

import javax.persistence.Entity;

/**
 *
 * @author marllonfrizzo
 */
@Entity
public class Automovel extends Veiculo{
    private int num_rodas;

    public int getNum_rodas() {
        return num_rodas;
    }

    public void setNum_rodas(int num_rodas) {
        this.num_rodas = num_rodas;
    }
    
}
