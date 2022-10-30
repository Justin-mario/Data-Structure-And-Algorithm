package com.company;

import java.util.Arrays;

public class Main {

    public static void swap (int[] array, int i, int j){
        if (i == j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
        #bubble sort
        #degrades quickly
        #one of the least efficient sort algorithm
        #Goes through the entire array, creates a partition of
         sorted and unsorted arrays. The sorted arrays are kept
        on the right and the loop does not traverse through it.
        it has a quadratic time complexity 0(n*2)
        stable algorithm.
        in-place algorithm
    */

    public static int[] bubbleSort(int[] intArray){
        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
        lastUnsortedIndex--){
            for (int i = 0; i < lastUnsortedIndex; i++){
                if (intArray[i] > intArray[i + 1]){
                    swap ( intArray, i, i + 1 );
                }
            }
        }
        System.out.println ((System.currentTimeMillis ()/1000)%60);
        return intArray;
    }


    /*
        Selection sort
        traverses the array from left to right, picks the largest element
        and keeps it at it's correct index depending on if it is sorting
        in ascending or descending order
        it has a quadratic time complexity 0(n*2)
        usually performs better than bubble sort.
        unstable algorithm.
        in-place algorithm
     */


    public static int[] selectionSort(int[] intArray){
        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
            lastUnsortedIndex--){
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++){
                if (intArray[i] > intArray[largest]){
                    largest = i;
                }
                swap ( intArray, largest, lastUnsortedIndex );
            }
        }
        System.out.println ((System.currentTimeMillis ()/1000)%60);
        return intArray;
    }

    /*
        insertion sort
        grows the sorted partition from left to right
        in-place algorithm
        o(n*2) quadratic time complexity.
        stable algorithm
     */

    public static int[] insertionSort(int[] intArray){
        for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length;
            firstUnsortedIndex++){
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for ( i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--){
                intArray[i] = intArray[i -1];

            }
            intArray[i] = newElement;
        }
        System.out.println ((System.currentTimeMillis ()/1000)%60);
        return intArray;
    }

    /*
        shell sort is an improvement on insertion sort
        variation of insertion sort
        starts out with a larger gap value, doesn't sort it's neighbour
        directly.
        when the gap value is 1, insertion sort will be done.
        there are several ways to calculate gap value
        one way is Knuth sequence (3*k -1)/2
        difficult to nail down the time complexity cos it depends on the
        gap.
        worst case is quadratic 0(n*2)
        but can perform much better
        doesn't require much shifting as insertion sort so performs better
        unstable algorithm
     */

    public static void main(String[] args) {

        int[] intArray = {20, -15, 7, 35, 1, -22, 55, 0, 67, 5};

        //System.out.println ( Arrays.toString ( bubbleSort ( intArray ) ) );
        //System.out.println (Arrays.toString ( selectionSort ( intArray ) ));
       // System.out.println (Arrays.toString ( insertionSort ( intArray ) ));
    }


}
