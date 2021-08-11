import java.util.*;

class second extends Thread {
    public int x;

    public second(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("Second thread : Square of the number is " + x * x);

    }
}

class third extends Thread {
    public int x;

    public third(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("Third thread : Cube of the number is " + x * x * x);

    }
}

class first extends Thread {
    public void run() {
        int num = 0;
        Random r = new Random();
        // generate random number
        try {
            for (int i = 0; i < 3; i++) {
                num = r.nextInt(10);
                System.out.println("First thread generated number is " + num);

                Thread.sleep(1000); // sleep for 1 second
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ThreadDemo {

    public static void main(String[] args) {
        Thread t1 = new first();
        Thread t2 = new second(2);
        Thread t3 = new third(3);

        t2.start();
        t3.start();
        t1.start();

        // Thread t1 = new Thread(new first());

    }

}
