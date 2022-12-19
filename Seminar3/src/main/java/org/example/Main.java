package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = {6,3,12,3,1,8,4,3,7};
        System.out.println(Arrays.toString(array));
//    Реализовать алгоритм сортировки слиянием
        array = mergeSorting(array, array.length);
        System.out.println(Arrays.toString(array));
//    Пусть дан произвольный список целых чисел, удалить из него четные числа
        deleteEvenNumber(array);
    }
//    Реализовать алгоритм сортировки слиянием
    private static int[] mergeSorting(int[] arr, int n){
        if (n < 2) {
            return arr;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }
        mergeSorting(l, mid);
        mergeSorting(r, n - mid);

        merge(arr, l, r, mid, n - mid);
        return arr;
    }
    private static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
//    Пусть дан произвольный список целых чисел, удалить из него четные числа
    private static void deleteEvenNumber(int[] arr){
        List<Integer> numbers = new ArrayList <Integer>();

        for (int i = 0; i < arr.length; i++) {
            numbers.add(arr[i]);
        }

        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();){
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println(numbers);
    }
}