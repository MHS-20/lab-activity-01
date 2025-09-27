package Concurrency.Observer;

public class MyController implements common.Controller {
    private Model model;

    public MyController(Model m){
        this.model = m;
    }

    public synchronized void increment(){
        model.incrementState();
    }

    public void start(){
        new Thread(() -> {
            while (true) {
                increment();
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }
}
