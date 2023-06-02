package MyTADS.Entities;

import MyTADS.Interfaces.MyHeap;

public class MyHeapImp<T extends Comparable<T>> implements MyHeap<T> {

    //VARIABLES
    private static final int CAPACIDAD_INICIAL = 10; //size máximo inicial
    private T[] array;
    private int size; //size actual

    //CONSTRUCTOR
    public MyHeapImp() {
        array = (T[]) new Comparable[CAPACIDAD_INICIAL];
        size = 0;
    }

    //Los hijos de i estan en 2i+1 y 2i+2
    //El padre de i esta en (i-2)/2

    //METHODS
    @Override
    public void agregar(T elemento) {

    }

    @Override
    public T obtenerYEliminar() {
        return null;
    }

    @Override
    public int obtenerTamaño() {
        //Delego al getter. Tamaño ya esta definido como variable local.
        return this.getTamaño();
    }

    @Override
    public void mostrarArbol() {

    }


    //GETTERS & SETTERS
    //setters los pongo privados porque no quiero que de afuera me modifiquen esos valores.
    public T[] getArray() {
        return array;
    }

    private void setArray(T[] array) {
        this.array = array;
    }

    public int getTamaño() {
        return size;
    }

    private void setTamaño(int size) {
        this.size = size;
    }
}
