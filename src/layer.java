import java.util.ArrayList;

public class layer {

    private int nombreneurone;
    private ArrayList<neurone> myNeurone;

    public layer(int nbneurone){
        this.nombreneurone=nbneurone;
        this.myNeurone= new ArrayList<neurone>();

    }
}
