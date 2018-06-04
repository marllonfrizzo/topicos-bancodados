package dao;

import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author marllonfrizzo
 */
public class GenericDAO {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public String salvar(Object objeto) {
        Session sessao = sf.openSession();
        sessao.beginTransaction();
        
        try {
            sessao.persist(objeto);
            sessao.getTransaction().commit();
            return "Sucess";
        } catch (Exception ex) {
            return "Fail";
        } finally {
            sessao.close();
        }
    }
    
    public String atualizar(Object objeto) {
        Session sessao = sf.openSession();
        sessao.beginTransaction();
        
        try {
            sessao.update(objeto);
            sessao.getTransaction().commit();
            return "Sucess";
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            return "Fail";
        } finally {
            sessao.close();
        }
    }
    
    public String excluir(Object objeto) {
        Session sessao = sf.openSession();
        sessao.beginTransaction();
        
        try {
            sessao.delete(objeto);
            sessao.getTransaction().commit();
            return "Sucess";
        } catch (Exception ex) {
            sessao.getTransaction().rollback();
            return "Fail";
        } finally {
            sessao.close();
        }
    }
    
    public Object buscar(Class c, int i) {
        
        // Faça um try catch
        
        Object o = null;
        Session sessao = sf.openSession();
        sessao.beginTransaction();
        o = sessao.get(c, i);
        sessao.close();
        return o;
    }
}


