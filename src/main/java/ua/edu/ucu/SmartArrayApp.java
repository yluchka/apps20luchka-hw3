package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate myPredicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator myComparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction myFunction = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, myPredicate); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, myComparator); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, myFunction); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate myPredicate = new MyPredicate() {
            @Override
            public boolean test(Object student) {
                return ((Student) student).getYear() == 2 && ((Student) student).getGPA() >= 4;
            }
        };

        MyFunction myFunction = new MyFunction() {
            @Override
            public Object apply(Object student) {
                return ((Student) student).getSurname() + " " + ((Student) student).getName();
            }
        };

        MyComparator myComparator = new MyComparator() {
            @Override
            public int compare(Object student1, Object student2) {
                return ((Student) student1).getSurname().compareTo(((Student) student2).getSurname());
            }
        };

        SmartArray studentArr = new BaseArray(students);

        studentArr = new DistinctDecorator(
                new MapDecorator(
                        new SortDecorator(
                                new FilterDecorator(studentArr, myPredicate),
                                myComparator),
                        myFunction));
        return Arrays.copyOf(studentArr.toArray(), studentArr.toArray().length, String[].class);
    }
}