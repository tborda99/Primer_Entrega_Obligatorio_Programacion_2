package MyTADS.Tests;

import MyTADS.Entities.MyHashTableImp2;
import MyTADS.Exceptions.ElementNotFoundException;
import MyTADS.Exceptions.OutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableImp2Test {

    MyHashTableImp2<Integer, String> hashTable = new MyHashTableImp2<>(10);

    @Test
    void put() {
        hashTable.put(1, "uno");
        hashTable.put(2, "dos");
        hashTable.put(3,"tres");
    }

    @Test
    void contains() {
        hashTable.put(1, "uno");
        hashTable.put(2, "dos");
        hashTable.put(3,"tres");
        assertTrue(hashTable.contains(1));
        assertTrue(hashTable.contains(2));
        assertTrue(hashTable.contains(3));
        assertFalse(hashTable.contains(0));
    }

    @Test
    void remove() throws OutOfBoundsException, ElementNotFoundException {
        hashTable.put(1, "uno");
        hashTable.remove(1);
        assertFalse(hashTable.contains(1));
        hashTable.put(2, "dos");
        hashTable.put(3,"tres");
        hashTable.remove(2);
        assertFalse(hashTable.contains(2));
        try{
            hashTable.remove(0);
        }catch(ElementNotFoundException e){

        }
    }

    @Test
    void get() throws ElementNotFoundException {
        hashTable.put(1, "uno");
        assertEquals("uno",hashTable.get(1));
        hashTable.put(1, "dos");
        assertEquals("dos",hashTable.get(1));
        hashTable.put(3,"tres");
    }
}