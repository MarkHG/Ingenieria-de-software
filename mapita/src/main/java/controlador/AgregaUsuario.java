package controlador;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;
import modelo.UsuarioDAO;

 @ManagedBean
public class AgregarUsuario {
     private int idusuario;
     private String nombre;
     private String correo;
     private String contresenia;
     private Date fechanacimiento;

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContresenia(String contresenia) {
        this.contresenia = contresenia;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContresenia() {
        return contresenia;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }
    
    public void agregaUsuario(){
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setContresenia(contresenia);
        u.setFechanacimiento(fechanacimiento);
        UsuarioDAO udb = new UsuarioDAO();
        udb.save(u);
    }
    
}
