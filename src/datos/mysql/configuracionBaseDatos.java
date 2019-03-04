package datos.mysql;

public class configuracionBaseDatos {
    private String controlador = "com.mysql.jdbc.Driver"; 
    private String baseDatos = "jdbc:mysql://localhost/cursos";
    private String usuario = "root";
    private String contrasena = "";    
    public configuracionBaseDatos(){
        
    }

    public String getControlador() {
        return controlador;
    }

    public void setControlador(String controlador) {
        this.controlador = controlador;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
