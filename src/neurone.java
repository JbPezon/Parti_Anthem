import java.util.ArrayList;

public class neurone {
    private float bias;
    private int data;
    private ArrayList<connection> lien;


    public neurone(float bias){
        this.bias=bias;
        this.data=0;
        this.lien= new ArrayList<connection>();
    }
}
