package main;

import Model.Cliente;
import Model.Pessoa;
import Model.Telefone;
import Model.Venda;
import Model.Vendedor;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author marllonfrizzo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory(); //Instancia a fabrica de sessão
        Session s = sf.openSession(); //Abre uma sessão

        Cliente c1 = new Cliente();
        c1.setCpf("123.123.123-12");
        c1.setNome("Marllon");
        c1.setQtdeCompras(15);
        c1.setValorComprado(13.2);
        
        Cliente c2 = new Cliente();
        c2.setNome("José");
        c2.setCpf("321.321.321-32");
        c2.setQtdeCompras(2);
        c2.setValorComprado(2.5);
        
        Cliente c3 = new Cliente();
        c3.setNome("Bruna");
        c3.setCpf("789.789.789-78");
        c3.setQtdeCompras(100);
        c3.setValorComprado(1000.10);
        
        Venda v1 = new Venda();
        Venda v2 = new Venda();
        Venda v3 = new Venda();
        
        v1.getClientes().add(c1);
        v1.setQtdeItems(10);
        v1.setValorTotal(250.5);
                
        v2.getClientes().add(c3);
        v2.setQtdeItems(100);
        v2.setValorTotal(78.78);
        
        v3.getClientes().add(c1);
        v3.setQtdeItems(30);
        v3.setValorTotal(30.1);
        
        Vendedor func = new Vendedor();
        func.setNome("Vendedor 1");
        func.setCpf("123.123.123-12");
        func.setCodVendedor(1);
        func.setQtdeVendas(100);
        func.setValorVendas(150.0);
        func.getVendas().add(v1);
        v1.setVendedor(func);
        
        Vendedor func2 = new Vendedor();
        func2.setNome("Vendedor 2");
        func2.setCpf("321.321.321-32");
        func2.setCodVendedor(2);
        func2.setQtdeVendas(200);
        func2.setValorVendas(250.0);
        func2.getVendas().add(v2);
        v2.setVendedor(func2);
        
        Vendedor func3 = new Vendedor();
        func3.setNome("Vendedor 3");
        func3.setCpf("999.321.321-32");
        func3.setCodVendedor(3);
        func3.setQtdeVendas(300);
        func3.setValorVendas(350.0);
        func3.getVendas().add(v3);
        v3.setVendedor(func3);
        
        Telefone t = new Telefone();
        t.setDDD(44);
        t.setNumero("99920-2425");
        c1.getTelefones().add(t);
        
        Telefone t2 = new Telefone();
        t2.setDDD(44);
        t2.setNumero("99999-9999");
        c2.getTelefones().add(t2);
        
        Telefone t3 = new Telefone();
        t3.setDDD(44);
        t3.setNumero("88888-2323");
        c3.getTelefones().add(t3);
        
        c1.setVenda(v1);
        c2.setVenda(v3);
        c3.setVenda(v2);
        
        s.beginTransaction(); // inicia a transação
        s.persist(v1);
        s.persist(v2);
        s.persist(v3);
        s.persist(c1);
        s.persist(c2);
        s.persist(c3);
        s.persist(func);
        s.persist(func2);
        s.persist(func3);
        s.getTransaction().commit(); // comita a transação
        
        Query q = s.createQuery("from Pessoa where nome=:Pnome");
        q.setString("Pnome", "Marllon");
        List<Pessoa>  pessoas = (List<Pessoa>) q.list();
        System.out.println("Quantidade: "+pessoas.size());
        for (Pessoa pp: pessoas) {
            System.out.println(pp.getNome());
        }
            
        s.close(); // fecha a sessão
        System.exit(0);
    }
    
}
