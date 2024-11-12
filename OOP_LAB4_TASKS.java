import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UzairTasks {
    String studentName = "Uzair";
    String rollNumber = "2023F-BSE-085";

    // Lab Task 1
    public void swapArrays(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            int temp = array1[i];
            array1[i] = array2[i];
            array2[i] = temp;
        }
        System.out.println("After swapping:");
        System.out.print("Array1: ");
        for (int n : array1) System.out.print(n + " ");
        System.out.print("\nArray2: ");
        for (int n : array2) System.out.print(n + " ");
    }

    // Lab Task 2:
    public int[] mergeArrays(int[] existingArray, int[] newArray) {
        int[] mergedArray = new int[existingArray.length + newArray.length];
        System.arraycopy(existingArray, 0, mergedArray, 0, existingArray.length);
        System.arraycopy(newArray, 0, mergedArray, existingArray.length, newArray.length);
        return mergedArray;
    }

    // Lab Task 3: Check Palindrome
    public void checkPalindromes(String[] stringArray) {
        System.out.println("Palindrome Check:");
        for (String str : stringArray) {
            String reversed = new StringBuilder(str).reverse().toString();
            if (str.equals(reversed)) System.out.println(str + " is a palindrome");
            else System.out.println(str + " is not a palindrome");
        }
    }

    // Lab Task 4:
    public void countEvenOdd(int[] numbers) {
        int evenCount = 0, oddCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) evenCount++;
            else oddCount++;
        }
        System.out.println("Even count: " + evenCount);
        System.out.println("Odd count: " + oddCount);
    }

    // Lab Task 5:
    public int[] mergeAndRemoveDuplicates(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : mergedArray) uniqueSet.add(num);

        int[] resultArray = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) resultArray[index++] = num;

        return resultArray;
    }

    // Home Task 1:
    public void calculateSumAndMean(double[] realNumbers) {
        double sum = 0;
        for (double num : realNumbers) sum += num;
        double mean = sum / realNumbers.length;
        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + mean);
        System.out.println("Memory used by array: " + (realNumbers.length * Double.BYTES) + " bytes");
    }

    // Home Task 2:
    public void splitArrayByKey(int[] mainArray, int key) {
        int index = -1;
        for (int i = 0; i < mainArray.length; i++) {
            if (mainArray[i] == key) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Key not found.");
            return;
        }
        int[] firstHalf = new int[index];
        int[] secondHalf = new int[mainArray.length - index];
        System.arraycopy(mainArray, 0, firstHalf, 0, index);
        System.arraycopy(mainArray, index, secondHalf, 0, mainArray.length - index);
        System.out.print("First half: ");
        for (int n : firstHalf) System.out.print(n + " ");
        System.out.print("\nSecond half: ");
        for (int n : secondHalf) System.out.print(n + " ");
    }

    // Home Task 3:
    public List<List<Integer>> findCombinations(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] > remain) break;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // Home Task 4:
    public int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    // Home Task 5:
    public void zigzagSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        System.out.print("Zigzag pattern: ");
        for (int n : arr) System.out.print(n + " ");
    }

    public static void main(String[] args) {
        UzairTasks tasks = new UzairTasks();
        
        tasks.swapArrays(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8});
        tasks.calculateSumAndMean(new double[]{5.5, 2.3, 8.1, 4.4, 3.3, 7.2, 6.6});
        tasks.splitArrayByKey(new int[]{1, 3, 5, 7, 9, 11, 13}, 7);
        System.out.println(tasks.findCombinations(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println("Missing number is: " + tasks.findMissingNumber(new int[]{0, 1, 2, 4, 5, 6}));
        tasks.zigzagSort(new int[]{4, 3, 7, 8, 6, 2, 1});
    }
}
