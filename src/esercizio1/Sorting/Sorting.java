package Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;


public class Sorting<T> {

    private int i;

    public static <T> void insertionSort(ArrayList<T> array, Comparator cmp) {
        int i, j;
        for (i = 1; i < array.size(); i++) {
            j = i;
            while (j > 0 && (cmp.compare(array.get(j - 1), array.get(j)) > 0)) {
                Sorting.swap(array, j - 1, j);
                j--;
            }
        }
    }

    /*
     * Scambia gli elementi in posizione i e j nell'array.
     */
    private static <T> void swap(ArrayList<T> array, int i, int j) {
        T tmp;
        tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    public static <T> void selectionSort(ArrayList<T> array, Comparator cmp) {
        int i, j, k;
        for (i = 0; i < array.size(); i++) {
            k = i;
            for (j = i + 1; j < array.size(); j++) {
                if (cmp.compare(array.get(k), array.get(j)) > 0)
                    k = j;
            }
            swap(array, i, k);
        }
    }

    public static <T> void quickSort(ArrayList<T> array, Comparator cmp) {
        if (array !=null && array.size()!=0){
            quickSort(array, cmp, 0, array.size() - 1);
        }

    }

    private static <T> void quickSort(ArrayList<T> array, Comparator cmp, int left, int right) {
        int i = left, j = right;
        int p = ThreadLocalRandom.current().nextInt(i, j);
        T pivot = array.get(p);
        while (i <= j) {
            while (cmp.compare(array.get(i), pivot) < 0) {
                i++;
            }
            while (cmp.compare(array.get(j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j)
            quickSort(array, cmp, left, j);
        if (i < right)
            quickSort(array, cmp, i, right);
    }



}


