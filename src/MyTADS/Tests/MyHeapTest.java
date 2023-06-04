package MyTADS.Tests;

import MyTADS.Entities.MyHeapImp;
import MyTADS.Exceptions.EmptyTreeException;
import MyTADS.Exceptions.FullHeapException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.fail;

public class MyHeapTest {
    @Test
    public void testAgregar() {
        MyHeapImp<Integer> heap = new MyHeapImp<>(true);
        try {
            heap.agregar(5);
            heap.agregar(3);
            heap.agregar(8);
            heap.agregar(1);
        }catch(FullHeapException e){
            System.out.println("Problema con Heap Full");
            fail();
        }
        Assert.assertEquals(4, heap.obtenerTamaño());

        Comparable[] expected = {8, 3, 5, 1};
        Comparable[] actual = heap.getArray();

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i],actual[i]);
        }

    }

    @Test
    public void testAgregar_MinHeap() {
        MyHeapImp<Integer> heap = new MyHeapImp<>(false); // Initialize as a minimum heap
        try {
            heap.agregar(5);
            heap.agregar(3);
            heap.agregar(8);
            heap.agregar(1);
        } catch (FullHeapException e) {
            System.out.println("Problema con Heap Full");
            fail();
        }
        Assert.assertEquals(4, heap.obtenerTamaño());

        Comparable[] expected = {1, 3, 8, 5};
        Comparable[] actual = heap.getArray();

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i],actual[i]);
        }
    }

    @Test
    public void testObtenerYEliminar() {
        MyHeapImp<Integer> heap = new MyHeapImp<>(true);
        try {
        heap.agregar(5);
        heap.agregar(3);
        heap.agregar(8);
        heap.agregar(1);

        Assert.assertEquals(Integer.valueOf(8), heap.obtenerYEliminar());
        Assert.assertEquals(3, heap.obtenerTamaño());

        }catch(FullHeapException e){
            System.out.println("Problema con Heap Full");
            fail();
        }catch(EmptyTreeException e){
            System.out.println("Problema con Arbol Vacio");
            fail();
        }


    }

    @Test
    public void testObtenerTamaño() {
        MyHeapImp<String> heap = new MyHeapImp<>(true);
        try {
            heap.agregar("apple");
            heap.agregar("banana");
            heap.agregar("orange");

        }catch(FullHeapException e){
            System.out.println("Problema con Heap Full");
            fail();
        }
        Assert.assertEquals(3, heap.obtenerTamaño());
    }

    @Test
    public void testMostrarArbol() {
        MyHeapImp<Integer> heap = new MyHeapImp<>(true);
        try {
        heap.agregar(5);
        heap.agregar(3);
        heap.agregar(8);
        heap.agregar(1);

        }catch(FullHeapException e) {
            System.out.println("Problema con Heap Full");
            fail();
        }

        heap.mostrarArbol();
    }
}
