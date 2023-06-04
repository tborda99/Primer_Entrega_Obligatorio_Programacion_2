package MyTADS.Interfaces;

import MyTADS.Exceptions.EmptyTreeException;
import MyTADS.Exceptions.FullHeapException;

public interface MyHeap<T extends Comparable<T>> {

    void agregar(T elemento) throws FullHeapException;

    T obtenerYEliminar() throws EmptyTreeException;

    int obtenerTamaño();

    void mostrarArbol();

}
