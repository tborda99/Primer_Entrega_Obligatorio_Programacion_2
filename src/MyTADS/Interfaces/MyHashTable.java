package MyTADS.Interfaces;

public interface MyHashTable<K,V> {
    void put(K key, V value);
    boolean contains(K key);
    void remove(K key);
    int size();
    V get(K key);
}
