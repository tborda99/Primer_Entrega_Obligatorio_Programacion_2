package MyTADS.Entities;

import MyTADS.Exceptions.ElementNotFoundException;
import MyTADS.Exceptions.OutOfBoundsException;
import MyTADS.Interfaces.MyHashTable;

public class MyHashTableImp2<K,V> implements MyHashTable<K,V> {

    private int size;
    private MyHashLinkedListImp<K,V>[] table;

    //definicion del hash
    private int hash(K key) {
        return (int)key % size;
    }

    //array con linkedList
    public MyHashTableImp2(int size){
        this.size = size;
        table = new MyHashLinkedListImp[size];
        for (int i=0; i<size; i++){
            table[i] = new MyHashLinkedListImp<>();
        }
    }

    //metodos
    @Override
    public void put(K key, V value) {
        int index = hash(key);
        MyHashLinkedListImp<K,V> bucket = table[index];
        if (bucket.getKey(key) != null) {
            bucket.getKey(key).setValue(value);
            return;
            //si ya existe modifica el valor
        }
        bucket.add(new NodeHash<>(key,value));
    }

    @Override
    public boolean contains(K key) {
        int index = hash(key);
        MyHashLinkedListImp<K,V> bucket = table[index];
        if (bucket.getKey(key) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void remove(K key) throws ElementNotFoundException, OutOfBoundsException {
        int index = hash(key);
        MyHashLinkedListImp<K,V> bucket = table[index];
        if (bucket.getKey(key) != null) {
            bucket.remove(bucket.getKey(key));
            return;
        }
        throw new ElementNotFoundException();
    }

    @Override
    public V get(K key) throws ElementNotFoundException {
        int index = hash(key);
        MyHashLinkedListImp<K,V> bucket = table[index];
        if (bucket.getKey(key) != null) {
            return bucket.getKey(key).getValue();
        }
        throw new ElementNotFoundException();
    }
}
