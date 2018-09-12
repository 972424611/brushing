package com.aekc.leetcode;

import java.util.Arrays;

/**
 * @author Twilight
 * @date 18-9-12 下午5:37
 */
public class MedianOfTwoSortedArrays {

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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);
        array = quickSort(array);
        if(array.length % 2 != 0) {
            return (double) array[(array.length - 1) / 2];
        } else {
            return ((double) array[(array.length + 1) / 2 - 1] + (double) array[(array.length + 1) / 2]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double s = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(s);

    }
}
