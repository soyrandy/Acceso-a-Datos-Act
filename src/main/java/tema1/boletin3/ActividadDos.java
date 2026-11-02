package tema1.boletin3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActividadDos {
    static void main() {
        List<Empleado> listaEmpleados = new ArrayList<>();

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
                String departamento = element.getElementsByTagName("departamento").item(0).getTextContent();
                double salario = Double.parseDouble(document.getElementsByTagName("salario").item(0).getTextContent());

                listaEmpleados.add(new Empleado(id, nombreEmpleado, departamento, salario));
            }

            Map<String, Integer> numEmpleados = new HashMap<>();
            Map<String, Double> sumaSalarios = new HashMap<>();

            for (Empleado emple : listaEmpleados) {
                String depa = emple.getDepartamento();
                numEmpleados.put(depa, numEmpleados.getOrDefault(depa, 0) + 1);
                sumaSalarios.put(depa, sumaSalarios.getOrDefault(depa, 0.0) + emple.getSalario());
            }

            System.out.println("Departamento  | Nº empleados | Salario medio");

            for (String dep : numEmpleados.keySet()) {
                int cantidad = numEmpleados.get(dep);
                double media = sumaSalarios.get(dep) / cantidad;

                System.out.printf("%-13s | %-12d | %.2f%n", dep, cantidad, media);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
