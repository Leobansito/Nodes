// Clase Nodo: representa cada "cajita" de la lista
class Nodo {
    int dato;          // El valor que guarda el nodo
    Nodo siguiente;    // Referencia al siguiente nodo

    // Constructor: inicializa el nodo con un dato
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null; // Al inicio no apunta a nadie
    }
}

// Clase ListaEnlazada: maneja toda la lista
public class ListaEnlazada {

    // ===== ATRIBUTO PRINCIPAL =====
    // 'cabeza' apunta al primer nodo de la lista.
    // Si la lista está vacía, cabeza == null.
    private Nodo cabeza;

    // ===== CONSTRUCTOR =====
    // Al crear la lista, está vacía: cabeza apunta a null.
    public ListaEnlazada() {
        this.cabeza = null;
    }

    // PASO 3: Método estaVacia()
    // Devuelve true si la lista no tiene ningún nodo.
    public boolean estaVacia() {
        return cabeza == null;
    }

    // PASO 4: Método insertarAlInicio(int dato)
    // Inserta un nodo al principio de la lista.
    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);   // Creamos el nuevo nodo
        nuevo.siguiente = cabeza;      // El nuevo apunta al que era cabeza
        cabeza = nuevo;                // Ahora cabeza es el nuevo nodo
    }

    // PASO 5: Método insertarAlFinal(int dato)
    // Inserta un nodo al final de la lista.
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);   // Creamos el nuevo nodo
        if (cabeza == null) {          // Caso especial: lista vacía
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;          // Recorremos desde la cabeza
        while (actual.siguiente != null) { // Avanzamos hasta el último nodo
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;      // El último apunta al nuevo
    }

    // PASO 6: Método imprimir()
    // Recorre la lista y muestra los datos.
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> "); // Flecha entre nodos
            }
            actual = actual.siguiente; // Avanzamos al siguiente nodo
        }
        System.out.println(); // Salto de línea al final
    }

    // PASO 7: Método buscar(int dato)
    // Devuelve true si el dato existe en la lista.
    public boolean buscar(int dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                return true; // Encontrado
            }
            actual = actual.siguiente;
        }
        return false; // No encontrado
    }

    // PASO 8: Método eliminar(int dato)
    // Elimina el nodo que contiene el dato.
    public boolean eliminar(int dato) {
        if (cabeza == null) { // Lista vacía
            return false;
        }
        if (cabeza.dato == dato) { // El dato está en la cabeza
            cabeza = cabeza.siguiente;
            return true;
        }
        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;
        while (actual != null) {
            if (actual.dato == dato) {
                anterior.siguiente = actual.siguiente; // Saltamos el nodo
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false; // No se encontró el dato
    }

    // PASO 9: Método contar()
    // Devuelve cuántos nodos hay en la lista.
    public int contar() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // PASO 10: Método obtener(int indice)
    // Devuelve el dato en la posición indicada (empezando en 0).
    public int obtener(int indice) {
        if (indice < 0) {
            throw new IndexOutOfBoundsException("Índice negativo: " + indice);
        }
        Nodo actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (posicion == indice) {
                return actual.dato;
            }
            actual = actual.siguiente;
            posicion++;
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
    }

    // Método main para probar la lista
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.insertarAlInicio(10); // Lista: 10
        lista.insertarAlFinal(20);  // Lista: 10 → 20
        lista.insertarAlFinal(30);  // Lista: 10 → 20 → 30

        lista.imprimir(); // Muestra: 10 → 20 → 30

        System.out.println("Buscar 20: " + lista.buscar(20)); // true
        System.out.println("Eliminar 20: " + lista.eliminar(20)); // true
        lista.imprimir(); // Muestra: 10 → 30

        System.out.println("Total nodos: " + lista.contar()); // 2
        System.out.println("Dato en índice 1: " + lista.obtener(1)); // 30
    }
}
