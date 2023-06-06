package MyTADS.Interfaces;

import MyTADS.Exceptions.ElementNotFoundException;
import MyTADS.Exceptions.OutOfBoundsException;

public interface MyHashTable<K,V> {
    void put(K key, V value);
    boolean contains(K key);
    void remove(K key) throws ElementNotFoundException, OutOfBoundsException;
    V get(K key) throws ElementNotFoundException;
}
