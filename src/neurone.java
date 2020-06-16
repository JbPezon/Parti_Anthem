import java.util.ArrayList;

public class neurone {
    private float bias;
    private float data;
    private ArrayList<connection> connectionEntre;
    private ArrayList<connection> connectionSortie;

    public neurone(float bias){
        this.bias=bias;
        this.data=0;
        this.connectionEntre = new ArrayList<connection>();
        this.connectionSortie = new ArrayList<connection>();
    }

    public void addConnectionEntre(connection co){
        this.connectionEntre.add(co);
    }

    public void addConnectionSortie(connection co){
        this.connectionSortie.add(co);
    }


    public float getBias() {
        return bias;
    }

    public void setBias(float bias) {
        this.bias = bias;
    }

    public float getData() {
        return data;
    }

    public void setData(float data) {
        this.data = data;
    }

    public ArrayList<connection> getConnectionEntre() {
        return connectionEntre;
    }

    public void setConnectionEntre(ArrayList<connection> connectionEntre) {
        this.connectionEntre = connectionEntre;
    }

    public ArrayList<connection> getConnectionSortie() {
        return connectionSortie;
    }

    public void setConnectionSortie(ArrayList<connection> connectionSortie) {
        this.connectionSortie = connectionSortie;
    }
}
