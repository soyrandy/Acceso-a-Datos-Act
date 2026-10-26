package parses;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MainParsers {
    static void main() {
        try {
            Empleado[] empleados = ActividadUno.parsearEmpleados("/home/randy/Escritorio/Datasets-20261026/empleados.xml");
            for (Empleado empleado : empleados){
                System.out.println(empleado);
            }
        } catch (IOException e){
            System.err.println("Error al leer el fichero de empleados");
        } catch (ParserConfigurationException e) {
            System.err.println("Error al leer interpretar el fichero de empleados");
        } catch (SAXException e) {
            System.err.println("Error al construir el DOM jerárquico de empleados");
        }
    }
}
