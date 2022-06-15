
class Printer {
   //void printAssignment(String name,int pages){
    //synchronized void printAssignment(Person p ){
    void printAssignment(Person p){
       System.out.println(p.name + "--> Printing started............");

       for(int i=0 ;i<p.pages;i++){
           System.out.println(p.name + "--> printed page# "+ (i+1));
       }
       System.out.println(p.name+ "--> Printing ended............");

   }
}

class Person implements Runnable{
    String name;
    Printer printer;
    int pages;
    Thread t;
    Person(String name , Printer p , int pages){
        this.name = name ;
        this.printer = p;
        this.pages = pages;
        t = new Thread(this , name);
        t.start();
    }
    void startPrinting(){

    }
    @Override
    public void run() {
        //printer.printAssignment(name , pages);
        //printer.printAssignment(this);
        synchronized (printer){
            printer.printAssignment(this);
        }
    }
}

public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person Avijit = new Person("Avijit",printer,8 );
        Person Arshad = new Person("Arshad", printer,9);
        Person Namir = new Person( "Namir", printer , 5);
    }
}
