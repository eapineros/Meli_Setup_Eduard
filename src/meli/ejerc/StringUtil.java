package meli.ejerc;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c,int n)
    {
        String salida = "";
        for (int i = 0; i < n; i++) {
            salida = salida+c;
        }
        return salida;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        return replicate(c, n-s.length())+s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] valores = new String[arr.length];
        for(int i = 0; i < valores.length; i++) {
            valores[i] = Integer.toString(arr[i]);
        }
        return valores;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] valores = new int[arr.length];
        for(int i = 0; i < valores.length; i++) {
            valores[i] = Integer.parseInt(arr[i]);
        }
        return valores;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int resultado = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].length() > resultado){
                resultado = arr[i].length();
            }
        }
        return resultado;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    // Se cambio el void para que devolviera un String[]
    public static String[] lNormalize(String arr[], char c)
    {
        String[] valores = new String[arr.length];
        int maxLongitud = maxLength(arr);
        for(int i = 0; i < arr.length; i++) {
            valores[i] = lpad(arr[i],maxLongitud,'0');
        }
        return valores;
    }

}
