package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    private MyComparator myComparator;
    private Object[] result;

    public SortDecorator(SmartArray smartArray, MyComparator mcmp) {
        super(smartArray);
        this.myComparator = mcmp;
    }

    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        this.result = Arrays.stream(oldArray).sorted(myComparator).toArray();
        return result;
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }

    @Override
    public int size() {
        Object[] oldArray = smartArray.toArray();
        this.result = Arrays.stream(oldArray).sorted(myComparator).toArray();
        return result.length;
    }


}