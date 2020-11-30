package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;
    private Object[] result;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.predicate = pr;
    }

    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        result = Arrays.stream(oldArray).filter(predicate::test).toArray();
        return result.clone();
    }

    @Override
    public String operationDescription() {
        return "Filtering Decorator";
    }

    @Override
    public int size() {
        Object[] oldArray = smartArray.toArray();
        result = Arrays.stream(oldArray).filter(predicate::test).toArray();
        return result.length;
    }
}