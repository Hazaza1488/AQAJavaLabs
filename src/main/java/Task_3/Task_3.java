package Task_3;

import java.util.*;

public class Task_3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Prompt user to enter the size and elements of first array
        System.out.print("Enter the size of the first array: ");
        int size1 = input.nextInt();
        int[] arr1 = new int[size1];
        System.out.print("Enter the elements of the first array: ");
        for (int i = 0; i < size1; i++) {
            arr1[i] = input.nextInt();
        }

        // Prompt user to enter the size and elements of second array
        System.out.print("Enter the size of the second array: ");
        int size2 = input.nextInt();
        int[] arr2 = new int[size2];
        System.out.print("Enter the elements of the second array: ");
        for (int i = 0; i < size2; i++) {
            arr2[i] = input.nextInt();
        }

        // Find the intersection of the two arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : arr1) {
            set1.add(i);
        }
        for (int i : arr2) {
            set2.add(i);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int index = 0;
        for (int i : set1) {
            result[index++] = i;
        }

        // Create a HashMap from the result array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : result) {
            map.put(i, i*2);
        }

        // Perform HashMap operations
        map.put(10, 20);
        map.remove(5);
        System.out.println(map.containsKey(3));
        System.out.println(map.get(4));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Catch NumberFormatException and display explanation
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
        }
    }
}
