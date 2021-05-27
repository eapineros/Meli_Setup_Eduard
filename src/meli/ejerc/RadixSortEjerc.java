package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadixSortEjerc {
    static StringUtil util = new StringUtil();

    public static String[] radixSort(int[] arr) {
        //Convertir el array que vamos a ordenar, de int[] a String[].
        String[] respuesta = util.toStringArray(arr);

        //Normalizamos el array para que todos tengan la misma longitud
        respuesta = util.lNormalize(respuesta, '0');

        //Creamo un hashMap para el manejo de las listas
        Map<Character, List<String>> mapa = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            mapa.put((char) (i + '0'), new ArrayList<>());
        }

        // definimos el iterador
        int iterator = util.maxLength(respuesta) - 1;

        while (iterator + 1 != 0) {
            //Llenamos el hashmap
            for (int i = 0; i < respuesta.length; i++) {
                String numero = respuesta[i];
                char indice = numero.charAt(iterator);
                mapa.get(indice).add(numero);
            }

            //Recorremos el map
            int j = 0;
            for (Map.Entry<Character, List<String>> entry : mapa.entrySet()) {
                Character key = entry.getKey();
                List<String> value = entry.getValue();
                for (String x : value) {
                    if (j == 11) {
                        break;
                    }
                    respuesta[j] = x;
                    j++;
                }
                mapa.get(key).clear();
            }
            iterator--;
        }
        return respuesta;
    }

    public static void main(String[] args) {

        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        int[] res = util.toIntArray(radixSort(arr));

        for (int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + (i < res.length - 1 ? "," : ""));
        }
    }
}
