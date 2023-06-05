package MyTADS.Interfaces;

import MyTADS.Exceptions.ElementNotFoundException;

public interface MyHashTable<K,V> {
    void put(K key, V value);
    boolean contains(K key);
    void remove(K key) throws ElementNotFoundException;
    V get(K key) throws ElementNotFoundException;
}
