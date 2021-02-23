package com.company;

public class Element <T>{
    public T value;
    public Element next;

    Element(T value, Element next){
        this.value = value;
        this.next = next;
    }
}
