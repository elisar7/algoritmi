package MaxHeap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class Tests {

    private ArrayList<Integer> array1;
    private ArrayList<Integer> array2;

    @Before
    public void createArray(){
        array1 = new ArrayList<Integer>();
        int[] a1 = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        for (int i = 0; i < a1.length; i++)
            array1.add(a1[i]);
        array2 = new ArrayList<Integer>();
        int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < a2.length; i++)
            array2.add(a2[i]);
    }

    @Test
    public void testIsHeapRec(){
        Boolean expected1 = true;
        Boolean expected2 = false;
        Boolean actual1 = MaxHeap.isHeapRec(array1, new IntegerComparator());
        Boolean actual2 = MaxHeap.isHeapRec(array2, new IntegerComparator());
        Assert.assertTrue(expected1 == actual1 && expected2 == actual2);
    }

    @Test
    public void testIsHeapIt(){
        Boolean expected1 = true;
        Boolean expected2 = false;
        Boolean actual1 = MaxHeap.isHeapIt(array1, new IntegerComparator());
        Boolean actual2 = MaxHeap.isHeapIt(array2, new IntegerComparator());
        Assert.assertTrue(expected1 == actual1 && expected2 == actual2);
    }

    private class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    }

}
