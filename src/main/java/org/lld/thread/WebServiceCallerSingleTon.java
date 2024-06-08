package org.lld.thread;


public class WebServiceCallerSingleTon implements Runnable {


    private static WebServiceCallerSingleTon instance;
    private final String url;

    //Constructor
    private WebServiceCallerSingleTon(String url) {
        this.url = url;
        System.out.println("Singleton instance created with URL: " + url);

    }


    public static WebServiceCallerSingleTon getInstance(String url) {
        if (instance == null) {
            instance = new WebServiceCallerSingleTon(url);
        }else {
            System.out.println("Using existing singleton instance with URL: " + instance.url);
        }
        return instance;
    }

    public static void main(String[] args) {
        String url = "http://example.com/api";

        //Getting singleton instace or object of class WebServiceCallerSingleTon

        for (int i = 0; i < 5; i++) {
            WebServiceCallerSingleTon webServiceCallerSingleTon = WebServiceCallerSingleTon.getInstance(url);

//            Thread thread = new Thread(new WebServiceCaller(url)); non singleton
            Thread thread = new Thread(webServiceCallerSingleTon);

            thread.start();
        }

    }

    @Override
    public void run() {
        System.out.println("Singleton thread running with URL: " + url);

    }
}
