import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User enter info 1 array
        System.out.print("Size of the 1 array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        System.out.print("Elements of the 1 array: ");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        // User enter info 2 array
        System.out.print("Enter the size of the 2 array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        System.out.print("Enter the elements of the 2 array: ");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Intersection
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }
        for (int num : array2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] intersection = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            intersection[i++] = num;
        }

        // Print intersection
        System.out.println("Intersection: " + Arrays.toString(intersection));

        // Convert to linkedlist
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : intersection) {
            list.add(num);
        }


        list.addFirst(0);
        System.out.println("List after adding an element to the beginning: " + list);


        list.addLast(10);
        System.out.println("List after adding an element to the end: " + list);


        list.removeFirst();
        System.out.println("List after removing the first element: " + list);


        list.removeLast();
        System.out.println("List after removing the last element: " + list);


        ListIterator<Integer> iterator = list.listIterator(list.size());
        System.out.print("List in reverse order: ");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }

        // Catch ArithmeticException
        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("\nArithmeticException caught: " + e.getMessage());
            System.out.println("You cannot divide by zero.");
        }
    }
}