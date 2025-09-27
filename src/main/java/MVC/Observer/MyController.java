package MVC.Observer;

public class MyController implements common.Controller {
    private Model model;

    public MyController(Model m){
        this.model = m;
    }

    public void increment(){
        model.incrementState();
    }
}
