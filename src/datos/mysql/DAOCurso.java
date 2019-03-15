/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.mysql;

import datos.DAO;
import entidades.Curso;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ulymay
 */
public class DAOCurso implements DAO{
    baseDatos bd = new baseDatos();
    
    @Override
    public boolean agregar(Object o) {
        boolean resultado = false;
        try {
            Curso curso = (Curso) o;
            bd.abrirConexion();
            String consulta = "INSERT INTO curso "
                    + " (idMaestro,nombre,fecha,hora) VALUES ("
                    + curso.getIdMaestro()+", "
                    + "'"+curso.getNombre()+"', "
                    + "'"+curso.getFecha()+"', "//YYYY-mm-dd
                    + "'"+curso.getHora()+"'"//HH:mm:ss
                    + ")";
            resultado =bd.ejecutarComando(consulta);
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        
        return resultado;
    }

    @Override
    public boolean editar(Object o) {
        boolean resultado = false;
        try {
            Curso curso = (Curso) o;
            bd.abrirConexion();
            String consulta = "UPDATE curso SET "
                    + "idMaestro = "+curso.getIdMaestro()+", "
                    + "nombre = '"+curso.getNombre()+"', "
                    + "fecha = '"+curso.getFecha()+"', "//YYYY-mm-dd
                    + "hora = '"+curso.getHora()+"'"
                    + " WHERE id= "+curso.getId();
            resultado =bd.ejecutarComando(consulta);
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        
        return resultado;
    }

    @Override
    public boolean eliminar(int id) {
         boolean resultado = false;
        try {            
            bd.abrirConexion();
            String consulta = "DELETE FROM curso "
                    + " WHERE id= "+id;
            resultado =bd.ejecutarComando(consulta);
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        
        return resultado;
    }

    @Override
    public List<Object> buscar() {
        List<Object> cursos = new ArrayList();
        
        try {
            bd.abrirConexion();
            String consulta = "SELECT * FROM curso";
            ResultSet res = bd.consultarDatos(consulta);
            
            while(res.next()){
                Curso c = new Curso();
                c.setId(res.getInt("id"));
                c.setIdMaestro(res.getInt("idMaestro"));
                c.setNombre(res.getString("nombre"));
                c.setFecha(res.getString("fecha"));
                c.setHora(res.getString("hora"));
                cursos.add(c);
            }
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        return cursos;
    }

    @Override
    public Object buscarId(int id) {
        Curso c = new Curso();
        try {
            bd.abrirConexion();
            String consulta = "SELECT * FROM curso WHERE id = "+id;
            ResultSet res = bd.consultarDatos(consulta);
            
            if(res.next()){
                
                c.setId(res.getInt("id"));
                c.setIdMaestro(res.getInt("idMaestro"));
                c.setNombre(res.getString("nombre"));
                c.setFecha(res.getString("fecha"));
                c.setHora(res.getString("hora"));
                
            }
        } catch (Exception e) {
        }finally{
            bd.cerrarConexion();
        }
        return c;
    }
    
    public boolean registrarAlumno(int curso, int alumno){
        boolean resultado = false;
        try{
            bd.abrirConexion();
            String consulta = "INSERT INTO cursoAlumno "
                    + "(idCurso,idAlumno) VALUES ("
                    + curso+","
                    + alumno+" )";
            
            resultado = bd.ejecutarComando(consulta);
        }catch (Exception e){
            
        }finally{
            bd.cerrarConexion();
        }
               
        
        return resultado;
    }
    
    public boolean darBajaAlumno(int id){
        boolean resultado = false;
        try{
            bd.abrirConexion();
            String consulta = "DELETE FROM cursoAlumno "
                    + " WHERE id = "+id;
            
            resultado = bd.ejecutarComando(consulta);
        }catch (Exception e){
            
        }finally{
            bd.cerrarConexion();
        }
               
        
        return resultado;
    }
    
}
