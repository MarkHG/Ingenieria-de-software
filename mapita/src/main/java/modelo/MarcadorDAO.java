/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

public class MarcadorDAO extends AbstractDAO<Marcador>{
    /**
     * 
     */
    public MarcadorDAO(){
        super();
    }
    
    
    /**
     * 
     * @param marcador 
     */
    public void save(Marcador marcador){
        super.save(marcador);
    }
    
    /**
     * 
     * @param marcador 
     */
    public void update(Marcador marcador){
        super.save(marcador);
    }
    
    /**
     * 
     * @param marcador 
     */
    public void delete(Marcador marcador){
        super.delete(marcador);
    }
       
    /**
     * 
     * @param id
     * @return 
     */
    public Marcador find(int id){
        return (Marcador) super.find(Marcador.class, id);
    }
    
    /**
     * 
     * @return 
     */
    public List<Marcador> findAll(){
        return super.findAll(Marcador.class);
    }
}