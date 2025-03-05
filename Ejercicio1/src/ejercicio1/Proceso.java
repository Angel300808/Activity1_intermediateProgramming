package ejercicio1;

import javax.swing.JOptionPane;

public class Proceso {
    int contadorEstudiantes = 0;
    int contadorProfesores = 0;
    Estudiante est[] = new Estudiante[10];
    Profesor prof[] = new Profesor[10];

    public void Menu() {
        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción deseada: "
                        + "\n" + "1. Menú Alumno y Profesor"
                        + "\n" + "2. Salir"));

                switch (opcion) {
                    case 1:
                        MenuAlumnoProfesor();
                        break;

                    case 2:
                        // Salir
                        System.exit(0);

                    default:
                        JOptionPane.showMessageDialog(null, "Esa opción no existe");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresa datos correctamente");
                System.out.println(e);
            }

            repetir = JOptionPane.showInputDialog("¿Desea repetir el programa? (si/no)");
            if (repetir.equalsIgnoreCase("no")) {
                System.exit(0);
            }
        }
    }

    public void MenuAlumnoProfesor() {
        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción deseada: "
                        + "\n" + "1. Agregar Estudiante"
                        + "\n" + "2. Mostrar estudiantes"
                        + "\n" + "3. Agregar profesor"
                        + "\n" + "4. Mostrar profesores"
                        + "\n" + "5. Regresar al menú principal"));

                switch (opcion) {
                    case 1:
                        if (contadorEstudiantes < 10) {
                            String nombre = JOptionPane.showInputDialog("Escribe el nombre: ");
                            int edad = Integer.parseInt(JOptionPane.showInputDialog("Escribe la edad: "));
                            char genero = JOptionPane.showInputDialog("Escribe el genero: ").charAt(0);
                            int boleta = Integer.parseInt(JOptionPane.showInputDialog("Escribe la boleta: "));
                            String grupo = JOptionPane.showInputDialog("Escribe el grupo: ");
                            est[contadorEstudiantes] = new Estudiante(boleta, grupo, nombre, edad, genero);
                            contadorEstudiantes++;
                        } else {
                            JOptionPane.showMessageDialog(null, "El límite de estudiantes es 10.");
                        }
                        break;

                    case 2:
                        for (int i = 0; i < contadorEstudiantes; i++) {
                            JOptionPane.showMessageDialog(null, ""
                                    + "Estudiante " + (i + 1) + ":\n"
                                    + "Nombre: " + est[i].getNombre() + "\n"
                                    + "Grupo: " + est[i].getGrupo() + "\n"
                                    + "Boleta: " + est[i].getBoleta() + "\n"
                                    + "Edad: " + est[i].getEdad() + "\n"
                                    + "Género: " + est[i].getGenero());
                        }
                        break;

                    case 3:
                        if (contadorProfesores < 10) {
                            String nombreProf = JOptionPane.showInputDialog("Escribe el nombre del profesor: ");
                            int edadProf = Integer.parseInt(JOptionPane.showInputDialog("Escribe la edad del profesor: "));
                            char generoProf = JOptionPane.showInputDialog("Escribe el género del profesor: ").charAt(0);
                            String materia = JOptionPane.showInputDialog("Escribe la materia que enseña: ");
                            double salario = Double.parseDouble(JOptionPane.showInputDialog("Escribe el salario del profesor: "));
                            prof[contadorProfesores] = new Profesor(nombreProf, edadProf, generoProf, materia, salario);
                            contadorProfesores++;
                        } else {
                            JOptionPane.showMessageDialog(null, "El límite de profesores es 10.");
                        }
                        break;

                    case 4:
                        for (int i = 0; i < contadorProfesores; i++) {
                            JOptionPane.showMessageDialog(null, ""
                                    + "Profesor " + (i + 1) + ":\n"
                                    + "Nombre: " + prof[i].getNombre() + "\n"
                                    + "Materia: " + prof[i].getMateria() + "\n"
                                    + "Salario: " + prof[i].getSalario() + "\n"
                                    + "Edad: " + prof[i].getEdad() + "\n"
                                    + "Género: " + prof[i].getGenero());
                        }
                        break;

                    case 5:
                        return; 

                    default:
                        JOptionPane.showMessageDialog(null, "Esa opción no existe");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresa datos correctamente");
                System.out.println(e);
            }

            repetir = JOptionPane.showInputDialog("¿Desea repetir el menú de Alumno y Profesor? (si/no)");
            if (repetir.equalsIgnoreCase("no")) {
                return; 
            }
        }
    }
}