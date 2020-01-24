package sort;

import java.util.Arrays;

    public class QuickSort {
        
    public static void main(String[] args)
    {
        int array[] = new int[100000];
        generateArray(array);
        QuickSort sorter = new QuickSort();
        sorter.quickSort(array, 0, array.length - 1);
        System.out.println(java.util.Arrays.toString(array));
        
        long begin;
        long end;
        long cal;
        
        begin = System.currentTimeMillis();
        Arrays.sort(array);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR ArraysSort : " + cal);
        
        begin = System.currentTimeMillis();
        sorter.quickSort(array, 0, array.length - 1);
        end = System.currentTimeMillis();
        cal = end - begin;
        System.out.println("TIME FOR QuicSort : " + cal);
    
    }

    private void quickSort(int[] array, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int pivotIndex = partition(array, startIndex, endIndex);
            quickSort(array, startIndex, pivotIndex);
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }

    private int partition(int[] array, int startIndex, int endIndex)
    {
        int pivotIndex = (startIndex + endIndex) / 2;
        int pivotValue = array[pivotIndex];
        startIndex--;
        endIndex++;

        while (true)
        {
            do startIndex++; while (array[startIndex] < pivotValue);
            do endIndex--; while (array[endIndex] > pivotValue);
            if (startIndex >= endIndex) return endIndex;
            
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
    public static void generateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }
    }
}

//credit : https://big-o.io/algorithms/comparison/quicksort/
//members
//61130500021
//61130500023
//61130500027