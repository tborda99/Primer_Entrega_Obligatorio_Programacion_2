package MyTADS.Interfaces;

public interface MyHeap<T extends Comparable<T>> {

    void agregar(T elemento);

    T obtenerYEliminar();

    int obtenerTamaño();

    void mostrarArbol();

}
