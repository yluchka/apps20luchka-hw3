package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] arr;

    public BaseArray(Object[] a) {
        this.arr = a;
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "Base array";
    }

    @Override
    public int size() {
        return arr.length;
    }
}