package MVC.Direct;

public class MyController implements common.Controller {

    private Model model;
    private InputGUIView view;

    public MyController(Model m){
        this.model = m;
    }

    public void setView(InputGUIView v){
        this.view = v;
    }

    public void increment(){
        model.incrementState();
        view.update();
    }
}
