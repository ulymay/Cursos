package datos;

import java.util.List;

public interface DAO {
    
    public boolean agregar(Object o);
    public boolean editar(Object o);
    public boolean eliminar(int id);
    public List<Object> buscar();
    public Object buscarId(int id);
    
}
