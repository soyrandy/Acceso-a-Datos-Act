package tema1;

public class MainHash {
    static void main() {
        MiHashMap map = new MiHashMap(256);
        map.put("Hello", "hola");
        map.put("Table", "mesa");

        System.out.println(map.get("Hello"));
        System.out.println(map.get("Table"));
    }
}
