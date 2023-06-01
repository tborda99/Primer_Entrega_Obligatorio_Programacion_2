package MyTADS.Entities;

import MyTADS.Interfaces.MyBinarySearchTree;

public class MyBinarySearchTreeImp <K extends Comparable<K>, T> implements MyBinarySearchTree<K, T>{

    private NodeBST<K, T> root;


    //Constructor vacio
    public MyBinarySearchTreeImp() {
    }

    //Contrusctor con root
    public MyBinarySearchTreeImp(NodeBST<K, T> root) {
        this.root = root;
    }

    //METHODS
    @Override
    public T find(K key) {
        if(this.root!= null){
            if((this.root.getKey()).equals(key)){
                return this.root.getData();
            }else{
                return(busquedaRecursiva(this.root,key).getData());
            }
        }else{
            return null;
        }

    }

    @Override
    public void insert(K key, T data) {

        NodeBST<K,T> nuevo = new NodeBST<>(key,data);
        if(root != null){
            insertRecursivo(this.root,nuevo);
        }else{
            this.root = nuevo;
        }

    }

    @Override
    public void delete(K key, T data) {
        if(this.root!= null){
            if((this.root.getKey()).equals(key)){
                this.root = null;
            }else{

                NodeBST<K,T> eliminar = busquedaRecursiva(this.root,key);
                NodeBST<K,T> padre = busquedaRecursivaPadre(this.root,key, null);
                if (eliminar.getLeftChild()==null && eliminar.getRightChild() == null){
                    //Si el que voy a eliminar no tiene hijos, lo elimino nomas
                    if(padre.getRightChild().equals(eliminar)){
                        padre.setRightChild(null);
                    }else{
                        padre.setLeftChild(null);
                    }
                } else if (eliminar.getLeftChild()== null && eliminar.getRightChild() != null) {
                    //TODO: Caso con solo hijo derecho

                }else if (eliminar.getLeftChild() != null && eliminar.getRightChild() == null){
                    //TODO: Caso con solo hijo izquierdo

                }else{
                    //TODO: Caso con dos hijos
                }
            }
        }else{

        }

    }

    //METHODS AUXILIARES
    private void insertRecursivo(NodeBST<K, T> actual, NodeBST<K, T> nuevo) {
        if (nuevo.getKey().compareTo(actual.getKey()) < 0) {
            if (actual.getLeftChild() == null) {
                actual.setLeftChild(nuevo);
            } else {
                insertRecursivo(actual.getLeftChild(), nuevo);
            }
        } else if (nuevo.getKey().compareTo(actual.getKey()) > 0) {
            if (actual.getRightChild() == null) {
                actual.setRightChild(nuevo);
            } else {
                insertRecursivo(actual.getRightChild(), nuevo);
            }
        } else {
            // Si tengo dos keys iguales. Mantengo el que nodo que ya existia
            // Le agrego datos nuevos.
            actual.setData(nuevo.getData());
        }
    }

    private NodeBST<K,T> busquedaRecursiva(NodeBST<K, T> actual, K key) {
        if (actual == null) {
            return null;
        }

        if (key.compareTo(actual.getKey()) < 0) {
            return busquedaRecursiva(actual.getLeftChild(), key);

        } else if (key.compareTo(actual.getKey()) > 0) {
            return busquedaRecursiva(actual.getRightChild(), key);

        } else {
            //Si no es mayor ni menor es que estoy en el que busco
            //TODO: Ver si hay que devolver los datos o el nodo entero.
            return actual;

        }
    }

    private NodeBST<K,T> busquedaRecursivaPadre(NodeBST<K, T> actual, K key, NodeBST<K, T> parent) {
        if (actual == null) {
            return null;
        }

        if (key.compareTo(actual.getKey()) < 0) {
            return busquedaRecursivaPadre(actual.getLeftChild(), key, actual);

        } else if (key.compareTo(actual.getKey()) > 0) {
            return busquedaRecursivaPadre(actual.getRightChild(), key, actual);

        } else {
            // Encontre el nodo entonces devuelve el padre
            if (parent != null) {
                return parent;
            } else {
                // Si el padre es null entonces estoy en la root (Que deberia cortar antes igual)
                //Devuelvo null
                return null;
            }
        }
    }


    public MyLinkedListImp<T> inOrder(){
        return null;
    }

    public MyLinkedListImp<T> preOrder(){
        return null;
    }

    public MyLinkedListImp<T> postOrder(){
        return null;
    }

    //GETTER & SETTERS
    public NodeBST<K, T> getRoot() {
        return root;
    }

    public void setRoot(NodeBST<K, T> root) {
        this.root = root;
    }
}

