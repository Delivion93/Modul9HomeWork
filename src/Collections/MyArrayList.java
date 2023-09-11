package Collections;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    public static final int DEFAULT_CAPACITY = 10;
    private T[] array = (T[]) new Object[DEFAULT_CAPACITY];
    private int size;

    public MyArrayList() {

    }

    public void add(T value) {
        if (size == array.length) {
            array = Arrays.copyOf(array,array.length+array.length*(1/2));
        }
        array[size] = value;
        size++;
    }

    public void remove(int index){
        for (int i = index; i <size-1 ; i++) {
            array[i]=array[i+1];
        }
        array[size-1]=null;
        size--;
    }

    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }


    public int size() {
        return size;
    }


    public T get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        int index = size();
        if(index==0){
            return "[]";
        }
        else{

            for (int i=0;i<size;i++) {
                if(array[i].equals(array[size-1])){
                    sb.append(array[i]+"]");
                }
                else{
                    sb.append(array[i]+",");
                }
            }
        }
        return sb.toString();

    }
}