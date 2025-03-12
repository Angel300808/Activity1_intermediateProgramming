package ejercicio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Proceso {

    int contadorEstudiantes = 0;
    int contadorProfesores = 0;
    ArrayList<Persona> aper = new ArrayList();
    ArrayList<Estudiante> aest = new ArrayList();
    ArrayList<Profesor> apro = new ArrayList();

    Estudiante est = new Estudiante();
    Profesor prof = new Profesor();

    public void MenuPrincipal() {
        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción deseada: "
                        + "\n" + "1. Submenú de Estudiantes"
                        + "\n" + "2. Submenú de Profesores"
                        + "\n" + "3. Salir"));

                switch (opcion) {
                    case 1:
                        // Llamar al submenú de Estudiantes
                        MenuEstudiantes();
                        break;

                    case 2:
                        // Llamar al submenú de Profesores
                        MenuProfesores();
                        break;

                    case 3:
                        // Salir del programa
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                        return;

                    default:
                        JOptionPane.showMessageDialog(null, "Esa opción no existe.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresa datos correctamente");
                System.out.println(e);
            }

            repetir = JOptionPane.showInputDialog("¿Desea repetir el menú principal? (si/no)");
            if (repetir.equalsIgnoreCase("no")) {
                return;
            }
        }
    }

    // Submenú de Estudiantes
    public void MenuEstudiantes() {
        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción deseada para estudiantes: "
                        + "\n" + "1. Agregar Estudiante"
                        + "\n" + "2. Mostrar estudiantes"
                        + "\n" + "3. Actualizar estudiantes"
                        + "\n" + "4. Borrar estudiantes"
                        + "\n" + "5. Regresar al menú principal"));

                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog("Escribe el nombre: ");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Escribe la edad: "));
                        char genero = JOptionPane.showInputDialog("Escribe el genero: ").charAt(0);
                        int boleta = Integer.parseInt(JOptionPane.showInputDialog("Escribe la boleta: "));
                        String grupo = JOptionPane.showInputDialog("Escribe el grupo: ");

                        est = new Estudiante(boleta, grupo, nombre, edad, genero);
                        aest.add(est);
                        JOptionPane.showMessageDialog(null, "Estudiante agregado");

                        break;

                    case 2:
                        for (Estudiante e : aest) {
                            JOptionPane.showMessageDialog(null, ""
                                    + "Nombre: " + e.getNombre() + "\n"
                                    + "Grupo: " + e.getGrupo() + "\n"
                                    + "Boleta: " + e.getBoleta() + "\n"
                                    + "Edad: " + e.getEdad() + "\n"
                                    + "Género: " + e.getGenero());
                        }
                        break;

                    case 3:
                        if (aest.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");

                        }
                        for (Estudiante e : aest) {
                            int opc = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción que desea editar: "
                                    + "\n" + "1. Nombre"
                                    + "\n" + "2. Grupo"
                                    + "\n" + "3. Boleta"
                                    + "\n" + "4. Edad"
                                    + "\n" + "5. Genero"));
                            switch (opc) {
                                case 1:
                                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", e.getNombre());
                                    e.setNombre(nuevoNombre);
                                    break;
                                case 2:
                                    String nuevoGrupo = JOptionPane.showInputDialog("Nuevo grupo:", e.getGrupo());
                                    e.setGrupo(nuevoGrupo);
                                    break;
                                case 3:
                                    int nuevaBoleta = Integer.parseInt(JOptionPane.showInputDialog("Nueva boleta:", e.getBoleta()));
                                    e.setBoleta(nuevaBoleta);
                                    break;
                                case 4:
                                    int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:", e.getEdad()));
                                    e.setEdad(nuevaEdad);
                                    break;
                                case 5:
                                    char nuevoGenero = JOptionPane.showInputDialog("Nuevo género:", String.valueOf(e.getGenero())).charAt(0);
                                    e.setGenero(nuevoGenero);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                            }
                        }
                        break;

                    case 4:
                        if (aest.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
                        } else {
                            int boletaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta del estudiante a borrar: "));
                            Estudiante estudianteEliminar = null;
                            for (Estudiante e : aest) {
                                if (e.getBoleta() == boletaEliminar) {
                                    estudianteEliminar = e;
                                    break;
                                }
                            }
                            if (estudianteEliminar != null) {
                                aest.remove(estudianteEliminar);
                                JOptionPane.showMessageDialog(null, "Estudiante eliminado");
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró el estudiante con esa boleta.");
                            }
                        }
                        break;

                    case 5:
                        return;

                    default:
                        JOptionPane.showMessageDialog(null, "Esa opción no existe.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresa datos correctamente");
                System.out.println(e);
            }

            repetir = JOptionPane.showInputDialog("¿Desea repetir el menú de Estudiantes? (si/no)");
            if (repetir.equalsIgnoreCase("no")) {
                return;
            }
        }
    }

    // Submenú de Profesores
    public void MenuProfesores() {
        String repetir = "si";
        while (repetir.equalsIgnoreCase("si")) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción deseada para profesores: "
                        + "\n" + "1. Agregar profesor"
                        + "\n" + "2. Mostrar profesores"
                        + "\n" + "3. Actualizar profesores"
                        + "\n" + "4. Borrar profesores"
                        + "\n" + "5. Regresar al menú principal"));

                switch (opcion) {
                    case 1:
                        String nombreProf = JOptionPane.showInputDialog("Escribe el nombre del profesor: ");
                        int edadProf = Integer.parseInt(JOptionPane.showInputDialog("Escribe la edad del profesor: "));
                        char generoProf = JOptionPane.showInputDialog("Escribe el género del profesor: ").charAt(0);
                        String materia = JOptionPane.showInputDialog("Escribe la materia que enseña: ");
                        double salario = Double.parseDouble(JOptionPane.showInputDialog("Escribe el salario del profesor: "));
                        prof = new Profesor(nombreProf, edadProf, generoProf, materia, salario);
                        apro.add(prof);
                        JOptionPane.showMessageDialog(null, "Profesor agregado");

                        break;

                    case 2:
                        for (Profesor e : apro) {
                            JOptionPane.showMessageDialog(null, ""
                                    + "Nombre: " + e.getNombre() + "\n"
                                    + "Materia: " + e.getMateria() + "\n"
                                    + "Salario: " + e.getSalario() + "\n"
                                    + "Edad: " + e.getEdad() + "\n"
                                    + "Género: " + e.getGenero());
                        }
                        break;

                    case 3:
                        for (Profesor e : apro) {
                            int opc = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la opción que desea editar: "
                                    + "\n" + "1. Nombre"
                                    + "\n" + "2. Materia"
                                    + "\n" + "3. Salario"
                                    + "\n" + "4. Edad"
                                    + "\n" + "5. Genero"));
                            switch (opc) {
                                case 1:
                                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", e.getNombre());
                                    e.setNombre(nuevoNombre);
                                    break;
                                case 2:
                                    String nuevaMateria = JOptionPane.showInputDialog("Nueva materia:", e.getMateria());
                                    e.setMateria(nuevaMateria);
                                    break;
                                case 3:
                                    double nuevoSlario = Double.parseDouble(JOptionPane.showInputDialog("Nuevo salario:", e.getSalario()));
                                    e.setSalario(nuevoSlario);
                                    break;
                                case 4:
                                    int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:", e.getEdad()));
                                    e.setEdad(nuevaEdad);
                                    break;
                                case 5:
                                    char nuevoGenero = JOptionPane.showInputDialog("Nuevo género:", String.valueOf(e.getGenero())).charAt(0);
                                    e.setGenero(nuevoGenero);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                            }
                        }
                        break;

                    case 4:
                        if (apro.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
                        } else {
                            String nombreEliminar = JOptionPane.showInputDialog("Ingresa el nombre del profesor a borrar: ");
                            Profesor profesorEliminar = null;
                            for (Profesor p : apro) {
                                if (p.getNombre().equals(nombreEliminar)) {
                                    profesorEliminar = p;
                                    break;
                                }
                            }
                            if (profesorEliminar != null) {
                                apro.remove(profesorEliminar);
                                JOptionPane.showMessageDialog(null, "Profesor eliminado");
                            } else {
                                JOptionPane.showMessageDialog(null, "No se encontró el profesor con ese nombre.");
                            }
                        }
                        break;

                    case 5:
                        return;

                    default:
                        JOptionPane.showMessageDialog(null, "Esa opción no existe.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingresa datos correctamente");
                System.out.println(e);
            }

            repetir = JOptionPane.showInputDialog("¿Desea repetir el menú de Profesores? (si/no)");
            if (repetir.equalsIgnoreCase("no")) {
                return;
            }
        }
    }
}
