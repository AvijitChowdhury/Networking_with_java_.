public class MainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current thread: "+ t);

        //change current thread name
         t.setName("My Thread");
        System.out.println("After name change : "+ t);

        for(int n=5; n>0 ;n--){
            System.out.println(n);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
