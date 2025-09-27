package MVC.Direct;

public class MyController implements common.Controller {

    private Model model;
    private MyView view;

    public MyController(Model m){
        this.model = m;
    }

    public void setView(MyView v){
        this.view = v;
    }

    public void increment(){
        model.incrementState();
        view.update();
    }
}
