import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable{
    BlockingQueue<String> q;
    Thread t;
    String name;


    Consumer(BlockingQueue<String> q, String name){
        this.q= q;
        this.name = name;
        t= new Thread(this, name);

        t.start();
    }
    @Override
    public void run() {
        System.out.println(name+ "started.........");
        int i=0 ;
        while(true){
            if(q.size()==0){
                System.out.println(name+ "queue is empty.........");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println(name + " got "+ q.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
