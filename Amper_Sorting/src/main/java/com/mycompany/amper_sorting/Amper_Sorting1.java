package com.mycompany.amper_sorting;

import java.util.Scanner;
import java.util.Arrays;

public class Amper_Sorting1 {

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
                bubbleSort(names);
                for (String name : names) {
                    System.out.print(name + ", ");
                    break;
                }
            }
            case "2" -> {
                selectionSort(names);
                System.out.println(Arrays.toString(names));
                break;
            }
            case "3" -> {
                insertionSort(names);
                System.out.println(Arrays.toString(names));
                break;
            }
            case "exit" -> {
                System.out.println("You exited the program!");
                break;
            }
            default -> {
                System.out.println("Error! That option does not exist!");
            }
        }
    }

    public static void bubbleSort(String[] names) {
        int n = names.length;
        boolean swapped;
        System.out.println("\nBUBBLE SORT: ");
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (names[j].compareTo(names[j + 1]) > 0) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    public static void selectionSort(String[] names) {
        int n = names.length;
        System.out.println("\nSELECTION SORT: ");
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (names[j].compareTo(names[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = names[i];
                names[i] = names[minIndex];
                names[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(String[] names) {
        int n = names.length;
        System.out.println("\nINSERTION SORT: ");
        for (int i = 1; i < n; ++i) {
            String key = names[i];
            int j = i - 1;

            while (j >= 0 && names[j].compareTo(key) > 0) {
                names[j + 1] = names[j];
                j = j - 1;
            }
            names[j + 1] = key;
        }
    }
}
