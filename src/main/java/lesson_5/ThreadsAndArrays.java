package lesson_5;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadsAndArrays {

    public static void main(String[] args) throws InterruptedException {
        float[] array = new float[29999999];
        float[] newArrayOne, newArrayTwo, newArrayThree, newArrayFour;
        Arrays.fill(array, 1.0f);
        long startTime = System.currentTimeMillis();
        newArrayOne = calculateWithOneThread(array);
        System.out.println("Time for work with one thread: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        newArrayTwo = calculateWithTwoThread(array);
        System.out.println("Time for work with two threads: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        newArrayThree = calculateWithTwoThreadOneArray(array);
        System.out.println("Time for work with two threads, no merge: " + (System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        newArrayFour = calculateWithPoolThreads(array, Runtime.getRuntime().availableProcessors());
        System.out.println("Time for work with pool threads: " + (System.currentTimeMillis() - startTime));
        System.out.println("Equals of all arrays: " + Arrays.equals(newArrayOne, newArrayTwo) + " " + Arrays.equals(newArrayOne, newArrayThree) + " " + Arrays.equals(newArrayOne, newArrayFour));
    }

    public static float[] calculateWithOneThread(float[] array) {
        float[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arrayCopy;
    }

    public static float[] calculateWithTwoThread(float[] array) throws InterruptedException {
        int halfOne;
        int halfTwo;
        if (array.length % 2 != 0) {
            halfOne = array.length / 2;
            halfTwo = halfOne + 1;
        } else {
            halfOne = array.length / 2;
            halfTwo = halfOne;
        }
        float[] arrayHalfOne = new float[halfOne];
        float[] arrayHalfTwo = new float[halfTwo];
        System.arraycopy(array, 0, arrayHalfOne, 0, halfOne);
        System.arraycopy(array, halfOne, arrayHalfTwo, 0, halfTwo);
        Thread one = new Thread(() -> {
            for (int i = 0; i < arrayHalfOne.length; i++) {
                arrayHalfOne[i] = (float) (arrayHalfOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread two = new Thread(() -> {
            for (int i = arrayHalfOne.length; i < array.length; i++) {
                arrayHalfTwo[i - arrayHalfOne.length] = (float) (arrayHalfTwo[i - arrayHalfOne.length] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        one.start();
        two.start();
        one.join();
        two.join();
        float[] mergeArray = new float[array.length];
        System.arraycopy(arrayHalfOne, 0, mergeArray, 0, halfOne);
        System.arraycopy(arrayHalfTwo, 0, mergeArray, halfOne, halfTwo);
        return mergeArray;
    }

    public static float[] calculateWithTwoThreadOneArray(float[] array) throws InterruptedException {
        int halfOne = array.length / 2;
        float[] resultArray = new float[array.length];
        Thread one = new Thread(() -> {
            for (int i = 0; i < halfOne; i++) {
                resultArray[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread two = new Thread(() -> {
            for (int i = halfOne; i < array.length; i++) {
                resultArray[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        one.start();
        two.start();
        one.join();
        two.join();
        return resultArray;
    }

    public static float[] calculateWithPoolThreads(float[] array, int valueOfThreads) throws InterruptedException {
        float[] resultArray = new float[array.length];
        int count = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(valueOfThreads);
        int part = array.length / valueOfThreads;
        int lastPart = array.length % valueOfThreads;
        int tempPart = part;
        for (int i = 0; i < valueOfThreads; i++) {
            if (i == 0) tempPart += lastPart;
            int finalCount = count;
            int finalPart = tempPart;
            executorService.submit(() -> {
                for (int j = finalCount; j < finalPart; j++) {
                    resultArray[j] = (float) (array[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                }
            });
            count += part;
            tempPart += part;
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        return resultArray;
    }

}
//Консоль
//Time for work with one thread: 4080
//Time for work with two threads: 2186
//Time for work with two threads, no merge: 2098
//Time for work with pool threads: 1119
//Equals of all arrays: true true true
