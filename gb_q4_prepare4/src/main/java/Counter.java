import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    int data = 0;

    private void  incr(Lock lock){
        if(lock.tryLock()){
            try {
                data++;
                System.out.println(data);
            } finally {
                lock.unlock();
            }
        }
    }

    Thread getThread(Lock lock){
        return new Thread(()-> {
            while (data < 10000) {
                incr(lock);
            }
        });
    }

    public static void main(String[] args) {

        Lock myLock= new ReentrantLock(true);

        Counter ctr= new Counter();

        Thread thr1 = ctr.getThread(myLock);
        Thread thr2 = ctr.getThread(myLock);
        Thread thr3 = ctr.getThread(myLock);
        Thread thr4 = ctr.getThread(myLock);
        Thread thr5 = ctr.getThread(myLock);
        Thread thr6 = ctr.getThread(myLock);
        Thread thr7 = ctr.getThread(myLock);

        thr1.start();
        thr2.start();
        thr3.start();
        thr4.start();
        thr5.start();
        thr6.start();
        thr7.start();

    }

}
