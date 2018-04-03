/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anotacao;

import java.util.Date;
import model.Endereco;
import model.ModCadUsuario;
import model.Veiculo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author marllonfrizzo
 */
public class Anotacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        
        ModCadUsuario user = new ModCadUsuario();
        
        Endereco e1 = new Endereco();
        e1.setCep("12345");
        e1.setLogradouro("Da Soja");
        e1.setComplemento("Casa");
        e1.setNum("225");
        
        Endereco e2 = new Endereco();
        e2.setCep("54321");
        e2.setLogradouro("Porto Velho");
        e2.setComplemento("Sobrado");
        e2.setNum("318");
        
        Veiculo v1 = new Veiculo();
        v1.setMarca("Volkswagem");
        v1.setUsuario(user);
        
        Veiculo v2 = new Veiculo();
        v2.setMarca("GM");
        v2.setUsuario(user);
        
        Veiculo v3 = new Veiculo();
        v3.setMarca("Fiat");
        v3.setUsuario(user);
        
        user.setNmUsuario("Ultimo User");
        user.setObs("Obs Teste");
        user.setDtNasc(new Date());
        user.getEnderecos().add(e1);
        user.getEnderecos().add(e2);
        
        user.getVeiculos().add(v1);
        user.getVeiculos().add(v2);
        user.getVeiculos().add(v3);
        
        
        s.beginTransaction();
        s.persist(v1);
        s.persist(v2);
        s.persist(v3);
        s.persist(user);
        s.getTransaction().commit();
        s.close();
        
        /*user = null;
        s = sf.openSession();
        s.beginTransaction();
        user = (ModCadUsuario) s.get(ModCadUsuario.class, 2);
        //System.out.println("Usuario recuperado: "+user.getNmUsuario());
        s.close();*/
        
        System.exit(0);
    }
    
}
