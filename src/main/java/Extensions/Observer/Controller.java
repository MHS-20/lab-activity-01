package Extensions.Observer;

public class Controller implements common.Controller {
    private Model model;

    public Controller(Model m){
        this.model = m;
    }

    public void increment(){
        model.incrementState();
    }
}
