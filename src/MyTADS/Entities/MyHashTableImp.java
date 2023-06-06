package MyTADS.Entities;

import MyTADS.Exceptions.ElementNotFoundException;
import MyTADS.Interfaces.MyHashTable;

public class MyHashTableImp<K,V> implements MyHashTable<K,V> {

    private int size;
    private MyHashLinkedListImp<K,V>[] table;

    //definicion del hash
    private int hash(K key) {
        return (int)key%size;
    }

    //array con linkedList
    public MyHashTableImp(int size){
//        this.size = size;
//        table = (MyHashLinkedListImp<K,V>[]) new MyHashLinkedListImp<K, V>[size];
//        for (int i=0; i<table.length(); i++){
//            table[i] = new MyLinkedListImp<>();
//        }
    }

    //metodos
    @Override
    public void put(K key, V value) {
//        int index = hash(key);
//        MyLinkedListImp<NodeHash<K,V>> bucket = table[index]; //especifico el indice de hash que voy a usar
//        for (NodeHash<K,V> node: bucket) { //recorre todos los nodos del bucket
//            if (node.getKey() == key) { //deberia usar comparable aca??
//                node.setValue(value); //si encuentro uno con el mismo key le actualizo el valor
//                return;
//            }
//        }
//        bucket.add(new NodeHash<>(key,value));
    }

    @Override
    public boolean contains(K key) {
//        int index = hash(key);
//        MyLinkedListImp<NodeHash<K,V>> bucket = table[index];
//        for (NodeHash<K,V> node: bucket){
//            if (node.getKey().equals(key)){
//                return true;
//            }
//        }
        return false;
    }

    @Override
    public void remove(K key) throws ElementNotFoundException {
//        int index = hash(key);
//        MyLinkedListImp<NodeHash<K,V>> bucket = table[index];
//        for (NodeHash<K,V> node: bucket){
//            if (node.getKey().equals(key)){
//                node = null;
//                return;
//            }
//        }
//        throw new ElementNotFoundException();
    }

    @Override
    public V get(K key) throws ElementNotFoundException {
//        int index = hash(key);
//        MyLinkedListImp<NodeHash<K,V>> bucket = table[index];
//        for (NodeHash<K,V> node: bucket){
//            if (node.getKey().equals(key)){
//                return node.getValue();
//            }
//        }
//        throw new ElementNotFoundException();
        return null;
    }
}
