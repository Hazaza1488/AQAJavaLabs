package Task4;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiting for a signal...");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Signal received. Resuming execution.");
            }
        });

        Thread signalingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Signal sent.");
                lock.notify();
            }
        });

        waitingThread.start();
        signalingThread.start();

        MyClass myObject = new MyClass();
        myObject.number = 10;
        myObject.text = "Hello";

        // Displaying fields and their types
        Field[] fields = myObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
        }

        // Changing the value of a specific field
        try {
            Field textField = myObject.getClass().getDeclaredField("text");
            textField.setAccessible(true);
            textField.set(myObject, "Modified text");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Displaying the object before and after the changes
        System.out.println("Object before changes: " + myObject.toString());

        try {
            Field textField = myObject.getClass().getDeclaredField("text");
            textField.setAccessible(true);
            textField.set(myObject, "Modified text");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("Object after changes: " + myObject.toString());

        GenericClass<String> stringClass = new GenericClass<>();
        stringClass.add("Element 1");
        stringClass.add("Element 2");

        List<String> stringElements = stringClass.getElements();
        for (String element : stringElements) {
            System.out.println(element);
        }

        GenericClass<Integer> integerClass = new GenericClass<>();
        integerClass.add(1);
        integerClass.add(2);

        List<Integer> integerElements = integerClass.getElements();
        for (Integer element : integerElements) {
            System.out.println(element);
        }
    }
}

class MyClass {
    private int number;
    private String text;

    @Override
    public String toString() {
        return "MyClass{" +
                "number=" + number +
                ", text='" + text + '\'' +
                '}';
    }
}

class GenericClass<T> {
    private List<T> elements;

    public GenericClass() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public List<T> getElements() {
        return elements;
    }
}