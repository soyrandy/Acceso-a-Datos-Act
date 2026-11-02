package tema1.boletin3;

public class Empleado {
    private String id;
    private String nombre;
    private String departamento;
    private double salario;

    public Empleado(String id, String nombre, String departamento, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }
}
