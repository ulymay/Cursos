package datos.mysql;

import datos.DAO;
import entidades.Alumno;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOAlumno implements DAO{
    
    baseDatos bd = new baseDatos();

    @Override
    public boolean agregar(Object o) {
        boolean result = false;
        try{
            Alumno alumno = (Alumno) o;
            bd.abrirConexion(); //Siempre abrir conexion
            String consulta = "INSERT INTO alumno ("
                    +"nombre,email,semestre,carrera)"
                    +" VALUES ("
                    +"'"+alumno.getNombre()+"',"
                    + "'"+alumno.getEmail()+"',"
                    + alumno.getSemestre() +","
                    + "'"+alumno.getCarrera()+"'"
                    +")";
            
            result = bd.ejecutarComando(consulta);
        }catch(Exception e){
            
        }finally{
            bd.cerrarConexion(); // Siempre cerrar conexion
        }
        return result;
        
    }

    @Override
    public boolean editar(Object o) {
        boolean result = false;
        try {
            Alumno alumno = (Alumno) o;
            bd.abrirConexion();
            String consulta = "UPDATE alumno SET "
                    + " nombre = '"+alumno.getNombre()+"',"
                    + " email = '"+alumno.getEmail()+"',"
                    + " semestre = '"+alumno.getSemestre()+"',"
                    + " carrera = '"+alumno.getCarrera()+"' "
                    + " WHERE id = "+alumno.getId();
            
            result = bd.ejecutarComando(consulta);
        } catch (Exception e) {
            
        }finally{
            bd.cerrarConexion();
        }
        return result;
    }

    @Override
    public boolean eliminar(int id) {
        boolean result = false;
        try {
            bd.abrirConexion();
            
            String consulta = "DELETE FROM alumno WHERE id = "+id;
            
            result = bd.ejecutarComando(consulta);
            
        } catch (Exception e) {
            
        }finally{
            bd.cerrarConexion();
        }
        return result;
    }

    @Override
    public List<Object> buscar() {
        List<Object> alumnos = new ArrayList<>();
        try {
            bd.abrirConexion();
            String consulta = "SELECT * FROM alumno";
            
            ResultSet rs = bd.consultarDatos(consulta);
            while(rs.next()){
                Alumno a = new Alumno();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setEmail(rs.getString("email"));
                a.setCarrera(rs.getString("carrera"));
                a.setSemestre(rs.getInt("semestre"));
                
                alumnos.add(a);
            }
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        
        return alumnos;
        
    }

    @Override
    public Object buscarId(int id) {
        Alumno a = new Alumno();
        try {
            bd.abrirConexion();
            String consulta = "SELECT * FROM alumno WHERE id ="+id;
            
            ResultSet rs = bd.consultarDatos(consulta);
            if(rs.next()){
               
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setEmail(rs.getString("email"));
                a.setCarrera(rs.getString("carrera"));
                a.setSemestre(rs.getInt("semestre"));
            }
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        
        return a;
    }
    
}
