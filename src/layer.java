import java.util.ArrayList;

public class layer {

    private int nbNeurone;
    private ArrayList<neurone> myNeurone;

    public layer(int nbNeurone){
        this.nbNeurone =nbNeurone;
        this.myNeurone= new ArrayList<neurone>();
    }

    public void remplieLayer(){
        for (int i = 0; i < this.nbNeurone ; i++) {
            this.myNeurone.add(new neurone((float)(Math.random()*2)-1));
        }
    }

    public void creerConnection(layer layerSortie){
        for (neurone nIn: this.myNeurone) {
            for (neurone nOut: layerSortie.getMyNeurone()) {
                connection nouvelleConnection = new connection((float)Math.random());
                nouvelleConnection.setNeuroneGauche(nIn);
                nouvelleConnection.setNeuroneGauche(nOut);
                nIn.addConnectionSortie(nouvelleConnection);
                nOut.addConnectionEntre(nouvelleConnection);
            }
        }
    }

    public int getNbNeurone() {
        return nbNeurone;
    }

    public void setNbNeurone(int nbNeurone) {
        this.nbNeurone = nbNeurone;
    }

    public ArrayList<neurone> getMyNeurone() {
        return myNeurone;
    }

    public void setMyNeurone(ArrayList<neurone> myNeurone) {
        this.myNeurone = myNeurone;
    }
}
