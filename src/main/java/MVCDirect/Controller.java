package MVCDirect;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model m){
        this.model = m;
    }

    public void setView(View v){
        this.view = v;
    }

    public void increment(){
        model.incrementState();
        view.update();
    }
}
