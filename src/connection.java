public class connection {

    private float poid;
    private neurone neuroneGauche;
    private neurone neuroneDroite;

    public connection(float poid){
        this.poid = poid;
        this.neuroneDroite = new neurone();
        this.neuroneGauche = new neurone();
    }
}
