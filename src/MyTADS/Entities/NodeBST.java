package MyTADS.Entities;

public class NodeBST <K extends Comparable<K>, T> {
    K key;
    T data;
    NodeBST <K, T> leftChild; NodeBST <K, T> rightChild;
}



