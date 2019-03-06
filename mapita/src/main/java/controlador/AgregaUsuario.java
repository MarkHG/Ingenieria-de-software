package controlador;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;
import modelo.UsuarioDAO;

@ManagedBean
public class AgregaUsuario {
    private String nombre;
    private String correo;
    private String contrasenia;
    private Date fechanacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    public void agregaUsuario(){
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setCorreo(correo);
        u.setContrasenia(contrasenia);
        u.setFechanacimiento(fechanacimiento);
        UsuarioDAO udb = new UsuarioDAO();
        udb.save(u);
        
    }
    
}