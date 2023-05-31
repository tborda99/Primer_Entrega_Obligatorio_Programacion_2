package MyTADS.Entities;

import MyTADS.Exceptions.EmptyQueueException;
import MyTADS.Exceptions.EmptyStackException;
import MyTADS.Exceptions.OutOfBoundsException;
import MyTADS.Interfaces.MyList;
import MyTADS.Interfaces.MyQueue;
import MyTADS.Interfaces.MyStack;
import MyTADS.Entities.Node;

public class MyLinkedListImp <T> implements MyList<T>, MyQueue<T>, MyStack<T> {

    private Node<T> first;
    private Node<T> last;

    public MyLinkedListImp() {
        this.first = null;
        this.last = null;
    }

////////////////////////////////
    //METHODS DE MYLIST
////////////////////////////////
    @Override
    public void add(T value) {

        Node<T> toAdd = new Node<>(value);
        if(this.first!= null){
            Node<T> aux = this.first;
            while(aux.getNext()!= null){
                aux = aux.getNext();
            }
            aux.setNext(toAdd);
            this.last = toAdd;

        }else{
            this.first = toAdd;
            this.last = toAdd;
        }


    }

    @Override
    public T get(int position) {
        if (position == 0 && this.first != null) {
            // Busca el primer valor y no es nulo.
            return this.first.getValue();
        } else if (this.first != null) {
            // No buscan el primero y el primero no es nulo.
            Node<T> aux = this.first;
            for (int i = 0; i < position; i++) {
                if (aux.getNext() != null) {
                    aux = aux.getNext();
                } else {
                    return null;
                }
            }
            return aux.getValue();
        } else {
            // El primero es nulo, la lista es vacía.
            return null;
        }
    }


    @Override
    public boolean contains(T value) {
        if (this.first != null) {
            if (this.first.getValue().equals(value)) {
                return true;
            }

            Node<T> aux = this.first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
                if (aux.getValue().equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }


    @Override
    public void remove(T value) throws OutOfBoundsException {
        if (this.first != null && this.first.getValue().equals(value)) {
            // El primero no es vacío y el valor que queremos sacar es el primero
            this.first = this.first.getNext();
            if (this.first == null) {
                // La lista quedó vacía, actualizamos last
                this.last = null;
            }
        } else if (this.first != null) {
            // El primero no es vacío, y no es el que queremos
            Node<T> prev = this.first;
            Node<T> current = this.first.getNext();
            while (current != null) {
                if (current.getValue().equals(value)) {
                    prev.setNext(current.getNext());
                    if (current.getNext() == null) {
                        // Actualizamos last cuando se elimina el último elemento
                        this.last = prev;
                    }
                    return; // Exit the method after removing the element
                }
                prev = current;
                current = current.getNext();
            }
        } else {
            throw new OutOfBoundsException();
        }
    }


    @Override
    public int size() {
        int count = 0;
        if(this.first != null){
            count+=1;
            Node<T> aux = this.first;
            while(aux.getNext()!= null){
                count+=1;
                aux = aux.getNext();
            }
        }
        return count;
    }

////////////////////////////////
    //METHODS DE QUEUE
////////////////////////////////
    @Override
    public void enqueue(T value) {
        Node<T> agregar = new Node<T>(value);
        if(this.first == null){
            this.first = agregar;
            this.last = agregar;
        }else{
            Node<T> aux = this.first;
            while(aux.getNext()!= null){
                aux = aux.getNext();
            }
            aux.setNext(agregar);
            this.last = agregar;
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(this.first == null){
            throw new EmptyQueueException();
        }else{
            Node<T> to_return = null;
            if(this.first.getNext() != null){
                to_return = this.first;
                this.first = this.first.getNext();
            }else{
                to_return = this.first;
                this.first=null;
                }
            return to_return.getValue();
        }
    }

////////////////////////////////
    //METHODS DE STACK
///////////////////////////////
    @Override
    public void push(T value) {
        if (this.first == null){
            this.first = new Node<>(value);
        }else{
            Node <T> aux = this.first;
            this.first = new Node<>(value);
            this.first.setNext(aux);

        }

    }

    @Override
    public T pop() throws EmptyStackException {
        if(this.first == null){
            throw new EmptyStackException();
        }else if(this.first.getNext() !=null){
            //Caso en el que hay más de uno
            Node <T> to_return = this.first;
            this.first = this.first.getNext();
            return to_return.getValue();
        }else{
            //Caso en el que hay solo uno
            Node <T> to_return = this.first;
            this.first = null;
            return to_return.getValue();
        }
    }

    @Override
    public T peek() {
        if(this.first == null){
            return null;
        }else {
            return this.first.getValue();
        }
    }

/////////////////////////////////////
    //GETTERS & SETTERS
////////////////////////////////////

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }
}
