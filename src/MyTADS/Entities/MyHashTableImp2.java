package MyTADS.Entities;

import MyTADS.Exceptions.ElementNotFoundException;
import MyTADS.Interfaces.MyHashTable;

public class MyHashTableImp2<K,V> implements MyHashTable<K,V> {

    private int size;
    private MyLinkedListImp<NodeHash<K,V>>[] table;

    //definicion del hash
    private int hash(K key) {
        return key%table.length();
    }

    //array con linkedList
    public MyHashTableImp2(int size){
        this.size = size;
        table = new MyLinkedListImp<NodeHash<K, V>>[size];
        for (int i=0; i<table.length(); i++){
            table[i] = new MyLinkedListImp<>();
        }
    }

    //metodos
    @Override
    public void put(K key, V value) {
        int index = hash(key);
        MyLinkedListImp<NodeHash<K,V>> bucket = table[index]; //especifico el indice de hash que voy a usar
        for (NodeHash<K,V> node: bucket) { //recorre todos los nodos del bucket
            if (node.getKey() == key) { //deberia usar comparable aca??
                node.setValue(value); //si encuentro uno con el mismo key le actualizo el valor
                return;
            }
        }
        bucket.add(new NodeHash<>(key,value));
    }

    @Override
    public boolean contains(K key) {
        int index = hash(key);
        MyLinkedListImp<NodeHash<K,V>> bucket = table[index];
        for (NodeHash<K,V> node: bucket){
            if (node.getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(K key) throws ElementNotFoundException {
        int index = hash(key);
        MyLinkedListImp<NodeHash<K,V>> bucket = table[index];
        for (NodeHash<K,V> node: bucket){
            if (node.getKey().equals(key)){
                node = null;
                return;
            }
        }
        throw new ElementNotFoundException();
    }

    @Override
    public V get(K key) throws ElementNotFoundException {
        int index = hash(key);
        MyLinkedListImp<NodeHash<K,V>> bucket = table[index];
        for (NodeHash<K,V> node: bucket){
            if (node.getKey().equals(key)){
                return node.getValue();
            }
        }
        throw new ElementNotFoundException();
    }
}
