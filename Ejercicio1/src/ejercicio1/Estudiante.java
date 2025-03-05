
package ejercicio1;

public class Estudiante extends Persona{
    private int boleta;
    private String grupo;

    public Estudiante() {
    }

    public Estudiante(int boleta, String grupo, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.boleta = boleta;
        this.grupo = grupo;
    }
    
    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
}
