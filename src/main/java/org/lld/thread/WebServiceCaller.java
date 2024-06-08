package org.lld.thread;

public class WebServiceCaller implements Runnable {

    private final String url;


    public WebServiceCaller(String url) {
        this.url = url;

    }


    @Override
    public void run() {
        System.out.println("Calling web service at: " + url);

    }

    public static void main(String[] args) {
        String url = "http://example.com/api";

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new WebServiceCaller(url));
            thread.start();
        }

    }
}
