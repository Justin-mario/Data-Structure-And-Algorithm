package com.company;

import java.util.Arrays;

public class Main {

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
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

    public static int[] bubbleSort(int[] intArray) {
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap ( intArray, i, i + 1 );
                }
            }
        }
        System.out.println ( (System.currentTimeMillis () / 1000) % 60 );
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


    public static int[] selectionSort(int[] intArray) {
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
                swap ( intArray, largest, lastUnsortedIndex );
            }
        }
        System.out.println ( (System.currentTimeMillis () / 1000) % 60 );
        return intArray;
    }

    /*
        insertion sort
        grows the sorted partition from left to right
        in-place algorithm
        o(n*2) quadratic time complexity.
        stable algorithm
     */

    public static int[] insertionSort(int[] intArray) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length;
             firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];

            }
            intArray[i] = newElement;
        }
        System.out.println ( (System.currentTimeMillis () / 1000) % 60 );
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

    public static int[] shellSort(int[] intArray) {
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;

            }

        }
        System.out.println ( (System.currentTimeMillis () / 1000) % 60 );
        return intArray;

    }

    // iterative method
    public static int iterativeFactorial(int num){
        if (num == 0){
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // implement iterativeFactorial using recursion
    public static int recursiveFactorial(int num){
        if (num == 0){
            return 1;
        }

        return num * (iterativeFactorial ( num - 1 ));
    }

    /*
        Merge sort
        uses divide and conquer
        divides the array into 2
        split the lift array into 2 arrays
        uses temp array to do the sort
        not an in-place algorithm
        time complexity of 0(nlogn)-base 2
        stable algorithm
     */
        public static void mergeSort(int[] input, int start, int end){
            if (end -start < 2){
                return;
            }
            int mid = (start + end) / 2;
            mergeSort ( input, start, mid );
            mergeSort ( input, mid, end );
            merge(input, start, mid, end);
        }

        public static void merge(int[] input, int start, int mid, int end){
            if (input[mid - 1] <= input[mid]){
                return;
            }
            int i = start;
            int j = mid;
            int tempIndex = 0;

            int[] temp = new int[end - start];
            while(i < mid && j < end) {
                temp[tempIndex++] = input[i] <= input[j]? input[i++] : input[j++];
            }

            System.arraycopy ( input, i, input, start + tempIndex, mid - i  );
            System.arraycopy ( temp, 0, input, start, tempIndex );
        }

        /*
            Quick sort
            in-place algorithm
            time complexity of 0(nlogn)
            we are repeatedly partitioning the array into two halves
            unstable algorithm

         */

    public static void main(String[] args) {

        System.out.println (CheckPalindrome.checkForPalindrome ( "abccba" ));
        System.out.println (CheckPalindrome.checkForPalindrome ( "Was it a car or a cat I saw?" ));
        System.out.println (CheckPalindrome.checkForPalindrome ( "I did, did I?" ));
        System.out.println (CheckPalindrome.checkForPalindrome ( "hello" ));
        System.out.println (CheckPalindrome.checkForPalindrome ( "Don't nod" ));

        int[] intArray = {20, -15, 7, 35, 1, -22, 55, 0, 67, 5};
        //System.out.println ( iterativeFactorial ( 3 ));
        //System.out.println ( recursiveFactorial ( 3 ));
        //System.out.println ( Arrays.toString ( bubbleSort ( intArray ) ) );
        //System.out.println (Arrays.toString ( selectionSort ( intArray ) ));
        // System.out.println (Arrays.toString ( insertionSort ( intArray ) ));
        //System.out.println (Arrays.toString ( shellSort ( intArray ) ));
       mergeSort ( intArray, 0, intArray.length );

//       for (int i = 0; i < intArray.length; i++){
          // System.out.println ( Arrays.toString ( intArray ) );
//       }
    }


}
