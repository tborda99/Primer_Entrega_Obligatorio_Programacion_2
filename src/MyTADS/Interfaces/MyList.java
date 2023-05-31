package MyTADS.Interfaces;

import MyTADS.Exceptions.OutOfBoundsException;

public interface MyList<T> {

    void add(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value) throws OutOfBoundsException;

    int size();

}
