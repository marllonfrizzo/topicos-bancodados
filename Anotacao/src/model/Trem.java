package model;

import javax.persistence.Entity;

/**
 *
 * @author marllonfrizzo
 */
@Entity
public class Trem extends Veiculo{
    private int vagoes;

    public int getVagoes() {
        return vagoes;
    }

    public void setVagoes(int vagoes) {
        this.vagoes = vagoes;
    }
    
}
