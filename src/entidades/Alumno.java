package entidades;

public class Alumno {
    //Atributos
    private int id = 0;
    private String nombre = new String();
    private String email = new String();
    private int semestre = 0;
    private String carrera = new String();
    
    //Constructor
    public Alumno(){}
    
    //Getters and Setters
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public int getSemestre(){
        return this.semestre;
    }
    
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }
    
    public String getCarrera(){
        return this.carrera;
    }
    
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    //Metodos
}
