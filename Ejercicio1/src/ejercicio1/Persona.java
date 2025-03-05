  package ejercicio1;
 
import javax.swing.JOptionPane;

 
public class Persona {
    //Atributes
    private String nombre;
    private int edad;
    private char genero;
    
    //Methods
    
    Persona(){
        //constructor vacio
    }
    
    Persona(String nombre, int edad, char genero){
        this.nombre=nombre;
        this.edad=edad;
        this.genero=genero;
    }
    
    void setNombre(String nombre){
        this.nombre=nombre;
    }
    void setEdad(int edad){
        this.edad=edad;
    }
    void setGenero(char genero){
        this.genero=genero;
    }
    
    String getNombre(){
        return nombre;
    }
    int getEdad(){
        return edad;
    }
    char getGenero(){
        return genero;
    }
    public void mostrarNombre(){
        
        JOptionPane.showMessageDialog(null, 
                "El nombre es: " + nombre+"\n"
                    + "La edad es: " + edad + "\n"
                        + "El genero es: " + genero + "\n");
        
    }
    public void agregarPersona(){
            
        nombre = JOptionPane.showInputDialog( "Ingresa tu nombre: ");
        edad = Integer.parseInt(JOptionPane.showInputDialog( "Ingresa tu edad: "));
        genero = JOptionPane.showInputDialog( "Ingresa tu genero: ").charAt(0);

        
    }
    
}
    

   

