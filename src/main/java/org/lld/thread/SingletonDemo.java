package org.lld.thread;

// Singleton class
class Singleton {
    private static Singleton instance;
    private static int instanceCount = 0;

    private Singleton() {
        instanceCount++;
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}

// Non-singleton class
class NonSingleton {
    private static int instanceCount = 0;

    public NonSingleton() {
        instanceCount++;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}

public class SingletonDemo {
    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(()->{
            // Creating instances of Singleton and NonSingleton classes
            Singleton singleton1 = Singleton.getInstance();
            System.out.println("Thread 1 - Singleton Instance Count: " + Singleton.getInstanceCount());


            NonSingleton nonSingleton1 = new NonSingleton();
            System.out.println("Thread 1 - Non-Singleton Instance Count: " + NonSingleton.getInstanceCount());

        });

        Thread thread2 = new Thread(()->{
            // Creating instances of Singleton and NonSingleton classes
            Singleton singleton1 = Singleton.getInstance();
            System.out.println("Thread 2 - Singleton Instance Count: " + Singleton.getInstanceCount());


            NonSingleton nonSingleton1 = new NonSingleton();
            System.out.println("Thread 2 - Non-Singleton Instance Count: " + NonSingleton.getInstanceCount());

        });

        // Starting threads
        thread1.start();
        thread2.start();

        // Logging the join process
        System.out.println("Main Thread - Waiting for Thread 1 and Thread 2 to finish...");
        // Waiting for threads to finish
        try{
            thread1.join();
            System.out.println("Main Thread - Thread 1 has finished.\n");
            Thread.sleep(5000);

            thread2.join();
            System.out.println("Main Thread - Thread 2 has finished.");

        }catch (InterruptedException e){
            e.printStackTrace();
        }




        // Printing instance counts
        System.out.println("Singleton Instance Count: " + Singleton.getInstanceCount());
        System.out.println("Non-Singleton Instance Count: " + NonSingleton.getInstanceCount());
    }
}
