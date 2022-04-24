//Edwin Trigos y Santiago Marquez B191 POO
package tareasoftnotas;

import java.util.Scanner;
import static tareasoftnotas.Estudiante.cadena;
import static tareasoftnotas.Estudiante.getEstudiantesxpromedio;
import static tareasoftnotas.Estudiante.setNuevoPromedio;

public class TareaSoftNotas {

    public static void main(String[] args) {

        //declaracion de Scanner
        Scanner lector = new Scanner(System.in);

        //variables para crear el objeto estudiantes
        String nombre;
        float promedio;
        int creditos;

        //declaracion de variables para usar en el nuevoProm del punto 2
        //(se hace uso de las variable creditos y promedio ya creadas)
        int opc;
        String cedula = "";

        //peticion del numero de estudiantes
        int numeroEstudiantes;
        System.out.println("Ingrese el numero de estudiantes a registrar: ");
        numeroEstudiantes = lector.nextInt();

        //creacion de la matriz de estudiantes
        Estudiante[] estudiantes = new Estudiante[numeroEstudiantes];

        //peticion de datos de acuerdo al numero de estudiantes ingresados
        for (int i = 0; i < numeroEstudiantes;) {
            int num = i + 1;

            System.out.println("Nombre del estudiante " + num + " :");
            nombre = lector.next();
            System.out.println("Cedula del estudiante " + num + " :");
            cedula = lector.next();
            System.out.println("Promedio acumulado del estudiante " + num + " :");
            promedio = lector.nextFloat();
            System.out.println("Creditos cursados del estudiante " + num + " :");
            creditos = lector.nextInt();
            System.out.println("\n");

            // Creacion de un nuevo objeto estudiante con los datos recolectados
            Estudiante estudiante1 = new Estudiante(nombre, cedula, promedio, creditos);

            // Asignacion del estudiante en una posicion de la matriz
            estudiantes[i] = estudiante1;

            i++;
        }

        boolean salir = false;
        do {
            //menu       
            System.out.println("-----------------------------Menu de opciones----------------------------- \n");
            System.out.println("1. Calcular nuevo promedio: ");
            System.out.println("2. listado de estudiantes con promedio: ");
            System.out.println("3. listado de estudiantes actuales: ");
            System.out.println("4. Buscar el estudiante con el mejor promedio y mostrar sus datos: ");
            System.out.println("0. salir");
            System.out.println("Seleccione una de las opciones anteriores: \n ");

            opc = lector.nextInt();

            switch(opc) {
                case 1:
                    //peticion de la cedula del estudiantes                    
                    System.out.println("Cedula del estudiante a modificar el promedio: ");
                    cedula = lector.next();
                    for (int i = 0; i < estudiantes.length;) {
                        //hacer validacion con cedula
                        if (estudiantes[i].getCedula().equals(cedula)) {
                            System.out.println("Numero de creditos vistos en el semestre: ");
                            creditos = lector.nextInt();
                            System.out.println("Promedio obtenido por el estudiante en este semestre: ");
                            promedio = lector.nextFloat();

                            //se puede hacer la asignacion aqui o mediante un metodo
                            setNuevoPromedio(i, cedula, promedio, creditos, estudiantes);
                            i++;
                        }
                    }
                    break;

                case 2:
                    if (opc == 2) {
                        System.out.println("Nota para filtrar el listado: ");
                        float filtro = lector.nextFloat();
                        String lista = getEstudiantesxpromedio(estudiantes, filtro);
                        System.out.println("\n------------------------------------ Estudiantes con el promedio superior a " + filtro + " ------------------------------------\n");
                        System.out.println(lista);

                    }
                    break;

                case 3:
                    if (opc == 3) {
                        String listaMuestra = cadena(estudiantes);
                        System.out.println(listaMuestra);
                    }
                    break;

                case 4:
                    if (opc == 4) {
                        String informacion = Estudiante.getEstudianteMejorProm(estudiantes);
                        System.out.println(informacion);
                    }
                    break;

                case 0:
                    if (opc == 0) {
                        salir = true;
                    }
                    break;

                default:
                    System.out.println("La opcion elegida es incorrecta");
            }
        } while (!salir);
    }
}
