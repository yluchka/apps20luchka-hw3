package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private LinkedHashSet<Object> linkedHashSet;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] oldArray = smartArray.toArray();
        linkedHashSet = new LinkedHashSet<>(Arrays.asList(oldArray));
        return linkedHashSet.toArray().clone();

    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator that removes the duplicates from" +
                "the SmartArray";
    }

    @Override
    public int size() {
        Object[] oldArray = smartArray.toArray();
        linkedHashSet = new LinkedHashSet<>(Arrays.asList(oldArray));
        return linkedHashSet.size();
    }
}