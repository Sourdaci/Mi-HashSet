import java.util.Arrays;
/**
 * Coleccion de enteros
 * Interfaz ArrayList
 * Implementacion Array
 * 
 * @author Sourdaci
 * @version 1.1 (2015-03-02 02)
 */
public class MiHashSet
{
    // Declaracion de int[] que almacena los valores
    private int[] arrayDeEnteros;

    /**
     * Inicializacion de atributos
     */
    public MiHashSet()
    {
        arrayDeEnteros = new int[0];
    }

    /**
     * Agregamos un valor al final del array
     * 
     * @param valor El valor que queremos almacenar
     * @return 'true' si se ha incluido el valor, 'false' si el valor ya existe
     */
    public boolean add(int valor){
        boolean exito = true;
        if (!contains(valor)){
            int longitudBase = arrayDeEnteros.length; // Guardo tamaño
            // Creo una copia de si mismo con un espacio mas
            arrayDeEnteros = Arrays.copyOf(arrayDeEnteros, (longitudBase + 1));
            // Agrego el valor en la ultima posicion, que es el tamaño antes de la copia
            arrayDeEnteros[longitudBase] = valor;
        }else{
            exito = false;
        }
        return exito;
    }
    
    /**
     * Elimina la coleccion, y crea una vacia
     */
    public void clear(){
        arrayDeEnteros = new int[0];
    }
    
    /**
     * Busca el elemento pedido
     * 
     * @param valor El valor que quieres saber si existe
     * @return 'true' si se encuentra el valor, 'false' si no se encuentra
     */
    public boolean contains(int elemento){
        boolean existe = false;
        int contador = 0;
        int longitud = arrayDeEnteros.length;
        while (!existe && contador < longitud){
            if(arrayDeEnteros[contador] == elemento){
                existe = true;
            }else{
                contador++;
            }
        }
        return existe;
    }
    
    /**
     * Indica si el MiHashSet esta o no vacio
     * 
     * @return 'true' si MiHashSet esta vacio, 'false' si contiene elementos
     */
    public boolean isEmpty(){
        return (arrayDeEnteros.length == 0);
    }
    
    /**
     * Elimina el elemento indicado
     * 
     * @param valor El elemento a borrar
     * @return 'true' si se ha borrado el valor, 'false' si el valor no existe
     */
    public boolean remove(int valor){
        boolean existe = contains(valor);
        if (existe){
            int longitud = arrayDeEnteros.length;
            int[] arrayTemp = new int[longitud - 1];
            int contador = 0;
            for (; arrayDeEnteros[contador] != valor; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador];
            }
            for (; contador < longitud - 1; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador + 1];
            }
            arrayDeEnteros = arrayTemp;
        }
        return existe;
    }
    
    /**
     * Devuelve el numero de elementos guardados
     * 
     * @return El numero de valores almacenados en MiHashSet
     */
    public int size(){
        return arrayDeEnteros.length;
    }
    
    /**
     * Representacion del contenido del MiHashMap como String
     * Formato: [1,2,3,4]
     * 
     * @return 'String' que contiene los valores guardados en MiHashMap
     */
    public String toString(){
        String cadena ="[";
        if(arrayDeEnteros.length != 0){
            cadena += arrayDeEnteros[0];
            int contador = 1;
            for (; contador < arrayDeEnteros.length; contador++){
                cadena += ("," + arrayDeEnteros[contador]);
            }
        }
        cadena += "]";
        return cadena;
    }
    
    /**
     * Compara este MiHashSet con otro
     * 
     * @param otroArray El 'MiHashSet' que quiere compararse
     * @return 'true' si son iguales, 'false' si son diferentes
     */
    public boolean equals(MiHashSet otroArray){
        boolean iguales = true;
        int longitudArray = arrayDeEnteros.length;
        if (longitudArray == otroArray.size()){
            int contador = 0;
            for (; ((contador < longitudArray) && (iguales)); contador++){
                if(!otroArray.contains(arrayDeEnteros[contador])){
                    iguales = false;
                }
            }
        }else{
            iguales = false;
        }
        return iguales;
    }
}
