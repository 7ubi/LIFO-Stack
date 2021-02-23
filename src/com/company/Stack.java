package com.company;

public class Stack <T>{
    Element<T> data;

    public boolean isEmpty(){
        return data == null;
    }

    public void push(T value) {
        data = new Element(value, data);
    }

    public T pop(){
        T temp = null;

        if(!isEmpty()){
            temp = data.value;
            data = data.next;
        }

        return temp;
    }
}
