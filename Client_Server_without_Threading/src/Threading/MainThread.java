package Threading;

public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: "+ t);

    }
}
