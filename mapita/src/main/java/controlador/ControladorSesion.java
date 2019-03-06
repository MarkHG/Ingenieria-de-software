/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jonathan
 */
@ManagedBean
@SessionScoped
public class ControladorSesion {
    private String correo;
    private String contrasenia;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

   
    
    public String login(){
        UsuarioDAO ubd = new UsuarioDAO();
        Usuario user = ubd.buscaPorEmail(correo);
        if (user != null && ubd.esContraseniaDe(user, contrasenia)) {
            FacesContext context = FacesContext.getCurrentInstance();
            if(user !=null){
                context.getExternalContext().getSessionMap().put("user", user);
                return "perfil?faces-redirect=true";
            }
        }
        return "malsesion?faces-redirect=true";
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
}
