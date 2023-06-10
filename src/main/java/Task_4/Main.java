package Task_4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

// Custom class with constructors
class MyClass {
    private int value;

    public MyClass() {
        this.value = 0;
    }

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// Generic interface
interface MyInterface<T> {
    void process(T item);
}

// Concrete class implementing the generic interface
class MyImplementation implements MyInterface<String> {
    @Override
    public void process(String item) {
        System.out.println("Processing item: " + item);
    }
}

public class Main {
    public static void main(String[] args) {
        // Using CountDownLatch to wait for threads to complete
        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                // Perform some work
                System.out.println("Thread " + Thread.currentThread().getId() + " started working.");
                try {
                    Thread.sleep(2000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getId() + " finished working.");

                latch.countDown();
            });
            thread.start();
        }

        try {
            latch.await(); // Wait for all threads to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed. Continuing execution in the main thread.");

        // Creating an instance of custom class and printing constructors
        MyClass obj = new MyClass();
        Class<? extends MyClass> cls = obj.getClass();
        Constructor<?>[] constructors = cls.getDeclaredConstructors();

        System.out.println("Constructors of MyClass:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        // Creating a new instance using a specific constructor
        try {
            Constructor<?> specificConstructor = cls.getDeclaredConstructor(int.class);
            specificConstructor.setAccessible(true);
            MyClass newObj = (MyClass) specificConstructor.newInstance(42);
            System.out.println("New instance created using specific constructor. Value: " + newObj.getValue());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // Creating an instance of concrete class implementing generic interface
        MyInterface<String> myObject = new MyImplementation();
        myObject.process("Example Item");
    }
}
