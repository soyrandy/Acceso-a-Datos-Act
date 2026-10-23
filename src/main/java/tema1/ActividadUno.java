package tema1;

import java.io.File;

public class ActividadUno {
    static void main() {
        //Origen del directorio
        String origen = "/home/randy/Escritorio/Acceso_a_Datos_Actividades/ficheros/Prueba.txt";
        File carpeta = new File(origen);

        /*
        1. Comprueba si la carpeta existe y es un directorio.
        2. Si no, existe pero no es un directorio.
         */
        if (carpeta.exists() && carpeta.isDirectory()) {
            IO.println("La carpeta si existe y es un directorio.");
        } else if (carpeta.exists()) {
            IO.println("Existe pero no es un directorio.");
        } else {
            IO.println("La carpeta no existe.");
        }
    }
}
