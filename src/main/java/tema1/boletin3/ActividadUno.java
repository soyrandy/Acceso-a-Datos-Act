package tema1.boletin3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ActividadUno {
    static void main() {
        try {
            File archivo = new File("/home/randy/Escritorio/Datasets-20261026/empleados.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivo);

            NodeList lista = document.getElementsByTagName("empleado");

            for (int i = 0; i < lista.getLength(); i++){
                Element element = (Element) lista.item(i);
                String id = element.getAttribute("id");
                String nombreEmpleado = element.getElementsByTagName("nombre").item(0).getTextContent();
                String salario = element.getElementsByTagName("salario").item(0).getTextContent();
                System.out.println("ID: " + id + " Nombre: " + nombreEmpleado + " Salario: " + salario + "€.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
