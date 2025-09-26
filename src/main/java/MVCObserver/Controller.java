package MVCObserver;

public class Controller {
    private Model model;

    public Controller(Model m){
        this.model = m;
    }

    public void increment(){
        model.incrementState();
    }
}
