package Extensions.Direct;

import common.View;

import java.util.ArrayList;
import java.util.List;

public class MyController implements common.Controller {

    private Model model;
    private List<View> views = new ArrayList<>();

    public MyController(Model m){
        this.model = m;
    }

    public void setView(View v){
        this.views.add(v);
    }

    public void increment(){
        model.incrementState();
        views.forEach(View::update);
    }
}
