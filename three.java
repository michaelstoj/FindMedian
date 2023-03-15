package edu.princeton.cs.algorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class three {

    // returns true if the sorted array a[] contains any duplicated integers
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
    }

    /**
     * Prints to standard output the (i, j, k) with i < j < k such that a[i] + a[j] + a[k] == 0.
     * @param a the array of integers
     * @throws IllegalArgumentException if the array contains duplicate integers
     */
    public static void printAll(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) System.out.println(a[i] + " " + a[j] + " " + a[k]);
            }
        }
    }

    /**
     * Returns the number of triples (i, j, k) with i < j < k such that a[i] + a[j] + a[k] == 0.
     * @param a the array of integers
     * @return the number of triples (i, j, k) with i < j < k such that a[i] + a[j] + a[k] == 0
     */

    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) cnt++;
            }
        }
        return cnt;
    }

    /**
     * Reads in a sequence of distinct integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     */
    public static void main(String[] args)  {

        int c = 2000;

        int i = 0;
        int[] a = new int[c];

        try {
            File myFile = new File("2Kints.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNext()) {
                if(myReader.hasNextInt()){
                    a[i] = myReader.nextInt();
                    i++;
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        long startTime = System.nanoTime();
        int cnt = count(a);
        System.out.println(cnt);
        long endTime = System.nanoTime();

        System.out.println ("Array size = " + i +
                "\tSearch time = " +
                (endTime-startTime)/1000000000.0 + " seconds");

//        System.out.println(timeTrial(1000));

    }

//    public static double timeTrial(int n) {
//        int MAXIMUM_INTEGER = 1000000;
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
//        }
//        Stopwatch timer = new Stopwatch();
//
//        int cnt = ThreeSum.count(a);
//        double time = timer.elapsedTime();
////        StdOut.println(cnt + “ triples “ + time);
//        return timer.elapsedTime();
//    }
}


