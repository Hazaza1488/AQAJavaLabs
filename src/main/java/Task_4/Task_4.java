package Task_4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Task_4 {
    public static void main(String[] args) throws InterruptedException {

        // Create a thread that waits for a signal from another thread using wait and notify
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1 is waiting...");
                    lock.wait();
                    System.out.println("Thread 1 is notified.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread.sleep(1000); // Wait for 1 second

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 is notifying...");
                lock.notify();
            }
        });
        thread2.start();

        // Create a custom class, modify its field value using reflection, and print out the object before and after changes
        CustomClass customObject = new CustomClass("Hello", 123, true);
        printFields(customObject);
        modifyField(customObject, "field2", 456);
        printFields(customObject);

        // Create a generic class that can store a list of elements of any type and add elements to it using List<T> and add()
        GenericClass<Integer> intList = new GenericClass<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println(intList.getList());

        GenericClass<String> stringList = new GenericClass<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        System.out.println(stringList.getList());
    }

    public static void printFields(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " - " + field.getType() + " : " + field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void modifyField(Object object, String fieldName, Object value) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static class CustomClass {
        private String field1;
        private int field2;
        private boolean field3;

        public CustomClass(String field1, int field2, boolean field3) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }
    }

    public static class GenericClass<T> {
        private List<T> list;

        public GenericClass() {
            list = new ArrayList<>();
        }

        public void add(T element) {
            list.add(element);
        }

        public List<T> getList() {
            return list;
        }
    }
}
