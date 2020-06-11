import java.util.ArrayList;

public class layer {

    private int nombreneurone;
    private ArrayList<neurone> myNeurone;

    public layer(int nbneurone){
        this.nombreneurone=nbneurone;
        this.myNeurone= new ArrayList<neurone>();
    }

    public int getNombreneurone() {
        return nombreneurone;
    }

    public void setNombreneurone(int nombreneurone) {
        this.nombreneurone = nombreneurone;
    }

    public ArrayList<neurone> getMyNeurone() {
        return myNeurone;
    }

    public void setMyNeurone(ArrayList<neurone> myNeurone) {
        this.myNeurone = myNeurone;
    }
}
