package com.aekc.leetcode;

/**
 * @author Twilight
 * @date 18-9-30 下午3:53
 */
public class Test {

    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int first, int last) {
        if(last > first) {
            int pivotIndex = partition(array, first, last);
            quickSort(array, first, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, last);
        }
    }

    private int partition(int[] array, int first, int last) {
        int pivot = array[first];
        int low = first + 1;
        int high = last;
        while(high > low) {
            while(low <= high && array[low] <= pivot) {
                low++;
            }
            while(low <= high && array[high] > pivot) {
                high--;
            }
            if(high > low) {
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }
        while(high > first && array[high] >= pivot) {
            high--;
        }
        if(pivot > array[high]) {
            array[first] = array[high];
            array[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

    }
}
