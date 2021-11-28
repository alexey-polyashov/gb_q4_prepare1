public class PingPong {

    private String word = "";

    private Thread runPing(PingPong pp){

        Thread thr1 = new Thread(()->{
            synchronized (pp){
                while(!Thread.interrupted()) {
                    while (pp.word.equals("ping")) {
                        try {
                            wait(10);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                    pp.word = "ping";
                    System.out.println(pp.word);
                    notify();
                }
            }
        });
        return thr1;

    }

    private Thread runPong(PingPong pp){

        Thread thr2 = new Thread(()->{
            synchronized (pp){
                while(!Thread.interrupted()) {
                    while (pp.word.equals("pong")) {
                        try {
                            wait(10);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                    pp.word = "pong";
                    System.out.println(pp.word);
                    notify();
                }
            }
        });
        return thr2;

    }

    public static void  main(String[] args) throws InterruptedException {

        PingPong pp = new PingPong();

        Thread ping = pp.runPing(pp);
        Thread pong = pp.runPong(pp);
        ping.start();
        pong.start();

        Thread.sleep(3000);

        ping.interrupt();
        pong.interrupt();

    }

}
