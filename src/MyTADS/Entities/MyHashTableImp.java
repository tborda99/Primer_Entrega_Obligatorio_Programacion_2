package MyTADS.Entities;

import MyTADS.Interfaces.HashTable;

public class MyHashTableImp implements HashTable {

    private boolean collisions_cuadratic; //True si colisiones se resuelven cuadraticas
                                         //False si se resuelven lineal

    //CONSTRUCTOR
    public MyHashTableImp(boolean collisions_cuadratic) {
        this.collisions_cuadratic = collisions_cuadratic;
    }

    //METHODS


    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public void remove(Object clave) {

    }

    //GETTERS AND SETTERS
    public boolean isCollisions_cuadratic() {
        return collisions_cuadratic;
    }

    public void setCollisions_cuadratic(boolean collisions_cuadratic) {
        this.collisions_cuadratic = collisions_cuadratic;
    }
}
