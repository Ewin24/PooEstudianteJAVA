//Edwin Trigos y Santiago Marquez B191 POO
package tareasoftnotas;

import static tareasoftnotas.Estudiante.cadena;

public class Estudiante {

    String nombre;
    String cedula;
    float promedioAcumulado;
    int creditosCursados;

    public Estudiante(String nombre, String cedula, float promedioAcumulado, int creditosCursados) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.promedioAcumulado = promedioAcumulado;
        this.creditosCursados = creditosCursados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public float getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    public int getCreditosCursados() {
        return creditosCursados;
    }

    public void setCreditosCursados(int creditosCursados) {
        this.creditosCursados = creditosCursados;
    }

    public float nuevoProm(float promedioAcumulado, int creditosVistos, float promedioSemestre, int creditosSemestre) {
        float nuevoProm = (promedioAcumulado * creditosVistos + promedioSemestre * creditosSemestre) / (creditosVistos + creditosSemestre);
        return nuevoProm;
    }

    public static String cadena(Estudiante[] estudiantes) {
        String cadena = "";

        for (int i = 0; i < estudiantes.length; i++) {
            cadena += "\nCedula: " + estudiantes[i].getCedula() + "\n" + "Nombre: " + estudiantes[i].getNombre() + "\n" + "Promedio acumulado: " + estudiantes[i].getPromedioAcumulado() + "Creditos del estudiante: " + estudiantes[1].getCreditosCursados() + "\n";
        }
        return cadena;
    }

    //metodo que obtiene la lista de los estudiantes, sacando los valores de la matriz y anidandolos en un String
    public static String getEstudiantesxpromedio(Estudiante[] estudiantes, float filtro) {
        int cantidadEstudiantes = 0;

        for (int i = 0; i < estudiantes.length;) {
            if (estudiantes[i].getPromedioAcumulado() > filtro) {
                cantidadEstudiantes++;
            }
            i++;
        }
        //arreglo para guardar los estudiantes que cumplan con el promedio
        Estudiante[] estudiantesArreglo = new Estudiante[cantidadEstudiantes];

        //agregando los estudiantes a la lista y devolciendolos como String
        for (int i = 0; i < estudiantes.length;) {
            if (estudiantes[i].getPromedioAcumulado() > filtro) {
                for (int j = 0; j < 10; j++) {
                    //sacamos los datos del arreglo
                    String nom = estudiantes[i].getNombre();
                    String cedula = estudiantes[i].getCedula();
                    int creditos = estudiantes[i].getCreditosCursados();
                    float promedio = estudiantes[i].getPromedioAcumulado();

                    //creacion de estudiantes con el promedio
                    Estudiante e1 = new Estudiante(nom, cedula, promedio, creditos);

                    //insertando los estudiantes filtrados en el nuevo arreglo
                    estudiantesArreglo[i] = e1;
                }
            }
            i++;
        }
        //retornando la lista con los estudiantes
        String lista = cadena(estudiantesArreglo);
        if (cantidadEstudiantes == 0) {
            lista = "\n No se encontraron estudiantes con el promedio dado \n";
        }
        return lista;
    }

    public static void setNuevoPromedio(int i, String cedula, float promedioSemestre, int creditosVistos, Estudiante[] estudiantes) {
        //calculo del  nuevo promedio para el estudiante:
        float nuevoprom = (estudiantes[i].getPromedioAcumulado() * estudiantes[i].getCreditosCursados() + estudiantes[i].getPromedioAcumulado() * promedioSemestre) / (creditosVistos + estudiantes[i].getCreditosCursados());
        estudiantes[i].setPromedioAcumulado(nuevoprom);
    }

    public static String getEstudianteMejorProm(Estudiante[] estudiantes) {

        Estudiante[] estudiantePepa = new Estudiante[1];
        estudiantePepa[0] = estudiantes[1];
        
        for (int i = 0; i < estudiantes.length;) {
            if (estudiantes[i].getPromedioAcumulado() > estudiantePepa[0].getPromedioAcumulado()) {
                estudiantes[i] = estudiantePepa[0];
            }
            i++;
        }               
        
        //retornando la lista con los estudiantes
        String informacionEstudiante = cadena(estudiantePepa);
        if (estudiantePepa[0].getNombre() == null) {
            informacionEstudiante = "\n No hay estudiantes en la lista \n";
        }
        
        return informacionEstudiante;
    }
}
