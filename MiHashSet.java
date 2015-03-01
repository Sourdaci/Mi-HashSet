 
import java.util.Arrays;
/**
 * Coleccion de enteros
 * Interfaz ArrayList
 * Implementacion Array
 */
public class MiHashSet
{
    // instance variables - replace the example below with your own
    private int[] arrayDeEnteros;

    /**
     * Creamos el array vacio
     */
    public MiHashSet()
    {
        arrayDeEnteros = new int[0];
    }

    /**
     * Agregamos un entero al final del array
     */
    public boolean add(int valor){
        boolean existe = true;
        if (!contains(valor)){
            int longitudBase = arrayDeEnteros.length; // Guardo tamaño
            // Creo una copia de si mismo con un espacio mas
            arrayDeEnteros = Arrays.copyOf(arrayDeEnteros, (longitudBase + 1));
            // Agrego el valor en la ultima posicion, que es el tamaño antes de la copia
            arrayDeEnteros[longitudBase] = valor;
        }else{
            existe = false;
        }
        return existe;
    }
    
    /**
     * Elimina la coleccion, y crea una vacia
     */
    public void clear(){
        arrayDeEnteros = new int[0];
    }
    
    /**
     * Busca el elemento pedido
     * Si existe, devuelve true
     * Si no existe, devuelve false
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
     * Devuelve true si no hay enteros guardados
     * Devuelve false si hay algun elemento guardado
     */
    public boolean isEmpty(){
        return (arrayDeEnteros.length == 0);
    }
    
    /**
     * Elimina el elemento indicado
     * Si existe, devuelve true
     * Si no existe, devuelve false
     */
    public boolean remove(int elemento){
        boolean existe = contains(elemento);
        if (existe){
            int longitud = arrayDeEnteros.length;
            int[] arrayTemp = new int[longitud - 1];
            int contador = 0;
            for (; arrayDeEnteros[contador] != elemento; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador];
            }
            for (; contador < longitud - 1; contador++){
                arrayTemp[contador] = arrayDeEnteros[contador + 1];
            }
            arrayDeEnteros = arrayTemp;
        }
        return existe;
    }
}
