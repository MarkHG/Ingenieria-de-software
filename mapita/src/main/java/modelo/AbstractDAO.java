/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author marco
 */
public abstract class AbstractDAO {
    
    protected SessionFactory sessionFactory;
    
    public AbstractDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
        
    }
    
    protected void save(Object obj){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            
        }catch(HibernateException e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
            
        } finally{
            session.close();
        }
    }
    
    
    protected void update(Object obj){}
    
    protected void delate(Object objt){}
    
    protected Object find(Class clazz, int id){
        Object objt = null;
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From" + clazz;
            Query query = session.createQuery(hql);
            objt = query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if (tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return objt;
    }
    
    //protected List<T> findAll(Class clazz){}
}
