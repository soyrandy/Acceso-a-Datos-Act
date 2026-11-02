package tema1.boletin3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ActividadTres {
    static void main() {
        try {
            File archivo = new File("/home/randy/Escritorio/Datasets-20261026/biblioteca.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivo);

            NodeList listaLibros = document.getElementsByTagName("libro");

            System.out.println("");
            System.out.println("----- TÍTULOS DE LOS LIBROS -----");
            for (int i = 0; i < listaLibros.getLength(); i++) {
                Element libro = (Element) listaLibros.item(i);
                String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
                System.out.println("- " + titulo);
            }

            Map<String, Integer> contadorGeneros = new HashMap<>();

            for (int i = 0; i < listaLibros.getLength(); i++) {
                Element libro = (Element) listaLibros.item(i);
                NodeList listaGeneros = libro.getElementsByTagName("genero");

                for (int j = 0; j < listaGeneros.getLength(); j++) {
                    String genero = listaGeneros.item(j).getTextContent();
                    contadorGeneros.put(genero, contadorGeneros.getOrDefault(genero, 0) + 1);
                }
            }
            System.out.println("");
            System.out.println("----- CONTAR POR GÉNEROS -----");
            for (String genero : contadorGeneros.keySet()) {
                System.out.println(genero + ": " + contadorGeneros.get(genero) + " libro/s");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
