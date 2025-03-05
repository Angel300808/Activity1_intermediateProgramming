package ejercicio1;

public class Profesor extends Persona {
    private String materia;
    private double salario;

    public Profesor() {
    }

    public Profesor(String nombre, int edad, char genero, String materia, double salario) {
        super(nombre, edad, genero);
        this.materia = materia;
        this.salario = salario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
