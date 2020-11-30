package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction myFunction;
    private Object[] result;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.myFunction = func;
    }

    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        result = Arrays.stream(oldArray).map(myFunction::apply).toArray();
        return result.clone();
    }

    @Override
    public String operationDescription() {
        return "Map Decorator that that displays each element";
    }

    @Override
    public int size() {
        Object[] oldArray = smartArray.toArray();
        result = Arrays.stream(oldArray).map(myFunction::apply).toArray();
        return result.length;
    }


}