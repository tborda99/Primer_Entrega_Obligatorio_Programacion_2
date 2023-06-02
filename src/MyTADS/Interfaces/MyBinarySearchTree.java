package MyTADS.Interfaces;

import MyTADS.Entities.NodeBST;
import MyTADS.Exceptions.EmptyTreeException;

public interface MyBinarySearchTree <K extends Comparable<K>, T> {

    T find(K key);

    void insert (K key,T data);

    void delete (K key, T data) throws EmptyTreeException;


    NodeBST<K, T> getRoot();

    void setRoot(NodeBST<K, T> root);




}

