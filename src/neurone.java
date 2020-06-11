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

    public void addConnectionEntre(connection co){
        this.conectionEntre.add(co);
    }

    public void addConnectionSortie(connection co){
        this.conectionSortie.add(co);
    }

    public float getBias() {
        return bias;
    }

    public void setBias(float bias) {
        this.bias = bias;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ArrayList<connection> getConectionEntre() {
        return conectionEntre;
    }

    public void setConectionEntre(ArrayList<connection> conectionEntre) {
        this.conectionEntre = conectionEntre;
    }

    public ArrayList<connection> getConectionSortie() {
        return conectionSortie;
    }

    public void setConectionSortie(ArrayList<connection> conectionSortie) {
        this.conectionSortie = conectionSortie;
    }
}
