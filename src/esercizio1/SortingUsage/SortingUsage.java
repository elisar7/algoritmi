package SortingUsage;

import Sorting.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SortingUsage {
    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) throw new Exception("Please enter file path.");
        else System.out.println(args[0]);

        System.out.println("Starting QUICK sort.");
        ArrayList<Record> array1 = new ArrayList();
        loadArray(args[0], array1);
        testQuick(array1);

        System.out.println("Starting INSERTION sort.");
        ArrayList<Record> array2 = new ArrayList();
        loadArray(args[0], array2);
        testInsertion(array2);

        System.out.println("Starting SELECTION sort.");
        ArrayList<Record> array3 = new ArrayList();
        loadArray(args[0], array3);
        testSelection(array3);
    }

    private static void testInsertion (ArrayList<Record> array){
        long start, finish;
        start = System.currentTimeMillis();
        Sorting.insertionSort(array, new ComparatorField1());
        finish = System.currentTimeMillis();
        System.out.println("INSERTION SORT: Completed over field 1 in " + (finish - start) + " milliseconds");
        start = System.currentTimeMillis();
        Sorting.insertionSort(array, new ComparatorField2());
        finish = System.currentTimeMillis();
        System.out.println("INSERTION SORT: Completed over field 2 in " + (finish - start) + " milliseconds");
        start = System.currentTimeMillis();
        Sorting.insertionSort(array, new ComparatorField3());
        finish = System.currentTimeMillis();
        System.out.println("INSERTION SORT: Completed over field 3 in " + (finish - start) + " milliseconds");
    }

    private static void testSelection (ArrayList<Record> array){
        long start, finish;
        start = System.currentTimeMillis();
        Sorting.selectionSort(array, new ComparatorField1());
        finish = System.currentTimeMillis();
        System.out.println("SELECTION SORT: Completed over field 1 in " + (finish - start) + " milliseconds");
        start = System.currentTimeMillis();
        Sorting.selectionSort(array, new ComparatorField2());
        finish = System.currentTimeMillis();
        System.out.println("SELECTION SORT: Completed over field 2 in " + (finish - start) + " milliseconds");
        start = System.currentTimeMillis();
        Sorting.selectionSort(array, new ComparatorField3());
        finish = System.currentTimeMillis();
        System.out.println("SELECTION SORT: Completed over field 3 in " + (finish - start) + " milliseconds");
    }

    private static void testQuick (ArrayList<Record> array){
        long start, finish;
        start = System.currentTimeMillis();
        Sorting.quickSort(array, new ComparatorField1());
        finish = System.currentTimeMillis();
        System.out.println("QUICK SORT: Completed over field 1 in " + (finish - start) + " milliseconds");
        start = System.currentTimeMillis();
        Sorting.quickSort(array, new ComparatorField2());
        finish = System.currentTimeMillis();
        System.out.println("QUICK SORT: Completed over field 2 in " + (finish - start) + " milliseconds");
        start = System.currentTimeMillis();
        Sorting.quickSort(array, new ComparatorField3());
        finish = System.currentTimeMillis();
        System.out.println("QUICK SORT: Completed over field 3 in " + (finish - start) + " milliseconds");
    }

    private static void loadArray(String filepath, ArrayList<Record> array) throws IOException{
        System.out.println("LOADING DATA FROM FILE...");
        Path inputFilePath = Paths.get(filepath);
        try(BufferedReader fileInputReader =
                    Files.newBufferedReader(inputFilePath, ENCODING)) {
            String line = null;
            while ((line = fileInputReader.readLine()) != null) {
                String[] lineElements = line.split(",");
                Record record1 = new Record(Integer.parseInt(lineElements[0]), lineElements[1],
                        Integer.parseInt(lineElements[2]), Float.parseFloat(lineElements[3]));
                array.add(record1);
            }
        }
    }

    private static void printArray(ArrayList<Record> array){
        System.out.println("ARRAY OF RECORDS");
        for(int i=0; i<array.size(); i++){
            System.out.println(array.get(i));
        }
    }

}