package Extensions.Direct;

public class Model {
    int state;

    public Model(){
        state = 0;
    }

    public void incrementState() {
        state++;
    }

    public int getState() {
        return state;
    }

}
