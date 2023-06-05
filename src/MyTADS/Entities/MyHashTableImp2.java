package MyTADS.Entities;

import MyTADS.Interfaces.MyHashTable;

public class MyHashTableImp2<K,V> implements MyHashTable<K,V> {

    private static final int DEFAULT_SIZE = 10;
    private MyLinkedListImp<NodeHash<K,V>>[] table;

    //definicion del hash
    private int hash(K key) {
        return key%table.length();
    }

    //array con linkedList
    public MyHashTableImp2(){
        table = new MyLinkedListImp<NodeHash<K, V>>[DEFAULT_SIZE];
        for (int i=0; i<table.length(); i++){
            table[i] = new MyLinkedListImp<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        MyLinkedListImp<NodeHash<K,V>>
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public V get(K key) {
        return null;
    }
}
