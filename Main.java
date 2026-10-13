public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("¿Está vacía? " + lista.estaVacia()); // true

        // Insertamos al final
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        System.out.print("Tras insertar 10, 20, 30 al final: ");
        lista.imprimir(); // 10 → 20 → 30

        // Insertamos al inicio
        lista.insertarAlInicio(5);
        System.out.print("Tras insertar 5 al inicio: ");
        lista.imprimir(); // 5 → 10 → 20 → 30

        // Buscar
        System.out.println("¿Contiene 20? " + lista.buscar(20)); // true
        System.out.println("¿Contiene 99? " + lista.buscar(99)); // false

        // Contar
        System.out.println("Tamaño: " + lista.contar()); // 4

        // Obtener por índice
        System.out.println("Elemento en índice 2: " + lista.obtener(2)); // 20

        // Eliminar
        lista.eliminar(10);
        System.out.print("Tras eliminar 10: ");
        lista.imprimir(); // 5 → 20 → 30

        lista.eliminar(5); // borra la cabeza
        System.out.print("Tras eliminar la cabeza (5): ");
        lista.imprimir(); // 20 → 30

        lista.eliminar(30); // borra el último
        System.out.print("Tras eliminar el último (30): ");
        lista.imprimir(); // 20

        lista.eliminar(20); // deja la lista vacía
        System.out.print("Tras eliminar todo: ");
        lista.imprimir(); // La lista está vacía.
    }
}