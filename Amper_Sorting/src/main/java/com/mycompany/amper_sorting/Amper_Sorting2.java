package com.mycompany.amper_sorting;

import java.util.Scanner;
import java.util.Arrays;

public class Amper_Sorting2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a Sorting Method");
        System.out.println(" 1. Bubble Sort");
        System.out.println(" 2. Selection Sort");
        System.out.println(" 3. Stun Attack");
        System.out.print("Choose (or type exit): \n");

        String[] names = {
            "Zachary", "Sophia", "Nathan", "Jasmine", "Daniel", "Charlotte", "Jacob", "Mia", "Sarah", "Yasmine",
            "Caleb", "Isabella", "Matthew", "Samuel", "Xander", "Brianna", "Isaac", "Madison", "Rachel", "William",
            "Benjamin", "Hannah", "Lucas", "Quentin", "Victor", "Alice", "Grace", "Liam", "Penelope", "Vanessa",
            "Alexander", "Gabriel", "Leah", "Abigail", "Emma", "Kevin", "Patrick", "Uriel", "Aaron", "Elijah",
            "Katherine", "Owen", "Tristan", "Diana", "Joshua", "Noah", "Olivia", "Steven", "Thomas", "Zoe"
        };

        String input = "1";

        switch (input) {
            case "1" -> {
                mergeSort(names, 0, names.length - 1);
                for (String name : names) {
                    System.out.print(name + ", ");
                }
            }
            case "2" -> {
                quickSort(names, 0, names.length - 1);
                System.out.println(Arrays.toString(names));
                break;
            }
            default -> {
                System.out.println("Error! That option does not exist!");
                break;
            }
        }
    }

    public static void mergeSort(String[] names, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(names, left, mid);
            mergeSort(names, mid + 1, right);

            merge(names, left, mid, right);
        }
    }

    private static void merge(String[] names, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = names[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = names[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                names[k] = leftArray[i];
                i++;
            } else {
                names[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            names[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            names[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
