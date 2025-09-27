package Concurrency.Direct;

public class MyController implements common.Controller {

    private Model model;
    private MyView view;

    public MyController(Model m){
        this.model = m;
    }

    public void setView(MyView v){
        this.view = v;
    }

    public synchronized void increment(){
        model.incrementState();
        view.update();
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
