package tema1;

import java.util.ArrayList;

public class MiHashMap {
    // Array de claves
    private String[] claves;
    // Array de valores
    // Array de ArrayList ????
    private ArrayList<Pareja>[] valores;

    public MiHashMap(int tamanyo) {
        claves = new String[tamanyo];
        valores = new ArrayList[tamanyo];

        for (int i = 0; i < tamanyo; i++){
            valores[i] = new ArrayList<>();
        }
    }

    public String get(String clave) {
        // A completar
        int posicion = hash(clave);
        for (Pareja pareja : valores[posicion]){
            if (pareja.clave.equals(clave)){
                return pareja.valor;
            }
        }
        return null;
    }

    public String put(String clave, String valor) {
        // A completar
        int posicion = hash(clave);
        for (Pareja pareja : valores[posicion]){
            if (pareja.clave.equals(clave)){
                String valorAntiguo = pareja.valor;
                pareja.valor = valor;
                return valorAntiguo;
            }
        }
        valores[posicion].add(new Pareja(clave, valor));
        return clave;
    }

    private int hash(String clave) {
        int suma = 0;
        for (int i = 0; i < clave.length(); i++) {
            suma += (int)clave.charAt(i);
        }
        return suma % clave.length();
    }


    class Pareja {
        private String clave;
        private String valor;

        public Pareja(String valor, String clave) {
            this.valor = valor;
            this.clave = clave;
        }
    }
}
