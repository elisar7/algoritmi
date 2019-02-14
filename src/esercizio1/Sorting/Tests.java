package Sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private Integer i1, i2, i3, i4, i5;
    private ArrayList <Integer> array;

    @Before
    public void createArray(){
        array = new ArrayList<Integer>();
        for (int i = 14; i >= 0; i--)
            array.add(i);
    }

    @Test
    public void testInsertionSort(){
        Integer[] expectedArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            expectedArray[i] = i;
        }
        Sorting.selectionSort(array, new IntegerComparator());
        Integer[] actualArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            actualArray[i] = array.get(i);
        }
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testSelectionSort(){
        Integer[] expectedArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            expectedArray[i] = i;
        }
        Sorting.selectionSort(array, new IntegerComparator());
        Integer[] actualArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            actualArray[i] = array.get(i);
        }
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testQuickSort(){
        Integer[] expectedArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            expectedArray[i] = i;
        }
        Sorting.quickSort(array, new IntegerComparator());
        Integer[] actualArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            actualArray[i] = array.get(i);
        }
        assertArrayEquals(expectedArray, actualArray);
    }

    class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }

}
