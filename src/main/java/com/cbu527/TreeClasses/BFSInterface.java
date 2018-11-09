package com.cbu527.TreeClasses;

public interface BFSInterface<T> {
    public boolean add(T item);
    public boolean remove (T item);
    public boolean contains (T item);
    public int numItems ();
    public int height();
    public void print();
}
