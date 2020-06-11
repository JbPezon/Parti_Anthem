import java.util.ArrayList;

public class neurone {
    private float bias;
    private int data;
    private ArrayList<connection> conectionEntre;
    private ArrayList<connection> conectionSortie;

    public neurone(float bias){
        this.bias=bias;
        this.data=0;
        this.conectionEntre= new ArrayList<connection>();
        this.conectionSortie= new ArrayList<connection>();
    }
}
