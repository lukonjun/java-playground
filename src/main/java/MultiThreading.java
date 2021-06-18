import javax.swing.plaf.TableHeaderUI;

public class MultiThreading {

    /**
     * Advantages of Multithreading
     * - Better CPU Utilization
     * - Better IO Utilization (Multiple Download, Concurrent IO Downloading/Writing)
     * - Higher application responsiveness (User Interface, Switch between UI Thread and long running task)
     * Detailed Documentation:
     * http://tutorials.jenkov.com/java-concurrency/index.html
     * https://www.youtube.com/watch?v=eQk5AWcTS8w&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&index=2
     *
     * Method shows different ways to start a Thread
     *
     * @param args
     */
    public static void main(String[] args) {

        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("I am a Thread");
            }
        };
        t.start();

        // Implementation with Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " running");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(threadName + " finished");
            }
        };

        Thread threadRunnableInterface = new Thread( runnable, "The Thread");
        threadRunnableInterface.start();

        // Define Runnable with Lambda Expression
        Runnable runnableLambda = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");
            System.out.println(threadName + " finished");
        };

        new Thread(runnable, "The Lambda Thread").start();

        // TODO Stop a Thread, join a Thread, Make a Thread a Daemonthread
    }

}
