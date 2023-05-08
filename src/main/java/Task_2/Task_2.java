package Task_2;

public class Task_2 {
    public  static  void main(String[] arrs){
        int[] myArray = {2, 5, 7, 9, 1};

        System.out.println("Elements of the array:");
        for(int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        int sum = 0;
        for(int i = 0; i < myArray.length; i++) {
            sum += myArray[i];
        }
        System.out.println("\nSum of the elements: " + sum);



    }
}