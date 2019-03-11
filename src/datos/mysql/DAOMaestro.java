package datos.mysql;

import datos.DAO;
import entidades.Maestro;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAOMaestro implements DAO {

    baseDatos bd = new baseDatos();

    @Override
    public boolean agregar(Object o) {

        boolean resultado = false;
        try {
            Maestro maestro = (Maestro) o;
            bd.abrirConexion();
            String consulta = "INSERT INTO maestro (noControl,nombre,titulo) "
                    + "VALUES ("
                    + maestro.getNoControl() + ","
                    + "'" + maestro.getNombre() + "'"
                    + "'" + maestro.getTitulo() + "'"
                    + ")";

            resultado = bd.ejecutarComando(consulta);

        } catch (Exception e) {
        } finally {
            bd.cerrarConexion();
        }
        return resultado;
    }

    @Override
    public boolean editar(Object o) {

        boolean resultado = false;
        try {
            Maestro maestro = (Maestro) o;
            bd.abrirConexion();
            String consulta = "UPDATE mestro SET"
                    +"noControl = "+ maestro.getNoControl() + ","
                    + "nombre = '" + maestro.getNombre() + "'"
                    + "titulo = '" + maestro.getTitulo() + "'"
                    + "WHERE id="+maestro.getId();

            resultado = bd.ejecutarComando(consulta);

        } catch (Exception e) {
        } finally {
            bd.cerrarConexion();
        }
        return resultado;
    }

    @Override
    public boolean eliminar(int id) {

        boolean resultado = false;
        try {            
            bd.abrirConexion();
            String consulta = "DELETE mestro "
                    + "WHERE id="+id;

            resultado = bd.ejecutarComando(consulta);

        } catch (Exception e) {
        } finally {
            bd.cerrarConexion();
        }
        return resultado;
    }

    @Override
    public List<Object> buscar() {
        List<Object> maestros = new ArrayList();
        try {
            bd.abrirConexion();
            
            String consulta = "SELECT * FROM mestro";
            
            ResultSet res = bd.consultarDatos(consulta);
            
            while(res.next()){
                Maestro m = new Maestro();
                m.setId(res.getInt("id"));
                m.setNoControl(res.getInt("noControl"));
                m.setNombre(res.getString("nombre"));
                m.setTitulo(res.getString("titulo"));
                
                maestros.add(m);
            }
            
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        return maestros;
    }

    @Override
    public Object buscarId(int id) {

        Maestro m = new Maestro();
        try {
            bd.abrirConexion();
            
            String consulta = "SELECT * FROM mestro WHERE id= "+id;
            
            ResultSet res = bd.consultarDatos(consulta);
            
            while(res.next()){
                
                m.setId(res.getInt("id"));
                m.setNoControl(res.getInt("noControl"));
                m.setNombre(res.getString("nombre"));
                m.setTitulo(res.getString("titulo"));
                
                
            }
            
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        return m;
    }

}
